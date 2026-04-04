package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.bad;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ReplaceParameterWithMethodCallExample.*;

public class ReplaceParameterWithMethodCallExampleBadExample {
    private int quantity  = 10;
    private int itemPrice = 15;

    private int getDiscountLevel() {
        return quantity > 100 ? 2 : 1;
    }

    private int discountedPrice(int basePrice, int discountLevel) {
        return discountLevel == 2 ? basePrice * 90 / 100 : basePrice * 95 / 100;
    }

    public int getPrice() {
        int basePrice     = quantity * itemPrice;
        int discountLevel = getDiscountLevel(); // computed here
        return discountedPrice(basePrice, discountLevel); // passed in
    }
}
