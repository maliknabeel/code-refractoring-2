package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.RenameMethodExample.*;

public class RenameMethodExampleGoodExample {
    private String areaCode = "021";
    private String number   = "1234567";

    public String getTelephoneNumber()            { return areaCode + "-" + number; }
    public boolean isAdult(int age)               { return age >= 18; }
    public double calculatePercentage(double p, double r) { return p * r / 100; }
}
