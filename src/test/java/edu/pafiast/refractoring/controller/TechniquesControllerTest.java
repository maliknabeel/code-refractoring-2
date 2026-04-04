package edu.pafiast.refractoring.controller;

import edu.pafiast.refractoring.model.RefactoringCodeComparison;
import edu.pafiast.refractoring.model.RefactoringTechniqueResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TechniquesControllerTest {

    @Autowired
    private TechniquesController controller;

    @Test
    void getAllTechniques_returnsNonEmptyList() {
        List<RefactoringTechniqueResponse> all = controller.getAllTechniques();
        assertFalse(all.isEmpty());
    }

    @Test
    void getCategories_containsAllExpectedCategories() {
        Map<String, List<RefactoringTechniqueResponse>> categories = controller.getCategories();
        assertTrue(categories.containsKey("Composing Methods"));
        assertTrue(categories.containsKey("Moving Features Between Objects"));
        assertTrue(categories.containsKey("Organizing Data"));
        assertTrue(categories.containsKey("Simplifying Conditional Expressions"));
        assertTrue(categories.containsKey("Simplifying Method Calls"));
        assertTrue(categories.containsKey("Dealing with Generalization"));
    }

    @Test
    void getCategories_eachCategoryHasAtLeastOneTechnique() {
        controller.getCategories().forEach((category, techniques) ->
                assertFalse(techniques.isEmpty(), "Category '" + category + "' should have techniques"));
    }

    @Test
    void search_byName_returnsMatchingTechniques() {
        List<RefactoringTechniqueResponse> results = controller.search("extract");
        assertFalse(results.isEmpty());
        results.forEach(t ->
                assertTrue(t.getName().toLowerCase().contains("extract")
                        || t.getDescription().toLowerCase().contains("extract")
                        || t.getCategory().toLowerCase().contains("extract")));
    }

    @Test
    void search_byCategory_returnsMatchingTechniques() {
        List<RefactoringTechniqueResponse> results = controller.search("generalization");
        assertFalse(results.isEmpty());
    }

    @Test
    void search_noMatch_returnsEmptyList() {
        List<RefactoringTechniqueResponse> results = controller.search("zzznomatch999");
        assertTrue(results.isEmpty());
    }

    @Test
    void getComparison_validTechnique_returnsBothCodeSamples() {
        RefactoringCodeComparison comparison = controller.getComparison("extract-method");
        assertEquals("Extract Method", comparison.getName());
        assertFalse(comparison.getBadCode().isBlank());
        assertFalse(comparison.getGoodCode().isBlank());
    }

    @Test
    void getComparison_invalidTechnique_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> controller.getComparison("nonexistent-technique"));
    }
}
