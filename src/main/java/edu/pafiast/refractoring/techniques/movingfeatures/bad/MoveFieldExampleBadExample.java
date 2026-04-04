package edu.pafiast.refractoring.techniques.movingfeatures.bad;

import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.MoveFieldExample.*;

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
