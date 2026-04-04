package com.refactoring.examples.techniques.generalization.bad;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.PullUpMethodExample.*;

public class PullUpMethodExampleBadExample {
    abstract public static class Employee {
        protected double annualSalary;
        public Employee(double annualSalary) { this.annualSalary = annualSalary; }
    }

    public static class Salesperson extends Employee {
        public Salesperson(double annualSalary) { super(annualSalary); }
        public double getAnnualCost() { return annualSalary; } // duplicated
    }

    public static class Engineer extends Employee {
        public Engineer(double annualSalary) { super(annualSalary); }
        public double getAnnualCost() { return annualSalary; } // duplicated
    }
}
