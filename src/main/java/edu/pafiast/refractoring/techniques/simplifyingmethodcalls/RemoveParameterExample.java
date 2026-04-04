package edu.pafiast.refractoring.techniques.simplifyingmethodcalls;

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
}
