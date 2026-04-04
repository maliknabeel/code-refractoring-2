package com.refactoring.examples.techniques.simplifyingconditionals.good;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.IntroduceNullObjectExample.*;

public class IntroduceNullObjectExampleGoodExample {
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
