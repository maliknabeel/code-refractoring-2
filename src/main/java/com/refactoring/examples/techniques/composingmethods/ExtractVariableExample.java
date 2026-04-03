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

    public static class BadExample {
        public double calculatePrice(double basePrice, int quantity, boolean isSpecialDeal, int loyaltyYears) {
            // Complex one-liner - intent is buried
            return (basePrice > 1000 && quantity > 5 && !isSpecialDeal && loyaltyYears >= 2)
                    ? basePrice * quantity * 0.85
                    : basePrice * quantity;
        }
    }

    public static class GoodExample {
        public double calculatePrice(double basePrice, int quantity, boolean isSpecialDeal, int loyaltyYears) {
            boolean isHighValueOrder = basePrice > 1000;
            boolean isBulkQuantity   = quantity > 5;
            boolean isNotSpecialDeal = !isSpecialDeal;
            boolean isLoyalCustomer  = loyaltyYears >= 2;

            boolean isEligibleForDiscount = isHighValueOrder && isBulkQuantity
                                           && isNotSpecialDeal && isLoyalCustomer;

            double discountRate = isEligibleForDiscount ? 0.85 : 1.0;
            return basePrice * quantity * discountRate;
        }
    }
}
