package edu.pafiast.refractoring.controller;

import edu.pafiast.refractoring.model.RefactoringTechniqueResponse;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/simplifying-conditionals")
public class SimplifyingConditionalsController {

    private static final String CATEGORY = "Simplifying Conditional Expressions";

    private static final Map<String, RefactoringTechniqueResponse> TECHNIQUES = Map.of(
        "decompose-conditional",
            new RefactoringTechniqueResponse("Decompose Conditional", CATEGORY,
                DecomposeConditionalExample.getDescription(),
                DecomposeConditionalExample.getBadCode(),
                DecomposeConditionalExample.getGoodCode()),
        "consolidate-conditional",
            new RefactoringTechniqueResponse("Consolidate Conditional Expression", CATEGORY,
                ConsolidateConditionalExample.getDescription(),
                ConsolidateConditionalExample.getBadCode(),
                ConsolidateConditionalExample.getGoodCode()),
        "consolidate-duplicate-fragments",
            new RefactoringTechniqueResponse("Consolidate Duplicate Conditional Fragments", CATEGORY,
                ConsolidateDuplicateFragmentsExample.getDescription(),
                ConsolidateDuplicateFragmentsExample.getBadCode(),
                ConsolidateDuplicateFragmentsExample.getGoodCode()),
        "remove-control-flag",
            new RefactoringTechniqueResponse("Remove Control Flag", CATEGORY,
                RemoveControlFlagExample.getDescription(),
                RemoveControlFlagExample.getBadCode(),
                RemoveControlFlagExample.getGoodCode()),
        "replace-nested-conditional",
            new RefactoringTechniqueResponse("Replace Nested Conditional with Guard Clauses", CATEGORY,
                ReplaceNestedConditionalExample.getDescription(),
                ReplaceNestedConditionalExample.getBadCode(),
                ReplaceNestedConditionalExample.getGoodCode()),
        "replace-conditional-with-polymorphism",
            new RefactoringTechniqueResponse("Replace Conditional with Polymorphism", CATEGORY,
                ReplaceConditionalWithPolymorphismExample.getDescription(),
                ReplaceConditionalWithPolymorphismExample.getBadCode(),
                ReplaceConditionalWithPolymorphismExample.getGoodCode()),
        "introduce-null-object",
            new RefactoringTechniqueResponse("Introduce Null Object", CATEGORY,
                IntroduceNullObjectExample.getDescription(),
                IntroduceNullObjectExample.getBadCode(),
                IntroduceNullObjectExample.getGoodCode()),
        "introduce-assertion",
            new RefactoringTechniqueResponse("Introduce Assertion", CATEGORY,
                IntroduceAssertionExample.getDescription(),
                IntroduceAssertionExample.getBadCode(),
                IntroduceAssertionExample.getGoodCode())
    );

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
