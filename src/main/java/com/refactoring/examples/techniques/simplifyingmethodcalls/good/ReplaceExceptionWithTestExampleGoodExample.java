package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ReplaceExceptionWithTestExample.*;

public class ReplaceExceptionWithTestExampleGoodExample {
    private double[] values = {10.0, 20.0, 30.0};

    public double getValueForPeriod(int periodNumber) {
        if (periodNumber < 0 || periodNumber >= values.length) return 0; // test first
        return values[periodNumber];
    }
}
