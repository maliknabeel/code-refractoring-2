package edu.pafiast.refractoring.controller;

import edu.pafiast.refractoring.model.RefactoringTechniqueResponse;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/simplifying-method-calls")
public class SimplifyingMethodCallsController {

    private static final String CATEGORY = "Simplifying Method Calls";

    private static final Map<String, RefactoringTechniqueResponse> TECHNIQUES;

    static {
        TECHNIQUES = new LinkedHashMap<>();
        TECHNIQUES.put("rename-method",
            new RefactoringTechniqueResponse("Rename Method", CATEGORY,
                RenameMethodExample.getDescription(),
                RenameMethodExample.getBadCode(),
                RenameMethodExample.getGoodCode()));
        TECHNIQUES.put("add-parameter",
            new RefactoringTechniqueResponse("Add Parameter", CATEGORY,
                AddParameterExample.getDescription(),
                AddParameterExample.getBadCode(),
                AddParameterExample.getGoodCode()));
        TECHNIQUES.put("remove-parameter",
            new RefactoringTechniqueResponse("Remove Parameter", CATEGORY,
                RemoveParameterExample.getDescription(),
                RemoveParameterExample.getBadCode(),
                RemoveParameterExample.getGoodCode()));
        TECHNIQUES.put("separate-query-from-modifier",
            new RefactoringTechniqueResponse("Separate Query from Modifier", CATEGORY,
                SeparateQueryFromModifierExample.getDescription(),
                SeparateQueryFromModifierExample.getBadCode(),
                SeparateQueryFromModifierExample.getGoodCode()));
        TECHNIQUES.put("parameterize-method",
            new RefactoringTechniqueResponse("Parameterize Method", CATEGORY,
                ParameterizeMethodExample.getDescription(),
                ParameterizeMethodExample.getBadCode(),
                ParameterizeMethodExample.getGoodCode()));
        TECHNIQUES.put("replace-parameter-with-explicit-methods",
            new RefactoringTechniqueResponse("Replace Parameter with Explicit Methods", CATEGORY,
                ReplaceParameterWithExplicitMethodsExample.getDescription(),
                ReplaceParameterWithExplicitMethodsExample.getBadCode(),
                ReplaceParameterWithExplicitMethodsExample.getGoodCode()));
        TECHNIQUES.put("preserve-whole-object",
            new RefactoringTechniqueResponse("Preserve Whole Object", CATEGORY,
                PreserveWholeObjectExample.getDescription(),
                PreserveWholeObjectExample.getBadCode(),
                PreserveWholeObjectExample.getGoodCode()));
        TECHNIQUES.put("replace-parameter-with-method-call",
            new RefactoringTechniqueResponse("Replace Parameter with Method Call", CATEGORY,
                ReplaceParameterWithMethodCallExample.getDescription(),
                ReplaceParameterWithMethodCallExample.getBadCode(),
                ReplaceParameterWithMethodCallExample.getGoodCode()));
        TECHNIQUES.put("introduce-parameter-object",
            new RefactoringTechniqueResponse("Introduce Parameter Object", CATEGORY,
                IntroduceParameterObjectExample.getDescription(),
                IntroduceParameterObjectExample.getBadCode(),
                IntroduceParameterObjectExample.getGoodCode()));
        TECHNIQUES.put("remove-setting-method",
            new RefactoringTechniqueResponse("Remove Setting Method", CATEGORY,
                RemoveSettingMethodExample.getDescription(),
                RemoveSettingMethodExample.getBadCode(),
                RemoveSettingMethodExample.getGoodCode()));
        TECHNIQUES.put("hide-method",
            new RefactoringTechniqueResponse("Hide Method", CATEGORY,
                HideMethodExample.getDescription(),
                HideMethodExample.getBadCode(),
                HideMethodExample.getGoodCode()));
        TECHNIQUES.put("replace-constructor-with-factory-method",
            new RefactoringTechniqueResponse("Replace Constructor with Factory Method", CATEGORY,
                ReplaceConstructorWithFactoryMethodExample.getDescription(),
                ReplaceConstructorWithFactoryMethodExample.getBadCode(),
                ReplaceConstructorWithFactoryMethodExample.getGoodCode()));
        TECHNIQUES.put("replace-error-code-with-exception",
            new RefactoringTechniqueResponse("Replace Error Code with Exception", CATEGORY,
                ReplaceErrorCodeWithExceptionExample.getDescription(),
                ReplaceErrorCodeWithExceptionExample.getBadCode(),
                ReplaceErrorCodeWithExceptionExample.getGoodCode()));
        TECHNIQUES.put("replace-exception-with-test",
            new RefactoringTechniqueResponse("Replace Exception with Test", CATEGORY,
                ReplaceExceptionWithTestExample.getDescription(),
                ReplaceExceptionWithTestExample.getBadCode(),
                ReplaceExceptionWithTestExample.getGoodCode()));
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
