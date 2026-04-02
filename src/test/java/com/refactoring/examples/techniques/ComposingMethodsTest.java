package com.refactoring.examples.techniques;

import com.refactoring.examples.techniques.composingmethods.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComposingMethodsTest {

    @Test
    void extractMethod_badExample_computesCorrectTotal() {
        ExtractMethodExample.BadExample bad = new ExtractMethodExample.BadExample();
        String result = bad.printOwing();
        assertTrue(result.contains("Customer Owes"));
        assertTrue(result.contains("John"));
        assertTrue(result.contains("60.0"));
    }

    @Test
    void extractMethod_goodExample_computesCorrectTotal() {
        ExtractMethodExample.GoodExample good = new ExtractMethodExample.GoodExample();
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
        assertEquals(new InlineMethodExample.BadExample(3).getRating(),
                     new InlineMethodExample.GoodExample(3).getRating());
        assertEquals(new InlineMethodExample.BadExample(6).getRating(),
                     new InlineMethodExample.GoodExample(6).getRating());
    }

    @Test
    void inlineMethod_lowDeliveries_ratingOne() {
        assertEquals(1, new InlineMethodExample.GoodExample(3).getRating());
    }

    @Test
    void inlineMethod_highDeliveries_ratingTwo() {
        assertEquals(2, new InlineMethodExample.GoodExample(10).getRating());
    }

    @Test
    void extractVariable_goodExample_calculatesPrice() {
        ExtractVariableExample.GoodExample good = new ExtractVariableExample.GoodExample();
        double price = good.calculatePrice(1500, 10, false, 3);
        assertTrue(price > 0);
    }

    @Test
    void inlineTemp_goodExample_isExpensive() {
        InlineTempExample.GoodExample good = new InlineTempExample.GoodExample();
        assertTrue(good.isExpensive(1000));   // 1000 * 1.1 = 1100 > 1000
        assertFalse(good.isExpensive(500));   // 500 * 1.1 = 550 <= 1000
    }

    @Test
    void replaceTempWithQuery_priceCalculation() {
        ReplaceTempWithQueryExample.GoodExample good = new ReplaceTempWithQueryExample.GoodExample(10, 120);
        double price = good.getPrice();
        assertEquals(good.basePrice() * good.discountFactor(), price, 0.001);
    }

    @Test
    void replaceTempWithQuery_highVolume_discountApplied() {
        ReplaceTempWithQueryExample.GoodExample good = new ReplaceTempWithQueryExample.GoodExample(100, 15);
        assertEquals(0.95, good.discountFactor(), 0.001); // basePrice = 1500 > 1000
    }

    @Test
    void splitTemporaryVariable_computesCorrectPhysics() {
        SplitTemporaryVariableExample.GoodExample good = new SplitTemporaryVariableExample.GoodExample();
        double[] result = good.computePhysics(0, 9.8, 2);
        assertEquals(19.6, result[0], 0.001); // distance: 0.5 * 9.8 * 4
        assertEquals(19.6, result[1], 0.001); // velocity: 9.8 * 2
    }

    @Test
    void removeAssignmentsToParameters_applyTax() {
        RemoveAssignmentsToParametersExample.GoodExample good = new RemoveAssignmentsToParametersExample.GoodExample();
        assertEquals(108.0, good.applyTax(100.0, "US"), 0.001);
        assertEquals(120.0, good.applyTax(100.0, "UK"), 0.001);
        assertEquals(100.0, good.applyTax(100.0, "CA"), 0.001);
    }

    @Test
    void replaceMethodWithMethodObject_priceCalculation() {
        ReplaceMethodWithMethodObjectExample.BadExample bad = new ReplaceMethodWithMethodObjectExample.BadExample();
        ReplaceMethodWithMethodObjectExample.GoodExample good = new ReplaceMethodWithMethodObjectExample.GoodExample();
        assertEquals(bad.price(200, 100, 50), good.price(200, 100, 50), 0.001);
    }

    @Test
    void substituteAlgorithm_findsCorrectPerson() {
        SubstituteAlgorithmExample.GoodExample good = new SubstituteAlgorithmExample.GoodExample();
        assertEquals("Don",  good.foundPerson(new String[]{"Alice", "Don", "Bob"}));
        assertEquals("John", good.foundPerson(new String[]{"Mary", "John"}));
        assertEquals("",     good.foundPerson(new String[]{"Alice", "Bob"}));
    }
}
