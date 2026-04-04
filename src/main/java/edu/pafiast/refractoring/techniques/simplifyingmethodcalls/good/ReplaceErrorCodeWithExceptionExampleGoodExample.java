package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ReplaceErrorCodeWithExceptionExample.*;

public class ReplaceErrorCodeWithExceptionExampleGoodExample {
    public static class InsufficientFundsException extends Exception {
        private final double shortfall;
        public InsufficientFundsException(double shortfall) {
            super("Insufficient funds. Shortfall: " + shortfall);
            this.shortfall = shortfall;
        }
        double getShortfall() { return shortfall; }
    }

    private double balance;

    public ReplaceErrorCodeWithExceptionExampleGoodExample(double balance) { this.balance = balance; }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
    }

    public double getBalance() { return balance; }
}
