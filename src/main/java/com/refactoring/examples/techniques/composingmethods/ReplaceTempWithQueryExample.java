package com.refactoring.examples.techniques.composingmethods;

import java.util.List;

public class ReplaceTempWithQueryExample {

    public static String getDescription() {
        return "Replace Temp with Query: Instead of placing the result of an expression in a " +
               "temporary variable, extract the whole expression into a separate method. The temp " +
               "variable can then be replaced with a query to this method. This enables the logic " +
               "to be reused elsewhere in the class.";
    }

    public static String getBadCode() {
        return """
                // BAD: basePrice and discountFactor are temps that duplicate logic across methods
                double getPrice() {
                    double basePrice = quantity * itemPrice;
                    double discountFactor;
                    if (basePrice > 1000) {
                        discountFactor = 0.95;
                    } else {
                        discountFactor = 0.98;
                    }
                    return basePrice * discountFactor;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Logic extracted to query methods - reusable and independently testable
                double getPrice() {
                    return basePrice() * discountFactor();
                }

                private double basePrice() {
                    return quantity * itemPrice;
                }

                private double discountFactor() {
                    return basePrice() > 1000 ? 0.95 : 0.98;
                }
                """;
    }

    public static class BadExample {
        private int quantity;
        private double itemPrice;

        public BadExample(int quantity, double itemPrice) {
            this.quantity = quantity;
            this.itemPrice = itemPrice;
        }

        public double getPrice() {
            double basePrice = quantity * itemPrice;
            double discountFactor = basePrice > 1000 ? 0.95 : 0.98;
            return basePrice * discountFactor;
        }
    }

    public static class GoodExample {
        private int quantity;
        private double itemPrice;

        public GoodExample(int quantity, double itemPrice) {
            this.quantity = quantity;
            this.itemPrice = itemPrice;
        }

        public double getPrice() {
            return basePrice() * discountFactor();
        }

        public double basePrice() {
            return quantity * itemPrice;
        }

        public double discountFactor() {
            return basePrice() > 1000 ? 0.95 : 0.98;
        }
    }
}
