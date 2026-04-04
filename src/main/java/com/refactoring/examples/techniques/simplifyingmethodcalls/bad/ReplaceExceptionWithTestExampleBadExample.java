package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ReplaceExceptionWithTestExample.*;

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
