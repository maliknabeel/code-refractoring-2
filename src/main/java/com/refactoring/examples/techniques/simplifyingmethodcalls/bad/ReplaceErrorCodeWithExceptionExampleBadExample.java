package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ReplaceErrorCodeWithExceptionExample.*;

public class ReplaceErrorCodeWithExceptionExampleBadExample {
    private double balance;

    public ReplaceErrorCodeWithExceptionExampleBadExample(double balance) { this.balance = balance; }

    public int withdraw(double amount) {
        if (amount > balance) return -1; // error code
        balance -= amount;
        return 0; // success
    }

    public double getBalance() { return balance; }
}
