package com.refactoring.examples.techniques.composingmethods;

public class InlineTempExample {

    public static String getDescription() {
        return "Inline Temp: When you have a temporary variable that is assigned once from a simple " +
               "expression and the variable gets in the way of other refactorings, replace all " +
               "references to that temp with the expression itself.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'basePrice' temp variable is used only once - unnecessary indirection
                boolean isExpensive(Order order) {
                    double basePrice = order.getBasePrice();
                    return basePrice > 1000;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Expression inlined - simple and direct
                boolean isExpensive(Order order) {
                    return order.getBasePrice() > 1000;
                }
                """;
    }

    public static class BadExample {
        public boolean isExpensive(double basePrice) {
            double price = basePrice * 1.1; // temp used only once
            return price > 1000;
        }

        public String applyDiscount(double basePrice, double discountRate) {
            double discountedPrice = basePrice * (1 - discountRate); // temp used only once
            return "Final price: " + discountedPrice;
        }
    }

    public static class GoodExample {
        public boolean isExpensive(double basePrice) {
            return (basePrice * 1.1) > 1000; // inlined
        }

        public String applyDiscount(double basePrice, double discountRate) {
            return "Final price: " + (basePrice * (1 - discountRate)); // inlined
        }
    }
}
