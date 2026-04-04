package com.refactoring.examples.techniques.movingfeatures.good;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.MoveMethodExample.*;

public class MoveMethodExampleGoodExample {
    public static class AccountType {
        private final boolean premium;
        public AccountType(boolean premium) { this.premium = premium; }
        boolean isPremium() { return premium; }

        // Method moved here - it belongs with the type it uses
        public double overdraftCharge(int daysOverdrawn) {
            if (isPremium()) {
                double baseCharge = 10;
                if (daysOverdrawn <= 7) return baseCharge;
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            }
            return daysOverdrawn * 1.75;
        }
    }

    public static class Account {
        private final AccountType type;
        private final int daysOverdrawn;

        public Account(AccountType type, int daysOverdrawn) {
            this.type = type;
            this.daysOverdrawn = daysOverdrawn;
        }

        public double overdraftCharge() {
            return type.overdraftCharge(daysOverdrawn); // simple delegation
        }
    }
}
