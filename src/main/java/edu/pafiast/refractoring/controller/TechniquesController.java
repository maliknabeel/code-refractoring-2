package edu.pafiast.refractoring.controller;

import edu.pafiast.refractoring.model.RefactoringCodeComparison;
import edu.pafiast.refractoring.model.RefactoringTechniqueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

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

    @GetMapping("/categories")
    public Map<String, List<RefactoringTechniqueResponse>> getCategories() {
        Map<String, List<RefactoringTechniqueResponse>> categories = new LinkedHashMap<>();
        for (RefactoringTechniqueResponse t : getAllTechniques()) {
            categories.computeIfAbsent(t.getCategory(), k -> new ArrayList<>()).add(t);
        }
        return categories;
    }

    @GetMapping("/search")
    public List<RefactoringTechniqueResponse> search(@RequestParam String q) {
        String query = q.toLowerCase(Locale.ROOT);
        return getAllTechniques().stream()
                .filter(t -> t.getName().toLowerCase(Locale.ROOT).contains(query)
                        || t.getDescription().toLowerCase(Locale.ROOT).contains(query)
                        || t.getCategory().toLowerCase(Locale.ROOT).contains(query))
                .collect(Collectors.toList());
    }

    @GetMapping("/{technique}/comparison")
    public RefactoringCodeComparison getComparison(@PathVariable String technique) {
        return getAllTechniques().stream()
                .filter(t -> toSlug(t.getName()).equals(technique))
                .findFirst()
                .map(t -> new RefactoringCodeComparison(t.getName(), t.getCategory(), t.getBadCode(), t.getGoodCode()))
                .orElseThrow(() -> new IllegalArgumentException("Technique not found: " + technique));
    }

    private static String toSlug(String name) {
        return name.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]+", "-");
    }
}
