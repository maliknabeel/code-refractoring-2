package edu.pafiast.refractoring.techniques.composingmethods.good;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.InlineTempExample.*;

public class InlineTempExampleGoodExample {
    public boolean isExpensive(double basePrice) {
        return (basePrice * 1.1) > 1000; // inlined
    }

    public String applyDiscount(double basePrice, double discountRate) {
        return "Final price: " + (basePrice * (1 - discountRate)); // inlined
    }
}
