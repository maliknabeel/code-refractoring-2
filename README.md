# Code Refactoring Examples

A Spring Boot REST API that teaches code refactoring techniques for BS Software Engineering (6th semester) students. Each technique provides a description, a **bad code** example, and a **good code** example side-by-side.

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+

### Run the application

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.

### Run tests

```bash
mvn test
```

---

## API Reference

### All Techniques

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/techniques` | List all refactoring techniques |
| `GET` | `/api/techniques/categories` | List all categories and their techniques |
| `GET` | `/api/techniques/search?q=keyword` | Search techniques by name, description, or category |
| `GET` | `/api/techniques/{technique}/comparison` | Get bad vs good code comparison for a technique |

### By Category

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/composing-methods` | All Composing Methods techniques |
| `GET` | `/api/composing-methods/{technique}` | A specific Composing Methods technique |
| `GET` | `/api/moving-features` | All Moving Features techniques |
| `GET` | `/api/moving-features/{technique}` | A specific Moving Features technique |
| `GET` | `/api/organizing-data` | All Organizing Data techniques |
| `GET` | `/api/organizing-data/{technique}` | A specific Organizing Data technique |
| `GET` | `/api/simplifying-conditionals` | All Simplifying Conditionals techniques |
| `GET` | `/api/simplifying-conditionals/{technique}` | A specific Simplifying Conditionals technique |
| `GET` | `/api/simplifying-method-calls` | All Simplifying Method Calls techniques |
| `GET` | `/api/simplifying-method-calls/{technique}` | A specific Simplifying Method Calls technique |
| `GET` | `/api/dealing-with-generalization` | All Dealing with Generalization techniques |
| `GET` | `/api/dealing-with-generalization/{technique}` | A specific Dealing with Generalization technique |

---

## Response Format

### Technique response (`RefactoringTechniqueResponse`)

```json
{
  "name": "Extract Method",
  "category": "Composing Methods",
  "description": "When you have a code fragment that can be grouped together...",
  "badCode": "// BAD: One long method doing everything...",
  "goodCode": "// GOOD: Each logical section is its own well-named method..."
}
```

### Comparison response (`RefactoringCodeComparison`)

```json
{
  "name": "Extract Method",
  "category": "Composing Methods",
  "badCode": "// BAD: One long method doing everything...",
  "goodCode": "// GOOD: Each logical section is its own well-named method..."
}
```

### Categories response

```json
{
  "Composing Methods": ["Extract Method", "Inline Method", "..."],
  "Moving Features Between Objects": ["Extract Class", "Move Method", "..."],
  "Organizing Data": ["Encapsulate Field", "Replace Magic Number", "..."],
  "Simplifying Conditional Expressions": ["Decompose Conditional", "..."],
  "Simplifying Method Calls": ["Add Parameter", "Rename Method", "..."],
  "Dealing with Generalization": ["Pull Up Field", "Extract Interface", "..."]
}
```

---

## Refactoring Techniques

### Composing Methods
| Slug | Name |
|------|------|
| `extract-method` | Extract Method |
| `inline-method` | Inline Method |
| `extract-variable` | Extract Variable |
| `inline-temp` | Inline Temp |
| `replace-temp-with-query` | Replace Temp with Query |
| `split-temporary-variable` | Split Temporary Variable |
| `remove-assignments-to-parameters` | Remove Assignments to Parameters |
| `replace-method-with-method-object` | Replace Method with Method Object |
| `substitute-algorithm` | Substitute Algorithm |

### Moving Features Between Objects
| Slug | Name |
|------|------|
| `move-method` | Move Method |
| `move-field` | Move Field |
| `extract-class` | Extract Class |
| `inline-class` | Inline Class |
| `hide-delegate` | Hide Delegate |
| `remove-middle-man` | Remove Middle Man |
| `introduce-foreign-method` | Introduce Foreign Method |
| `introduce-local-extension` | Introduce Local Extension |

### Organizing Data
| Slug | Name |
|------|------|
| `self-encapsulate-field` | Self Encapsulate Field |
| `replace-data-value-with-object` | Replace Data Value with Object |
| `encapsulate-field` | Encapsulate Field |
| `encapsulate-collection` | Encapsulate Collection |
| `replace-array-with-object` | Replace Array with Object |
| `replace-magic-number` | Replace Magic Number |
| `replace-type-code-with-class` | Replace Type Code with Class |
| `replace-type-code-with-subclasses` | Replace Type Code with Subclasses |
| `replace-type-code-with-state-strategy` | Replace Type Code with State/Strategy |
| `replace-subclass-with-fields` | Replace Subclass with Fields |

### Simplifying Conditional Expressions
| Slug | Name |
|------|------|
| `decompose-conditional` | Decompose Conditional |
| `consolidate-conditional` | Consolidate Conditional |
| `consolidate-duplicate-fragments` | Consolidate Duplicate Fragments |
| `remove-control-flag` | Remove Control Flag |
| `replace-nested-conditional` | Replace Nested Conditional |
| `replace-conditional-with-polymorphism` | Replace Conditional with Polymorphism |
| `introduce-null-object` | Introduce Null Object |
| `introduce-assertion` | Introduce Assertion |

### Simplifying Method Calls
| Slug | Name |
|------|------|
| `rename-method` | Rename Method |
| `add-parameter` | Add Parameter |
| `remove-parameter` | Remove Parameter |
| `separate-query-from-modifier` | Separate Query from Modifier |
| `parameterize-method` | Parameterize Method |
| `replace-parameter-with-explicit-methods` | Replace Parameter with Explicit Methods |
| `preserve-whole-object` | Preserve Whole Object |
| `replace-parameter-with-method-call` | Replace Parameter with Method Call |
| `introduce-parameter-object` | Introduce Parameter Object |
| `remove-setting-method` | Remove Setting Method |
| `hide-method` | Hide Method |
| `replace-constructor-with-factory-method` | Replace Constructor with Factory Method |
| `replace-error-code-with-exception` | Replace Error Code with Exception |
| `replace-exception-with-test` | Replace Exception with Test |

### Dealing with Generalization
| Slug | Name |
|------|------|
| `pull-up-field` | Pull Up Field |
| `pull-up-method` | Pull Up Method |
| `pull-up-constructor-body` | Pull Up Constructor Body |
| `push-down-method` | Push Down Method |
| `push-down-field` | Push Down Field |
| `extract-subclass` | Extract Subclass |
| `extract-superclass` | Extract Superclass |
| `extract-interface` | Extract Interface |
| `collapse-hierarchy` | Collapse Hierarchy |
| `form-template-method` | Form Template Method |
| `replace-inheritance-with-delegation` | Replace Inheritance with Delegation |
| `replace-delegation-with-inheritance` | Replace Delegation with Inheritance |

---

## Project Structure

```
src/
├── main/java/com/refactoring/examples/
│   ├── RefactoringApplication.java
│   ├── controller/          # REST controllers per category
│   ├── exception/           # Global error handling
│   ├── model/               # Response models
│   └── techniques/          # Refactoring example classes
│       ├── composingmethods/
│       ├── generalization/
│       ├── movingfeatures/
│       ├── organizingdata/
│       ├── simplifyingconditionals/
│       └── simplifyingmethodcalls/
└── test/java/               # Unit tests per category
```

Each technique class (e.g. `ExtractMethodExample`) contains:
- `getDescription()` — explanation of the technique
- `getBadCode()` — code snippet illustrating the anti-pattern
- `getGoodCode()` — code snippet illustrating the refactored solution
- `BadExample` inner class — runnable bad-code implementation
- `GoodExample` inner class — runnable good-code implementation
