package com.refactoring.examples.controller;

import com.refactoring.examples.model.RefactoringTechniqueResponse;
import com.refactoring.examples.techniques.movingfeatures.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/moving-features")
public class MovingFeaturesController {

    private static final String CATEGORY = "Moving Features Between Objects";

    private static final Map<String, RefactoringTechniqueResponse> TECHNIQUES = Map.of(
        "move-method",
            new RefactoringTechniqueResponse("Move Method", CATEGORY,
                MoveMethodExample.getDescription(),
                MoveMethodExample.getBadCode(),
                MoveMethodExample.getGoodCode()),
        "move-field",
            new RefactoringTechniqueResponse("Move Field", CATEGORY,
                MoveFieldExample.getDescription(),
                MoveFieldExample.getBadCode(),
                MoveFieldExample.getGoodCode()),
        "extract-class",
            new RefactoringTechniqueResponse("Extract Class", CATEGORY,
                ExtractClassExample.getDescription(),
                ExtractClassExample.getBadCode(),
                ExtractClassExample.getGoodCode()),
        "inline-class",
            new RefactoringTechniqueResponse("Inline Class", CATEGORY,
                InlineClassExample.getDescription(),
                InlineClassExample.getBadCode(),
                InlineClassExample.getGoodCode()),
        "hide-delegate",
            new RefactoringTechniqueResponse("Hide Delegate", CATEGORY,
                HideDelegateExample.getDescription(),
                HideDelegateExample.getBadCode(),
                HideDelegateExample.getGoodCode()),
        "remove-middle-man",
            new RefactoringTechniqueResponse("Remove Middle Man", CATEGORY,
                RemoveMiddleManExample.getDescription(),
                RemoveMiddleManExample.getBadCode(),
                RemoveMiddleManExample.getGoodCode()),
        "introduce-foreign-method",
            new RefactoringTechniqueResponse("Introduce Foreign Method", CATEGORY,
                IntroduceForeignMethodExample.getDescription(),
                IntroduceForeignMethodExample.getBadCode(),
                IntroduceForeignMethodExample.getGoodCode()),
        "introduce-local-extension",
            new RefactoringTechniqueResponse("Introduce Local Extension", CATEGORY,
                IntroduceLocalExtensionExample.getDescription(),
                IntroduceLocalExtensionExample.getBadCode(),
                IntroduceLocalExtensionExample.getGoodCode())
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
