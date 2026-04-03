package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class SeparateQueryFromModifierExample {

    public static String getDescription() {
        return "Separate Query from Modifier: When you have a method that returns a value but " +
               "also changes the state of an object, create two methods, one for the query and " +
               "one for the modification. Any method that returns a value should not have " +
               "observable side effects (Command-Query Separation principle).";
    }

    public static String getBadCode() {
        return """
                // BAD: getTotalOutstanding() both returns a value AND sends a bill — surprise side-effect!
                double getTotalOutstandingAndSendBill() {
                    double result = customer.getInvoices().stream()
                        .mapToDouble(Invoice::getAmount).sum();
                    sendBill();   // side effect hidden inside a query!
                    return result;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Query and modifier are separate methods
                double getTotalOutstanding() {
                    return customer.getInvoices().stream()
                        .mapToDouble(Invoice::getAmount).sum();
                }

                void sendBill() {
                    emailGateway.send(formatBill(customer));
                }

                // Caller explicitly does both:
                double amount = getTotalOutstanding();
                sendBill();
                """;
    }

    public static class BadExample {
        private double balance   = 1000.0;
        private boolean billSent = false;

        // Violates CQS: queries AND modifies at the same time
        public double getTotalAndSendAlert() {
            if (balance < 0) {
                billSent = true; // hidden side effect
            }
            return balance;
        }

        public boolean isBillSent() { return billSent; }
    }

    public static class GoodExample {
        private double  balance   = 1000.0;
        private boolean billSent  = false;

        // Pure query — no side effects
        public double getBalance() { return balance; }

        // Pure command — no return value
        public void sendAlertIfOverdue() {
            if (balance < 0) {
                billSent = true;
            }
        }

        public boolean isBillSent() { return billSent; }
    }
}
