#!/usr/bin/env python3
"""
Refactoring script: Extract BadExample and GoodExample inner classes to separate files.
"""

import os
import re

BASE_SRC = "src/main/java/com/refactoring/examples/techniques"
BASE_TEST = "src/test/java/com/refactoring/examples/techniques"

CATEGORIES = {
    "composingmethods": "com.refactoring.examples.techniques.composingmethods",
    "generalization": "com.refactoring.examples.techniques.generalization",
    "movingfeatures": "com.refactoring.examples.techniques.movingfeatures",
    "organizingdata": "com.refactoring.examples.techniques.organizingdata",
    "simplifyingconditionals": "com.refactoring.examples.techniques.simplifyingconditionals",
    "simplifyingmethodcalls": "com.refactoring.examples.techniques.simplifyingmethodcalls",
}

TEST_FILES = {
    "composingmethods": "ComposingMethodsTest.java",
    "generalization": "DealingWithGeneralizationTest.java",
    "movingfeatures": "MovingFeaturesTest.java",
    "organizingdata": "OrganizingDataTest.java",
    "simplifyingconditionals": "SimplifyingConditionalsTest.java",
    "simplifyingmethodcalls": "SimplifyingMethodCallsTest.java",
}


def extract_inner_class(content, class_name):
    """
    Extract 'public static class <class_name> { ... }' from content.
    Returns (class_body_lines, start_pos, end_pos) where class_body_lines
    is the lines inside the class (de-indented by 4 spaces).
    Returns None if not found.
    """
    # Find "public static class BadExample {" or "public static class GoodExample {"
    pattern = re.compile(
        r'(\n    public static class ' + re.escape(class_name) + r'\s*\{)', 
    )
    m = pattern.search(content)
    if not m:
        return None

    start = m.start()
    # Find the opening brace
    brace_pos = content.index('{', m.end() - 1)
    
    # Track nested braces
    depth = 1
    pos = brace_pos + 1
    while pos < len(content) and depth > 0:
        if content[pos] == '{':
            depth += 1
        elif content[pos] == '}':
            depth -= 1
        pos += 1
    
    end = pos  # pos is now after the closing }
    
    # Extract body: everything between opening { and closing }
    body = content[brace_pos + 1:pos - 1]
    
    # De-indent the body by 4 spaces (remove one level of indentation)
    body_lines = body.split('\n')
    de_indented = []
    for line in body_lines:
        if line.startswith('    '):
            de_indented.append(line[4:])
        elif line == '' or line.strip() == '':
            de_indented.append('')
        else:
            de_indented.append(line)
    
    return de_indented, start, end


def get_imports_from_file(content):
    """Extract import statements from file."""
    imports = []
    for line in content.split('\n'):
        if line.startswith('import '):
            imports.append(line)
    return imports


def create_extracted_class_file(technique_name, class_suffix, body_lines, 
                                  package, orig_imports):
    """Create content for an extracted class file."""
    new_class_name = technique_name + class_suffix
    sub_pkg = "bad" if class_suffix == "BadExample" else "good"
    new_package = package + "." + sub_pkg
    
    lines = []
    lines.append(f"package {new_package};")
    lines.append("")
    
    # Add original imports
    for imp in orig_imports:
        lines.append(imp)
    
    # Add wildcard import for parent package
    lines.append(f"import {package}.*;")
    lines.append("")
    
    lines.append(f"public class {new_class_name} {{")
    
    # Add the body
    # Strip leading/trailing blank lines from body
    body = body_lines
    while body and body[0].strip() == '':
        body = body[1:]
    while body and body[-1].strip() == '':
        body = body[:-1]
    
    for line in body:
        lines.append(line)
    
    lines.append("}")
    lines.append("")
    
    return '\n'.join(lines)


def remove_inner_class_from_content(content, class_name):
    """Remove 'public static class <class_name> { ... }' block from content."""
    pattern = re.compile(
        r'\n    public static class ' + re.escape(class_name) + r'\s*\{'
    )
    m = pattern.search(content)
    if not m:
        return content

    start = m.start()
    brace_pos = content.index('{', m.end() - 1)
    
    depth = 1
    pos = brace_pos + 1
    while pos < len(content) and depth > 0:
        if content[pos] == '{':
            depth += 1
        elif content[pos] == '}':
            depth -= 1
        pos += 1
    
    # Remove from start (which is \n) to pos
    # Also handle trailing newline
    end = pos
    if end < len(content) and content[end] == '\n':
        end += 1
    
    return content[:start] + content[end:]


def process_technique_file(filepath, category):
    """Process a single technique file, extracting inner classes."""
    with open(filepath, 'r') as f:
        content = f.read()
    
    # Get technique name from filename
    filename = os.path.basename(filepath)
    technique_name = filename.replace('.java', '')
    
    package = CATEGORIES[category]
    orig_imports = get_imports_from_file(content)
    
    # Check if inner classes exist
    has_bad = bool(re.search(r'public static class BadExample', content))
    has_good = bool(re.search(r'public static class GoodExample', content))
    
    if not has_bad and not has_good:
        print(f"  SKIP {filename}: no inner classes found")
        return []
    
    created_files = []
    
    # Extract BadExample
    if has_bad:
        result = extract_inner_class(content, "BadExample")
        if result:
            body_lines, _, _ = result
            sub_dir = os.path.join(os.path.dirname(filepath), "bad")
            os.makedirs(sub_dir, exist_ok=True)
            new_filename = f"{technique_name}BadExample.java"
            new_filepath = os.path.join(sub_dir, new_filename)
            file_content = create_extracted_class_file(
                technique_name, "BadExample", body_lines, package, orig_imports
            )
            with open(new_filepath, 'w') as f:
                f.write(file_content)
            created_files.append(new_filepath)
            print(f"  Created: {new_filepath}")
    
    # Extract GoodExample
    if has_good:
        result = extract_inner_class(content, "GoodExample")
        if result:
            body_lines, _, _ = result
            sub_dir = os.path.join(os.path.dirname(filepath), "good")
            os.makedirs(sub_dir, exist_ok=True)
            new_filename = f"{technique_name}GoodExample.java"
            new_filepath = os.path.join(sub_dir, new_filename)
            file_content = create_extracted_class_file(
                technique_name, "GoodExample", body_lines, package, orig_imports
            )
            with open(new_filepath, 'w') as f:
                f.write(file_content)
            created_files.append(new_filepath)
            print(f"  Created: {new_filepath}")
    
    # Remove inner classes from original file
    new_content = content
    if has_bad:
        new_content = remove_inner_class_from_content(new_content, "BadExample")
    if has_good:
        new_content = remove_inner_class_from_content(new_content, "GoodExample")
    
    # Clean up trailing whitespace in original file
    # Make sure file ends with single newline and no double-blank lines before closing brace
    with open(filepath, 'w') as f:
        f.write(new_content)
    
    print(f"  Updated: {filepath}")
    return created_files


def update_test_file(test_filepath, category, technique_files):
    """Update test file to use new class names and imports."""
    with open(test_filepath, 'r') as f:
        content = f.read()
    
    package = CATEGORIES[category]
    
    # Add bad/good imports after the existing wildcard import
    # Find the category wildcard import line
    wildcard_import = f"import {package}.*;"
    bad_import = f"import {package}.bad.*;"
    good_import = f"import {package}.good.*;"
    
    # Add new imports if not already there
    if bad_import not in content and good_import not in content:
        content = content.replace(
            wildcard_import,
            wildcard_import + "\n" + bad_import + "\n" + good_import
        )
    
    # Replace all SomeExample.BadExample.InnerClass -> SomeExampleBadExample.InnerClass
    # and SomeExample.GoodExample.InnerClass -> SomeExampleGoodExample.InnerClass
    # and SomeExample.BadExample -> SomeExampleBadExample
    # and SomeExample.GoodExample -> SomeExampleGoodExample
    
    for technique_file in technique_files:
        technique_name = os.path.basename(technique_file).replace('.java', '')
        
        # Replace XxxExample.BadExample.InnerClass -> XxxExampleBadExample.InnerClass
        content = re.sub(
            re.escape(technique_name) + r'\.BadExample\.(\w+)',
            technique_name + r'BadExample.\1',
            content
        )
        content = re.sub(
            re.escape(technique_name) + r'\.GoodExample\.(\w+)',
            technique_name + r'GoodExample.\1',
            content
        )
        
        # Replace XxxExample.BadExample -> XxxExampleBadExample
        content = content.replace(
            technique_name + ".BadExample",
            technique_name + "BadExample"
        )
        content = content.replace(
            technique_name + ".GoodExample",
            technique_name + "GoodExample"
        )
    
    with open(test_filepath, 'w') as f:
        f.write(content)
    
    print(f"  Updated test: {test_filepath}")


def main():
    for category, package in CATEGORIES.items():
        category_dir = os.path.join(BASE_SRC, category)
        if not os.path.isdir(category_dir):
            print(f"WARNING: directory not found: {category_dir}")
            continue
        
        print(f"\nProcessing category: {category}")
        
        # Get all technique Java files (not in subdirectories)
        technique_files = []
        for filename in sorted(os.listdir(category_dir)):
            if filename.endswith('.java') and not filename.startswith('.'):
                filepath = os.path.join(category_dir, filename)
                if os.path.isfile(filepath):
                    technique_files.append(filepath)
                    process_technique_file(filepath, category)
        
        # Update test file
        test_filename = TEST_FILES.get(category)
        if test_filename:
            test_filepath = os.path.join(BASE_TEST, test_filename)
            if os.path.exists(test_filepath):
                update_test_file(test_filepath, category, technique_files)
            else:
                print(f"  WARNING: test file not found: {test_filepath}")
    
    print("\nDone!")


if __name__ == "__main__":
    main()
