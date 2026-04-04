package com.refactoring.examples.techniques.composingmethods.good;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.RemoveAssignmentsToParametersExample.*;

public class RemoveAssignmentsToParametersExampleGoodExample {
    public double applyTax(double price, String country) {
        double taxedPrice = price; // local variable, never touch the parameter
        if (country.equals("US")) {
            taxedPrice = price * 1.08;
        } else if (country.equals("UK")) {
            taxedPrice = price * 1.20;
        }
        return taxedPrice;
    }
}
