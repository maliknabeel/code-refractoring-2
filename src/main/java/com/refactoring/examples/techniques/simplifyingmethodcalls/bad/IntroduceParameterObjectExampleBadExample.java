package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.IntroduceParameterObjectExample.*;

public class IntroduceParameterObjectExampleBadExample {
    public double calculateTotal(String customerName, String customerEmail,
                                 String customerAddress, double price,
                                 int quantity, double taxRate) {
        // 6 parameters — long and hard to read
        double subtotal = price * quantity;
        return subtotal + (subtotal * taxRate / 100);
    }
}
