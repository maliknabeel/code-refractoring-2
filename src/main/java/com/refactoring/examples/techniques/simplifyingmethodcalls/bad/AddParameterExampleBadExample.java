package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.AddParameterExample.*;

public class AddParameterExampleBadExample {
    public String formatDate(int day, int month, int year) {
        // Always uses "-" separator — no flexibility
        return day + "-" + month + "-" + year;
    }
}
