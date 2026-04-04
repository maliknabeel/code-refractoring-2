package com.refactoring.examples.techniques.composingmethods.bad;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.ExtractVariableExample.*;

public class ExtractVariableExampleBadExample {
    public double calculatePrice(double basePrice, int quantity, boolean isSpecialDeal, int loyaltyYears) {
        // Complex one-liner - intent is buried
        return (basePrice > 1000 && quantity > 5 && !isSpecialDeal && loyaltyYears >= 2)
                ? basePrice * quantity * 0.85
                : basePrice * quantity;
    }
}
