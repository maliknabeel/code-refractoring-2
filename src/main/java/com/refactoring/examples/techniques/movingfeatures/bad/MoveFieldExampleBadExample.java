package com.refactoring.examples.techniques.movingfeatures.bad;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.MoveFieldExample.*;

public class MoveFieldExampleBadExample {
    public static class AccountType {
        private final String name;
        public AccountType(String name) { this.name = name; }
        String getName() { return name; }
    }

    public static class Account {
        private final AccountType type;
        private double interestRate; // field that belongs to AccountType

        public Account(AccountType type, double interestRate) {
            this.type = type;
            this.interestRate = interestRate;
        }

        public double interestForAmount(double amount, int days) {
            return interestRate * amount * days / 365.0;
        }
    }
}
