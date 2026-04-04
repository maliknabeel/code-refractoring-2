package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.bad;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ReplaceExceptionWithTestExample.*;

public class ReplaceExceptionWithTestExampleBadExample {
    private double[] values = {10.0, 20.0, 30.0};

    public double getValueForPeriod(int periodNumber) {
        try {
            return values[periodNumber];
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0; // exception used for flow control
        }
    }
}
