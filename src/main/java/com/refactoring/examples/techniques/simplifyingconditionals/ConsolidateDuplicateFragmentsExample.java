package com.refactoring.examples.techniques.simplifyingconditionals;

public class ConsolidateDuplicateFragmentsExample {

    public static String getDescription() {
        return "Consolidate Duplicate Conditional Fragments: When the same fragment of code is in " +
               "all branches of a conditional expression, move it outside the conditional. " +
               "Duplicate code inside branches is confusing — it suggests it is different in " +
               "different branches, when actually it is always the same.";
    }

    public static String getBadCode() {
        return """
                // BAD: send() is called in both branches — duplicated code
                double getPrice(boolean isSpecialDeal) {
                    double price;
                    if (isSpecialDeal) {
                        price = lastPrice * 0.95;
                        send();          // duplicated!
                    } else {
                        price = lastPrice * 0.98;
                        send();          // duplicated!
                    }
                    return price;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: send() moved outside — runs regardless of branch
                double getPrice(boolean isSpecialDeal) {
                    double price = isSpecialDeal ? lastPrice * 0.95 : lastPrice * 0.98;
                    send();   // called once, not duplicated
                    return price;
                }
                """;
    }

    public static class BadExample {
        private double lastPrice = 100.0;
        private int    sendCount = 0;

        private void send() { sendCount++; }

        public double getPrice(boolean isSpecialDeal) {
            double price;
            if (isSpecialDeal) {
                price = lastPrice * 0.95;
                send(); // duplicated
            } else {
                price = lastPrice * 0.98;
                send(); // duplicated
            }
            return price;
        }

        public int getSendCount() { return sendCount; }
    }

    public static class GoodExample {
        private double lastPrice = 100.0;
        private int    sendCount = 0;

        private void send() { sendCount++; }

        public double getPrice(boolean isSpecialDeal) {
            double price = isSpecialDeal ? lastPrice * 0.95 : lastPrice * 0.98;
            send(); // called once
            return price;
        }

        public int getSendCount() { return sendCount; }
    }
}
