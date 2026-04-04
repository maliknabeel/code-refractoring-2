package edu.pafiast.refractoring.techniques.simplifyingmethodcalls;

public class SeparateQueryFromModifierExample {

    public static String getDescription() {
        return "Separate Query from Modifier: When you have a method that returns a value but " +
               "also changes the state of an object, create two methods, one for the query and " +
               "one for the modification. Any method that returns a value should not have " +
               "observable side effects (Command-Query Separation principle).";
    }

    public static String getBadCode() {
        return """
                // BAD: getTotalOutstanding() both returns a value AND sends a bill — surprise side-effect!
                double getTotalOutstandingAndSendBill() {
                    double result = customer.getInvoices().stream()
                        .mapToDouble(Invoice::getAmount).sum();
                    sendBill();   // side effect hidden inside a query!
                    return result;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Query and modifier are separate methods
                double getTotalOutstanding() {
                    return customer.getInvoices().stream()
                        .mapToDouble(Invoice::getAmount).sum();
                }

                void sendBill() {
                    emailGateway.send(formatBill(customer));
                }

                // Caller explicitly does both:
                double amount = getTotalOutstanding();
                sendBill();
                """;
    }
}
