package com.refactoring.examples.controller;

import com.refactoring.examples.model.RefactoringTechniqueResponse;
import com.refactoring.examples.techniques.generalization.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dealing-with-generalization")
public class DealingWithGeneralizationController {

    private static final String CATEGORY = "Dealing with Generalization";

    private static final Map<String, RefactoringTechniqueResponse> TECHNIQUES;

    static {
        TECHNIQUES = new LinkedHashMap<>();
        TECHNIQUES.put("pull-up-field",
            new RefactoringTechniqueResponse("Pull Up Field", CATEGORY,
                PullUpFieldExample.getDescription(),
                PullUpFieldExample.getBadCode(),
                PullUpFieldExample.getGoodCode()));
        TECHNIQUES.put("pull-up-method",
            new RefactoringTechniqueResponse("Pull Up Method", CATEGORY,
                PullUpMethodExample.getDescription(),
                PullUpMethodExample.getBadCode(),
                PullUpMethodExample.getGoodCode()));
        TECHNIQUES.put("pull-up-constructor-body",
            new RefactoringTechniqueResponse("Pull Up Constructor Body", CATEGORY,
                PullUpConstructorBodyExample.getDescription(),
                PullUpConstructorBodyExample.getBadCode(),
                PullUpConstructorBodyExample.getGoodCode()));
        TECHNIQUES.put("push-down-method",
            new RefactoringTechniqueResponse("Push Down Method", CATEGORY,
                PushDownMethodExample.getDescription(),
                PushDownMethodExample.getBadCode(),
                PushDownMethodExample.getGoodCode()));
        TECHNIQUES.put("push-down-field",
            new RefactoringTechniqueResponse("Push Down Field", CATEGORY,
                PushDownFieldExample.getDescription(),
                PushDownFieldExample.getBadCode(),
                PushDownFieldExample.getGoodCode()));
        TECHNIQUES.put("extract-subclass",
            new RefactoringTechniqueResponse("Extract Subclass", CATEGORY,
                ExtractSubclassExample.getDescription(),
                ExtractSubclassExample.getBadCode(),
                ExtractSubclassExample.getGoodCode()));
        TECHNIQUES.put("extract-superclass",
            new RefactoringTechniqueResponse("Extract Superclass", CATEGORY,
                ExtractSuperclassExample.getDescription(),
                ExtractSuperclassExample.getBadCode(),
                ExtractSuperclassExample.getGoodCode()));
        TECHNIQUES.put("extract-interface",
            new RefactoringTechniqueResponse("Extract Interface", CATEGORY,
                ExtractInterfaceExample.getDescription(),
                ExtractInterfaceExample.getBadCode(),
                ExtractInterfaceExample.getGoodCode()));
        TECHNIQUES.put("collapse-hierarchy",
            new RefactoringTechniqueResponse("Collapse Hierarchy", CATEGORY,
                CollapseHierarchyExample.getDescription(),
                CollapseHierarchyExample.getBadCode(),
                CollapseHierarchyExample.getGoodCode()));
        TECHNIQUES.put("form-template-method",
            new RefactoringTechniqueResponse("Form Template Method", CATEGORY,
                FormTemplateMethodExample.getDescription(),
                FormTemplateMethodExample.getBadCode(),
                FormTemplateMethodExample.getGoodCode()));
        TECHNIQUES.put("replace-inheritance-with-delegation",
            new RefactoringTechniqueResponse("Replace Inheritance with Delegation", CATEGORY,
                ReplaceInheritanceWithDelegationExample.getDescription(),
                ReplaceInheritanceWithDelegationExample.getBadCode(),
                ReplaceInheritanceWithDelegationExample.getGoodCode()));
        TECHNIQUES.put("replace-delegation-with-inheritance",
            new RefactoringTechniqueResponse("Replace Delegation with Inheritance", CATEGORY,
                ReplaceDelegationWithInheritanceExample.getDescription(),
                ReplaceDelegationWithInheritanceExample.getBadCode(),
                ReplaceDelegationWithInheritanceExample.getGoodCode()));
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
