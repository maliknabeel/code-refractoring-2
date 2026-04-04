package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.bad.*;
import com.refactoring.examples.techniques.composingmethods.good.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComposingMethodsTest {

    @Test
    void extractMethod_badExample_computesCorrectTotal() {
        ExtractMethodExampleBadExample bad = new ExtractMethodExampleBadExample();
        String result = bad.printOwing();
        assertTrue(result.contains("Customer Owes"));
        assertTrue(result.contains("John"));
        assertTrue(result.contains("60.0"));
    }

    @Test
    void extractMethod_goodExample_computesCorrectTotal() {
        ExtractMethodExampleGoodExample good = new ExtractMethodExampleGoodExample();
        String result = good.printOwing();
        assertTrue(result.contains("Customer Owes"));
        assertTrue(result.contains("John"));
        assertTrue(result.contains("60.0"));
    }

    @Test
    void extractMethod_descriptionIsNotEmpty() {
        assertFalse(ExtractMethodExample.getDescription().isBlank());
        assertFalse(ExtractMethodExample.getBadCode().isBlank());
        assertFalse(ExtractMethodExample.getGoodCode().isBlank());
    }

    @Test
    void inlineMethod_badAndGoodProduceSameRating() {
        assertEquals(new InlineMethodExampleBadExample(3).getRating(),
                     new InlineMethodExampleGoodExample(3).getRating());
        assertEquals(new InlineMethodExampleBadExample(6).getRating(),
                     new InlineMethodExampleGoodExample(6).getRating());
    }

    @Test
    void inlineMethod_lowDeliveries_ratingOne() {
        assertEquals(1, new InlineMethodExampleGoodExample(3).getRating());
    }

    @Test
    void inlineMethod_highDeliveries_ratingTwo() {
        assertEquals(2, new InlineMethodExampleGoodExample(10).getRating());
    }

    @Test
    void extractVariable_goodExample_calculatesPrice() {
        ExtractVariableExampleGoodExample good = new ExtractVariableExampleGoodExample();
        double price = good.calculatePrice(1500, 10, false, 3);
        assertTrue(price > 0);
    }

    @Test
    void inlineTemp_goodExample_isExpensive() {
        InlineTempExampleGoodExample good = new InlineTempExampleGoodExample();
        assertTrue(good.isExpensive(1000));   // 1000 * 1.1 = 1100 > 1000
        assertFalse(good.isExpensive(500));   // 500 * 1.1 = 550 <= 1000
    }

    @Test
    void replaceTempWithQuery_priceCalculation() {
        ReplaceTempWithQueryExampleGoodExample good = new ReplaceTempWithQueryExampleGoodExample(10, 120);
        double price = good.getPrice();
        assertEquals(good.basePrice() * good.discountFactor(), price, 0.001);
    }

    @Test
    void replaceTempWithQuery_highVolume_discountApplied() {
        ReplaceTempWithQueryExampleGoodExample good = new ReplaceTempWithQueryExampleGoodExample(100, 15);
        assertEquals(0.95, good.discountFactor(), 0.001); // basePrice = 1500 > 1000
    }

    @Test
    void splitTemporaryVariable_computesCorrectPhysics() {
        SplitTemporaryVariableExampleGoodExample good = new SplitTemporaryVariableExampleGoodExample();
        double[] result = good.computePhysics(0, 9.8, 2);
        assertEquals(19.6, result[0], 0.001); // distance: 0.5 * 9.8 * 4
        assertEquals(19.6, result[1], 0.001); // velocity: 9.8 * 2
    }

    @Test
    void removeAssignmentsToParameters_applyTax() {
        RemoveAssignmentsToParametersExampleGoodExample good = new RemoveAssignmentsToParametersExampleGoodExample();
        assertEquals(108.0, good.applyTax(100.0, "US"), 0.001);
        assertEquals(120.0, good.applyTax(100.0, "UK"), 0.001);
        assertEquals(100.0, good.applyTax(100.0, "CA"), 0.001);
    }

    @Test
    void replaceMethodWithMethodObject_priceCalculation() {
        ReplaceMethodWithMethodObjectExampleBadExample bad = new ReplaceMethodWithMethodObjectExampleBadExample();
        ReplaceMethodWithMethodObjectExampleGoodExample good = new ReplaceMethodWithMethodObjectExampleGoodExample();
        assertEquals(bad.price(200, 100, 50), good.price(200, 100, 50), 0.001);
    }

    @Test
    void substituteAlgorithm_findsCorrectPerson() {
        SubstituteAlgorithmExampleGoodExample good = new SubstituteAlgorithmExampleGoodExample();
        assertEquals("Don",  good.foundPerson(new String[]{"Alice", "Don", "Bob"}));
        assertEquals("John", good.foundPerson(new String[]{"Mary", "John"}));
        assertEquals("",     good.foundPerson(new String[]{"Alice", "Bob"}));
    }
}
