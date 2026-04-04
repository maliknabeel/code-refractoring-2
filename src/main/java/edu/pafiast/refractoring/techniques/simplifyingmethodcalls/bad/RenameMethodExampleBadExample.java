package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.bad;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.RenameMethodExample.*;

public class RenameMethodExampleBadExample {
    private String areaCode = "021";
    private String number   = "1234567";

    public String getTelNum()   { return areaCode + "-" + number; }
    public boolean chk(int age) { return age >= 18; }
    public double cal(double p, double r) { return p * r / 100; }
}
