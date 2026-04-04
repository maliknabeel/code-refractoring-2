package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ParameterizeMethodExample.*;

public class ParameterizeMethodExampleGoodExample {
    private double salary = 50000;

    public void raise(double percentageIncrease) {
        salary *= (1.0 + percentageIncrease / 100.0);
    }

    public double getSalary() { return salary; }
}
