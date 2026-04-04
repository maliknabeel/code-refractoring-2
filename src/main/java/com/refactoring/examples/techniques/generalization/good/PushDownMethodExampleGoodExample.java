package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.PushDownMethodExample.*;

public class PushDownMethodExampleGoodExample {
    abstract public static class Employee {
        protected final String name;
        public Employee(String name) { this.name = name; }
        public String getName() { return name; }
        // No getQuota() here
    }

    public static class Salesperson extends Employee {
        private final double quota;
        public Salesperson(String name, double quota) { super(name); this.quota = quota; }
        public double getQuota() { return quota; } // pushed down — only here
    }

    public static class Engineer extends Employee {
        public Engineer(String name) { super(name); }
        // No getQuota() — correct
    }
}
