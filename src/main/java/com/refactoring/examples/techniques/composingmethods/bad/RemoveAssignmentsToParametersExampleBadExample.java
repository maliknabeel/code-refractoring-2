package com.refactoring.examples.techniques.composingmethods.bad;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.RemoveAssignmentsToParametersExample.*;

public class RemoveAssignmentsToParametersExampleBadExample {
    public double applyTax(double price, String country) {
        if (country.equals("US")) {
            price *= 1.08;  // parameter modified!
        } else if (country.equals("UK")) {
            price *= 1.20;  // parameter modified again!
        }
        return price;
    }
}
