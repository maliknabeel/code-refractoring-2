package edu.pafiast.refractoring.techniques.composingmethods.bad;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.InlineTempExample.*;

public class InlineTempExampleBadExample {
    public boolean isExpensive(double basePrice) {
        double price = basePrice * 1.1; // temp used only once
        return price > 1000;
    }

    public String applyDiscount(double basePrice, double discountRate) {
        double discountedPrice = basePrice * (1 - discountRate); // temp used only once
        return "Final price: " + discountedPrice;
    }
}
