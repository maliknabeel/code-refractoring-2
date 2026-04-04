package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.HideMethodExample.*;

public class HideMethodExampleGoodExample {
    public static class BankAccount {
        private final String firstName;
        private final String lastName;
        private final double balance;

        public BankAccount(String firstName, String lastName, double balance) {
            this.firstName = firstName; this.lastName = lastName; this.balance = balance;
        }

        String getFirstName() { return firstName; }
        String getLastName()  { return lastName; }
        double getBalance()   { return balance; }
    }

    // Internal helpers are now private — only format() exposed
    private String formatName(BankAccount a) {
        return a.getLastName() + ", " + a.getFirstName();
    }

    private boolean validateAmount(double amount) {
        return amount > 0;
    }

    public String format(BankAccount a) {
        if (!validateAmount(a.getBalance())) return "No funds";
        return formatName(a) + " Balance: " + a.getBalance();
    }
}
