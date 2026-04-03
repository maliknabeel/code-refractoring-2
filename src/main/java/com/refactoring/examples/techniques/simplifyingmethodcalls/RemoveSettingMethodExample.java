package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class RemoveSettingMethodExample {

    public static String getDescription() {
        return "Remove Setting Method: When a field should be set only at creation time and " +
               "never changed, remove any setting method for that field. Making a field final " +
               "(or removing its setter) communicates clearly that the field is immutable after " +
               "construction.";
    }

    public static String getBadCode() {
        return """
                // BAD: customerId has a setter even though it should never change
                class Customer {
                    private String customerId;

                    public Customer(String customerId) { this.customerId = customerId; }

                    void setCustomerId(String id) { this.customerId = id; }  // should not exist!
                    String getCustomerId()         { return customerId; }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: customerId is final — no setter, immutable after construction
                class Customer {
                    private final String customerId;  // final enforces immutability

                    public Customer(String customerId) { this.customerId = customerId; }

                    String getCustomerId() { return customerId; }
                    // No setCustomerId() — it simply doesn't exist
                }
                """;
    }

    public static class BadExample {
        public static class Customer {
            private String customerId;

            public Customer(String customerId) { this.customerId = customerId; }

            public void   setCustomerId(String id) { this.customerId = id; } // should not exist
            public String getCustomerId()           { return customerId; }
        }
    }

    public static class GoodExample {
        public static class Customer {
            private final String customerId; // final — can't be changed

            public Customer(String customerId) { this.customerId = customerId; }

            public String getCustomerId() { return customerId; }
            // Setter intentionally absent
        }
    }
}
