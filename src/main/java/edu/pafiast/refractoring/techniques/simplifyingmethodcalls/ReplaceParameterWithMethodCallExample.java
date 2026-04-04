package edu.pafiast.refractoring.techniques.simplifyingmethodcalls;

public class ReplaceParameterWithMethodCallExample {

    public static String getDescription() {
        return "Replace Parameter with Method Call: When an object invokes a method, then passes " +
               "the result as a parameter for another method, and the receiving method could " +
               "invoke this method itself, remove the parameter and let the receiver invoke the " +
               "method. This simplifies the call site.";
    }

    public static String getBadCode() {
        return """
                // BAD: Caller computes 'discountLevel' and passes it — receiver could do this itself
                int getPrice() {
                    int basePrice    = quantity * itemPrice;
                    int discountLevel = getDiscountLevel();   // computed here...
                    return discountedPrice(basePrice, discountLevel); // ...then passed in
                }

                int discountedPrice(int basePrice, int discountLevel) {
                    if (discountLevel == 1) return basePrice * 95 / 100;
                    return basePrice * 90 / 100;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: discountedPrice() calls getDiscountLevel() itself
                int getPrice() {
                    int basePrice = quantity * itemPrice;
                    return discountedPrice(basePrice);   // no discountLevel param!
                }

                int discountedPrice(int basePrice) {
                    if (getDiscountLevel() == 1) return basePrice * 95 / 100;
                    return basePrice * 90 / 100;
                }
                """;
    }
}
