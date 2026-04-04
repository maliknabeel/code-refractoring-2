package com.refactoring.examples.techniques.simplifyingconditionals;

public class IntroduceNullObjectExample {

    public static String getDescription() {
        return "Introduce Null Object: When you repeatedly check for a null value, replace the " +
               "null with a null object that provides do-nothing default behaviour. Rather than " +
               "scattering null checks everywhere, a Null Object absorbs the 'do nothing' logic " +
               "in one place.";
    }

    public static String getBadCode() {
        return """
                // BAD: Null checks for customer scattered all over the codebase
                String getCustomerName(Customer customer) {
                    if (customer == null) return "occupant";
                    return customer.getName();
                }

                BillingPlan getPlan(Customer customer) {
                    if (customer == null) return BillingPlan.basic();
                    return customer.getPlan();
                }

                String getHistory(Customer customer) {
                    if (customer == null) return "no history";
                    return customer.getPaymentHistory().toString();
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: NullCustomer provides all the defaults — no null checks needed
                class NullCustomer extends Customer {
                    String getName()            { return "occupant"; }
                    BillingPlan getPlan()       { return BillingPlan.basic(); }
                    PaymentHistory getPaymentHistory() { return new NullPaymentHistory(); }
                }

                // Usage — no more null checks!
                String getCustomerName(Customer customer) { return customer.getName(); }
                BillingPlan getPlan(Customer customer)    { return customer.getPlan(); }
                """;
    }

    public interface Customer {
        String getName();
        String getPlan();
    }
}
