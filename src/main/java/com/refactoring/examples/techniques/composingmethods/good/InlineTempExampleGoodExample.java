package com.refactoring.examples.techniques.composingmethods.good;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.InlineTempExample.*;

public class InlineTempExampleGoodExample {
    public boolean isExpensive(double basePrice) {
        return (basePrice * 1.1) > 1000; // inlined
    }

    public String applyDiscount(double basePrice, double discountRate) {
        return "Final price: " + (basePrice * (1 - discountRate)); // inlined
    }
}
