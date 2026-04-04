package com.refactoring.examples.techniques.movingfeatures.good;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.MoveFieldExample.*;

public class MoveFieldExampleGoodExample {
    public static class AccountType {
        private final String name;
        private final double interestRate; // moved here

        public AccountType(String name, double interestRate) {
            this.name = name;
            this.interestRate = interestRate;
        }

        String getName() { return name; }
        double getInterestRate() { return interestRate; }
    }

    public static class Account {
        private final AccountType type;

        public Account(AccountType type) {
            this.type = type;
        }

        public double interestForAmount(double amount, int days) {
            return type.getInterestRate() * amount * days / 365.0;
        }
    }
}
