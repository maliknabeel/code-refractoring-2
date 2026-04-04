package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.PushDownFieldExample.*;

public class PushDownFieldExampleBadExample {
    abstract public static class Employee {
        protected final String name;
        protected double quota;        // pushed up but only Salesperson uses it
        protected double commissionRate; // pushed up but only Salesperson uses it

        public Employee(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public static class Salesperson extends Employee {
        public Salesperson(String name, double quota, double commissionRate) {
            super(name);
            this.quota = quota;
            this.commissionRate = commissionRate;
        }
        public double getCommission(double sales) { return sales * commissionRate; }
    }

    public static class Engineer extends Employee {
        public Engineer(String name) { super(name); }
        // quota and commissionRate exist but are irrelevant — confusing!
    }
}
