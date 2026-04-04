package com.refactoring.examples.techniques.composingmethods.good;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.ExtractVariableExample.*;

public class ExtractVariableExampleGoodExample {
    public double calculatePrice(double basePrice, int quantity, boolean isSpecialDeal, int loyaltyYears) {
        boolean isHighValueOrder = basePrice > 1000;
        boolean isBulkQuantity   = quantity > 5;
        boolean isNotSpecialDeal = !isSpecialDeal;
        boolean isLoyalCustomer  = loyaltyYears >= 2;

        boolean isEligibleForDiscount = isHighValueOrder && isBulkQuantity
                                       && isNotSpecialDeal && isLoyalCustomer;

        double discountRate = isEligibleForDiscount ? 0.85 : 1.0;
        return basePrice * quantity * discountRate;
    }
}
