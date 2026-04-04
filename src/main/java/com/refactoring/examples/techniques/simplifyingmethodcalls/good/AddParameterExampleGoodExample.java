package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.AddParameterExample.*;

public class AddParameterExampleGoodExample {
    public String formatDate(int day, int month, int year, String separator) {
        // Caller can now choose the separator
        return day + separator + month + separator + year;
    }
}
