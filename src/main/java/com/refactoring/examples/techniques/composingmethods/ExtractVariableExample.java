package com.refactoring.examples.techniques.composingmethods;

public class ExtractVariableExample {

    public static String getDescription() {
        return "Extract Variable: When you have a complex expression that is hard to understand, " +
               "place the result of the expression or its parts in separate variables that explain " +
               "the purpose. Also known as 'Introduce Explaining Variable'.";
    }

    public static String getBadCode() {
        return """
                // BAD: Complex condition in one line - hard to understand at a glance
                boolean isEligibleForDiscount(Order order) {
                    return order.getBasePrice() > 1000
                        && order.getQuantity() > 5
                        && !order.isSpecialDeal()
                        && order.getCustomer().getLoyaltyYears() >= 2;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Each condition captured in a well-named variable
                boolean isEligibleForDiscount(Order order) {
                    boolean isHighValueOrder = order.getBasePrice() > 1000;
                    boolean isBulkQuantity  = order.getQuantity() > 5;
                    boolean isNotSpecialDeal = !order.isSpecialDeal();
                    boolean isLoyalCustomer  = order.getCustomer().getLoyaltyYears() >= 2;

                    return isHighValueOrder && isBulkQuantity && isNotSpecialDeal && isLoyalCustomer;
                }
                """;
    }
}
