package edu.pafiast.refractoring.techniques.movingfeatures.bad;

import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.MoveMethodExample.*;

public class MoveMethodExampleBadExample {
    public static class AccountType {
        private final boolean premium;
        public AccountType(boolean premium) { this.premium = premium; }
        boolean isPremium() { return premium; }
    }

    public static class Account {
        private final AccountType type;
        private final int daysOverdrawn;

        public Account(AccountType type, int daysOverdrawn) {
            this.type = type;
            this.daysOverdrawn = daysOverdrawn;
        }

        // This method uses AccountType internals - it should live there
        public double overdraftCharge() {
            if (type.isPremium()) {
                double baseCharge = 10;
                if (daysOverdrawn <= 7) return baseCharge;
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            } else {
                return daysOverdrawn * 1.75;
            }
        }
    }
}
