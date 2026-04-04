package com.refactoring.examples.techniques.generalization.bad;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.PushDownMethodExample.*;

public class PushDownMethodExampleBadExample {
    abstract public static class Employee {
        protected final String name;
        public Employee(String name) { this.name = name; }
        public String getName() { return name; }
        public double getQuota() { return 0; } // pushed up when it shouldn't be
    }

    public static class Salesperson extends Employee {
        private final double quota;
        public Salesperson(String name, double quota) { super(name); this.quota = quota; }
        @Override public double getQuota() { return quota; }
    }

    public static class Engineer extends Employee {
        public Engineer(String name) { super(name); }
        // inherits getQuota() — but it makes no sense for an Engineer!
    }
}
