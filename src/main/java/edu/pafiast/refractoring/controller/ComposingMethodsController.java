package edu.pafiast.refractoring.controller;

import edu.pafiast.refractoring.model.RefactoringTechniqueResponse;
import edu.pafiast.refractoring.techniques.composingmethods.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/composing-methods")
public class ComposingMethodsController {

    private static final String CATEGORY = "Composing Methods";

    private static final Map<String, RefactoringTechniqueResponse> TECHNIQUES = Map.of(
        "extract-method",
            new RefactoringTechniqueResponse("Extract Method", CATEGORY,
                ExtractMethodExample.getDescription(),
                ExtractMethodExample.getBadCode(),
                ExtractMethodExample.getGoodCode()),
        "inline-method",
            new RefactoringTechniqueResponse("Inline Method", CATEGORY,
                InlineMethodExample.getDescription(),
                InlineMethodExample.getBadCode(),
                InlineMethodExample.getGoodCode()),
        "extract-variable",
            new RefactoringTechniqueResponse("Extract Variable", CATEGORY,
                ExtractVariableExample.getDescription(),
                ExtractVariableExample.getBadCode(),
                ExtractVariableExample.getGoodCode()),
        "inline-temp",
            new RefactoringTechniqueResponse("Inline Temp", CATEGORY,
                InlineTempExample.getDescription(),
                InlineTempExample.getBadCode(),
                InlineTempExample.getGoodCode()),
        "replace-temp-with-query",
            new RefactoringTechniqueResponse("Replace Temp with Query", CATEGORY,
                ReplaceTempWithQueryExample.getDescription(),
                ReplaceTempWithQueryExample.getBadCode(),
                ReplaceTempWithQueryExample.getGoodCode()),
        "split-temporary-variable",
            new RefactoringTechniqueResponse("Split Temporary Variable", CATEGORY,
                SplitTemporaryVariableExample.getDescription(),
                SplitTemporaryVariableExample.getBadCode(),
                SplitTemporaryVariableExample.getGoodCode()),
        "remove-assignments-to-parameters",
            new RefactoringTechniqueResponse("Remove Assignments to Parameters", CATEGORY,
                RemoveAssignmentsToParametersExample.getDescription(),
                RemoveAssignmentsToParametersExample.getBadCode(),
                RemoveAssignmentsToParametersExample.getGoodCode()),
        "replace-method-with-method-object",
            new RefactoringTechniqueResponse("Replace Method with Method Object", CATEGORY,
                ReplaceMethodWithMethodObjectExample.getDescription(),
                ReplaceMethodWithMethodObjectExample.getBadCode(),
                ReplaceMethodWithMethodObjectExample.getGoodCode()),
        "substitute-algorithm",
            new RefactoringTechniqueResponse("Substitute Algorithm", CATEGORY,
                SubstituteAlgorithmExample.getDescription(),
                SubstituteAlgorithmExample.getBadCode(),
                SubstituteAlgorithmExample.getGoodCode())
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
