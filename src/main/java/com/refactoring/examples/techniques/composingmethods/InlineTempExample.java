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
}
