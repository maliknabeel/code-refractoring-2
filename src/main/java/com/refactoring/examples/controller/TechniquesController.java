package com.refactoring.examples.controller;

import com.refactoring.examples.model.RefactoringTechniqueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/techniques")
public class TechniquesController {

    private final ComposingMethodsController composingMethods;
    private final MovingFeaturesController movingFeatures;
    private final OrganizingDataController organizingData;
    private final SimplifyingConditionalsController simplifyingConditionals;
    private final SimplifyingMethodCallsController simplifyingMethodCalls;
    private final DealingWithGeneralizationController dealingWithGeneralization;

    @Autowired
    public TechniquesController(
            ComposingMethodsController composingMethods,
            MovingFeaturesController movingFeatures,
            OrganizingDataController organizingData,
            SimplifyingConditionalsController simplifyingConditionals,
            SimplifyingMethodCallsController simplifyingMethodCalls,
            DealingWithGeneralizationController dealingWithGeneralization) {
        this.composingMethods = composingMethods;
        this.movingFeatures = movingFeatures;
        this.organizingData = organizingData;
        this.simplifyingConditionals = simplifyingConditionals;
        this.simplifyingMethodCalls = simplifyingMethodCalls;
        this.dealingWithGeneralization = dealingWithGeneralization;
    }

    @GetMapping
    public List<RefactoringTechniqueResponse> getAllTechniques() {
        List<RefactoringTechniqueResponse> all = new ArrayList<>();
        all.addAll(composingMethods.getAllTechniques());
        all.addAll(movingFeatures.getAllTechniques());
        all.addAll(organizingData.getAllTechniques());
        all.addAll(simplifyingConditionals.getAllTechniques());
        all.addAll(simplifyingMethodCalls.getAllTechniques());
        all.addAll(dealingWithGeneralization.getAllTechniques());
        return all;
    }
}
