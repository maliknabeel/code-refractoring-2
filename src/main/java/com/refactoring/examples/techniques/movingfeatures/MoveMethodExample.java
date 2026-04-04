package com.refactoring.examples.techniques.movingfeatures;

public class MoveMethodExample {

    public static String getDescription() {
        return "Move Method: When a method uses or is used by more features of another class than " +
               "the class on which it is defined, create a new method with a similar body in the " +
               "class it uses most. Move the method to where it belongs.";
    }

    public static String getBadCode() {
        return """
                // BAD: overdraftCharge() uses AccountType data, but lives in Account
                class Account {
                    private AccountType type;
                    private int daysOverdrawn;

                    double overdraftCharge() {
                        // This method is really about AccountType, not Account
                        if (type.isPremium()) {
                            double baseCharge = 10;
                            if (daysOverdrawn <= 7) return baseCharge;
                            return baseCharge + (daysOverdrawn - 7) * 0.85;
                        } else {
                            return daysOverdrawn * 1.75;
                        }
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: overdraftCharge() moved to AccountType where it belongs
                class AccountType {
                    private boolean premium;

                    double overdraftCharge(int daysOverdrawn) {
                        if (isPremium()) {
                            double baseCharge = 10;
                            if (daysOverdrawn <= 7) return baseCharge;
                            return baseCharge + (daysOverdrawn - 7) * 0.85;
                        } else {
                            return daysOverdrawn * 1.75;
                        }
                    }

                    boolean isPremium() { return premium; }
                }

                class Account {
                    private AccountType type;
                    private int daysOverdrawn;

                    double overdraftCharge() {
                        return type.overdraftCharge(daysOverdrawn); // delegates
                    }
                }
                """;
    }
}
