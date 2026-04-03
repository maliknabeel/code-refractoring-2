package com.refactoring.examples.controller;

import com.refactoring.examples.model.RefactoringTechniqueResponse;
import com.refactoring.examples.techniques.organizingdata.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/organizing-data")
public class OrganizingDataController {

    private static final String CATEGORY = "Organizing Data";

    private static final Map<String, RefactoringTechniqueResponse> TECHNIQUES;

    static {
        TECHNIQUES = new LinkedHashMap<>();
        TECHNIQUES.put("self-encapsulate-field",
            new RefactoringTechniqueResponse("Self Encapsulate Field", CATEGORY,
                SelfEncapsulateFieldExample.getDescription(),
                SelfEncapsulateFieldExample.getBadCode(),
                SelfEncapsulateFieldExample.getGoodCode()));
        TECHNIQUES.put("replace-data-value-with-object",
            new RefactoringTechniqueResponse("Replace Data Value with Object", CATEGORY,
                ReplaceDataValueWithObjectExample.getDescription(),
                ReplaceDataValueWithObjectExample.getBadCode(),
                ReplaceDataValueWithObjectExample.getGoodCode()));
        TECHNIQUES.put("replace-array-with-object",
            new RefactoringTechniqueResponse("Replace Array with Object", CATEGORY,
                ReplaceArrayWithObjectExample.getDescription(),
                ReplaceArrayWithObjectExample.getBadCode(),
                ReplaceArrayWithObjectExample.getGoodCode()));
        TECHNIQUES.put("replace-magic-number",
            new RefactoringTechniqueResponse("Replace Magic Number with Symbolic Constant", CATEGORY,
                ReplaceMagicNumberExample.getDescription(),
                ReplaceMagicNumberExample.getBadCode(),
                ReplaceMagicNumberExample.getGoodCode()));
        TECHNIQUES.put("encapsulate-field",
            new RefactoringTechniqueResponse("Encapsulate Field", CATEGORY,
                EncapsulateFieldExample.getDescription(),
                EncapsulateFieldExample.getBadCode(),
                EncapsulateFieldExample.getGoodCode()));
        TECHNIQUES.put("encapsulate-collection",
            new RefactoringTechniqueResponse("Encapsulate Collection", CATEGORY,
                EncapsulateCollectionExample.getDescription(),
                EncapsulateCollectionExample.getBadCode(),
                EncapsulateCollectionExample.getGoodCode()));
        TECHNIQUES.put("replace-type-code-with-class",
            new RefactoringTechniqueResponse("Replace Type Code with Class", CATEGORY,
                ReplaceTypeCodeWithClassExample.getDescription(),
                ReplaceTypeCodeWithClassExample.getBadCode(),
                ReplaceTypeCodeWithClassExample.getGoodCode()));
        TECHNIQUES.put("replace-type-code-with-subclasses",
            new RefactoringTechniqueResponse("Replace Type Code with Subclasses", CATEGORY,
                ReplaceTypeCodeWithSubclassesExample.getDescription(),
                ReplaceTypeCodeWithSubclassesExample.getBadCode(),
                ReplaceTypeCodeWithSubclassesExample.getGoodCode()));
        TECHNIQUES.put("replace-type-code-with-state-strategy",
            new RefactoringTechniqueResponse("Replace Type Code with State/Strategy", CATEGORY,
                ReplaceTypeCodeWithStateStrategyExample.getDescription(),
                ReplaceTypeCodeWithStateStrategyExample.getBadCode(),
                ReplaceTypeCodeWithStateStrategyExample.getGoodCode()));
        TECHNIQUES.put("replace-subclass-with-fields",
            new RefactoringTechniqueResponse("Replace Subclass with Fields", CATEGORY,
                ReplaceSubclassWithFieldsExample.getDescription(),
                ReplaceSubclassWithFieldsExample.getBadCode(),
                ReplaceSubclassWithFieldsExample.getGoodCode()));
    }

    @GetMapping
    public List<RefactoringTechniqueResponse> getAllTechniques() {
        return List.copyOf(TECHNIQUES.values());
    }

    @GetMapping("/{technique}")
    public RefactoringTechniqueResponse getTechnique(@PathVariable String technique) {
        RefactoringTechniqueResponse response = TECHNIQUES.get(technique);
        if (response == null) {
            throw new IllegalArgumentException("Technique not found: " + technique);
        }
        return response;
    }
}
