package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.RemoveParameterExample.*;

public class RemoveParameterExampleGoodExample {
    // Unused 'format' parameter removed
    public double calculateDiscount(double price, int quantity) {
        if (quantity > 100) return price * 0.9;
        if (quantity > 50)  return price * 0.95;
        return price;
    }
}
