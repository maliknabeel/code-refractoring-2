package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.bad;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.AddParameterExample.*;

public class AddParameterExampleBadExample {
    public String formatDate(int day, int month, int year) {
        // Always uses "-" separator — no flexibility
        return day + "-" + month + "-" + year;
    }
}
