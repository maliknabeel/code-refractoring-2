package edu.pafiast.refractoring.techniques.composingmethods;

public class InlineMethodExample {

    public static String getDescription() {
        return "Inline Method: When a method body is just as clear as its name, replace calls to " +
               "the method with the method's content and delete the method. Use this when a method " +
               "delegation is needlessly indirect and adds no clarity.";
    }

    public static String getBadCode() {
        return """
                // BAD: moreThanFiveLateDeliveries() adds no clarity - it's a trivial wrapper
                int getRating() {
                    return moreThanFiveLateDeliveries() ? 2 : 1;
                }

                boolean moreThanFiveLateDeliveries() {
                    return numberOfLateDeliveries > 5;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Inlined - the condition is clear enough without a separate method
                int getRating() {
                    return numberOfLateDeliveries > 5 ? 2 : 1;
                }
                """;
    }
}
