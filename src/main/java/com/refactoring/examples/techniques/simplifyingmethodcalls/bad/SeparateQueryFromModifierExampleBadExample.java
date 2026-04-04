package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.SeparateQueryFromModifierExample.*;

public class SeparateQueryFromModifierExampleBadExample {
    private double balance   = 1000.0;
    private boolean billSent = false;

    // Violates CQS: queries AND modifies at the same time
    public double getTotalAndSendAlert() {
        if (balance < 0) {
            billSent = true; // hidden side effect
        }
        return balance;
    }

    public boolean isBillSent() { return billSent; }
}
