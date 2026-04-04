package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ReplaceParameterWithMethodCallExample.*;

public class ReplaceParameterWithMethodCallExampleGoodExample {
    private int quantity  = 10;
    private int itemPrice = 15;

    private int getDiscountLevel() {
        return quantity > 100 ? 2 : 1;
    }

    private int discountedPrice(int basePrice) {
        return getDiscountLevel() == 2 ? basePrice * 90 / 100 : basePrice * 95 / 100;
    }

    public int getPrice() {
        int basePrice = quantity * itemPrice;
        return discountedPrice(basePrice); // discountLevel no longer a parameter
    }
}
