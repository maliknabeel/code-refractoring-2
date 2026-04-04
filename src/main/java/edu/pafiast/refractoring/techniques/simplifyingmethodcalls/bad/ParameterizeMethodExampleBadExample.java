package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.bad;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ParameterizeMethodExample.*;

public class ParameterizeMethodExampleBadExample {
    private double salary = 50000;

    public void fivePercentRaise()   { salary *= 1.05; }
    public void tenPercentRaise()    { salary *= 1.10; }
    public void fifteenPercentRaise(){ salary *= 1.15; }

    public double getSalary() { return salary; }
}
