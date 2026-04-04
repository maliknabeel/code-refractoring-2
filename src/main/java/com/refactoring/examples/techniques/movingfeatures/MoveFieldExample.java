package com.refactoring.examples.techniques.movingfeatures;

public class MoveFieldExample {

    public static String getDescription() {
        return "Move Field: When a field is used more in another class than in its own class, " +
               "create a field in the target class and redirect all its users. Moving a field to " +
               "where it is most used improves cohesion and reduces coupling.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'interestRate' in Account is actually a property of AccountType
                class Account {
                    private double interestRate;  // really belongs to AccountType
                    private AccountType type;

                    double interestForAmount(double amount, int days) {
                        return interestRate * amount * days / 365;
                    }
                }

                class AccountType {
                    // AccountType should own interest rate configuration
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: interestRate moved to AccountType where it conceptually belongs
                class AccountType {
                    private double interestRate;  // moved here

                    public AccountType(double interestRate) {
                        this.interestRate = interestRate;
                    }

                    double getInterestRate() { return interestRate; }
                }

                class Account {
                    private AccountType type;

                    double interestForAmount(double amount, int days) {
                        return type.getInterestRate() * amount * days / 365;
                    }
                }
                """;
    }
}
