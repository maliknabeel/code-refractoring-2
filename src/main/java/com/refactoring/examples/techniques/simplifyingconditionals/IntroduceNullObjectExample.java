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

    public static class BadExample {
        public String getCustomerName(Customer customer) {
            if (customer == null) return "occupant";
            return customer.getName();
        }

        public String getCustomerPlan(Customer customer) {
            if (customer == null) return "BASIC";
            return customer.getPlan();
        }

        public int getPlanCode(Customer customer) {
            if (customer == null) return 0;
            return customer.getPlan() != null ? 1 : 0;
        }
    }

    public static class GoodExample {
        public static class RealCustomer implements Customer {
            private final String name;
            private final String plan;
            public RealCustomer(String name, String plan) { this.name = name; this.plan = plan; }
            @Override public String getName() { return name; }
            @Override public String getPlan() { return plan; }
        }

        // Null Object — provides safe defaults, no null checks needed by callers
        public static class NullCustomer implements Customer {
            @Override public String getName() { return "occupant"; }
            @Override public String getPlan() { return "BASIC"; }
        }

        public static Customer getCustomer(boolean exists) {
            return exists ? new RealCustomer("John", "PREMIUM") : new NullCustomer();
        }

        public String getCustomerName(Customer customer) { return customer.getName(); }
        public String getCustomerPlan(Customer customer) { return customer.getPlan(); }
    }
}
