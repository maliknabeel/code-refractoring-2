package edu.pafiast.refractoring.techniques.generalization.good;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.PushDownFieldExample.*;

public class PushDownFieldExampleGoodExample {
    abstract public static class Employee {
        protected final String name;
        public Employee(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Salesperson extends Employee {
        private final double quota;        // pushed down — only here
        private final double commissionRate; // pushed down — only here

        public Salesperson(String name, double quota, double commissionRate) {
            super(name);
            this.quota = quota;
            this.commissionRate = commissionRate;
        }

        public double getQuota()                   { return quota; }
        public double getCommission(double sales)  { return sales * commissionRate; }
    }

    public static class Engineer extends Employee {
        public Engineer(String name) { super(name); }
        // No quota or commissionRate — clean!
    }
}
