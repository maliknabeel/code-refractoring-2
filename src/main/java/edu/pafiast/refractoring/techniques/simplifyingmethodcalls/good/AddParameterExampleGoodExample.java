package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.AddParameterExample.*;

public class AddParameterExampleGoodExample {
    public String formatDate(int day, int month, int year, String separator) {
        // Caller can now choose the separator
        return day + separator + month + separator + year;
    }
}
