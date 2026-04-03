package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class RemoveParameterExample {

    public static String getDescription() {
        return "Remove Parameter: When a parameter is no longer used by the method body, remove " +
               "it. Unused parameters are misleading — they suggest the parameter affects the " +
               "method's behaviour when it doesn't, and they make callers supply unnecessary data.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'taxCode' parameter accepted but never used
                double calculatePrice(double basePrice, String taxCode) {
                    return basePrice * 1.15;  // taxCode ignored!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Unused parameter removed
                double calculatePrice(double basePrice) {
                    return basePrice * 1.15;
                }
                """;
    }

    public static class BadExample {
        // 'format' parameter is accepted but never used
        public double calculateDiscount(double price, int quantity, String format) {
            if (quantity > 100) return price * 0.9;
            if (quantity > 50)  return price * 0.95;
            return price;
        }
    }

    public static class GoodExample {
        // Unused 'format' parameter removed
        public double calculateDiscount(double price, int quantity) {
            if (quantity > 100) return price * 0.9;
            if (quantity > 50)  return price * 0.95;
            return price;
        }
    }
}
