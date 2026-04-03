package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class HideMethodExample {

    public static String getDescription() {
        return "Hide Method: When a method is not used by any other class, make the method " +
               "private. A class's public interface should be as small as possible. Excess " +
               "public methods expose implementation details and make the class harder to change " +
               "without breaking clients.";
    }

    public static String getBadCode() {
        return """
                // BAD: formatName() and validateInput() are public but only used internally
                class AccountFormatter {
                    public String format(Account account) {
                        return formatName(account) + " - " + account.getBalance();
                    }

                    public String formatName(Account account) {  // should be private!
                        return account.getLastName() + ", " + account.getFirstName();
                    }

                    public boolean validateInput(String input) {  // should be private!
                        return input != null && !input.isBlank();
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Internal helpers are private — only format() is public API
                class AccountFormatter {
                    public String format(Account account) {
                        return formatName(account) + " - " + account.getBalance();
                    }

                    private String formatName(Account account) {   // hidden
                        return account.getLastName() + ", " + account.getFirstName();
                    }

                    private boolean validateInput(String input) {  // hidden
                        return input != null && !input.isBlank();
                    }
                }
                """;
    }

    public static class BadExample {
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

        // These helper methods are unnecessarily public
        public String formatName(BankAccount a) {
            return a.getLastName() + ", " + a.getFirstName();
        }

        public boolean validateAmount(double amount) {
            return amount > 0;
        }

        public String format(BankAccount a) {
            if (!validateAmount(a.getBalance())) return "No funds";
            return formatName(a) + " Balance: " + a.getBalance();
        }
    }

    public static class GoodExample {
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
}
