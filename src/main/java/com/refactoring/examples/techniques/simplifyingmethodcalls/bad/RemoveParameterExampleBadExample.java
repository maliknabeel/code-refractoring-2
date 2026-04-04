package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.RemoveParameterExample.*;

public class RemoveParameterExampleBadExample {
    // 'format' parameter is accepted but never used
    public double calculateDiscount(double price, int quantity, String format) {
        if (quantity > 100) return price * 0.9;
        if (quantity > 50)  return price * 0.95;
        return price;
    }
}
