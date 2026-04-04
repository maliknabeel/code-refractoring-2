package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.SeparateQueryFromModifierExample.*;

public class SeparateQueryFromModifierExampleGoodExample {
    private double  balance   = 1000.0;
    private boolean billSent  = false;

    // Pure query — no side effects
    public double getBalance() { return balance; }

    // Pure command — no return value
    public void sendAlertIfOverdue() {
        if (balance < 0) {
            billSent = true;
        }
    }

    public boolean isBillSent() { return billSent; }
}
