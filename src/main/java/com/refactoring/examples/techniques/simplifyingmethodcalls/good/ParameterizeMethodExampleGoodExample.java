package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ParameterizeMethodExample.*;

public class ParameterizeMethodExampleGoodExample {
    private double salary = 50000;

    public void raise(double percentageIncrease) {
        salary *= (1.0 + percentageIncrease / 100.0);
    }

    public double getSalary() { return salary; }
}
