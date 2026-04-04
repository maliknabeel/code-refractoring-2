package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.SeparateQueryFromModifierExample.*;

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
