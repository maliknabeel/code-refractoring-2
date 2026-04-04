package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ParameterizeMethodExample.*;

public class ParameterizeMethodExampleBadExample {
    private double salary = 50000;

    public void fivePercentRaise()   { salary *= 1.05; }
    public void tenPercentRaise()    { salary *= 1.10; }
    public void fifteenPercentRaise(){ salary *= 1.15; }

    public double getSalary() { return salary; }
}
