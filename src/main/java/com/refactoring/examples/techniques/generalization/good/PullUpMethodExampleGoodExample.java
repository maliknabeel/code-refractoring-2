package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.PullUpMethodExample.*;

public class PullUpMethodExampleGoodExample {
    abstract public static class Employee {
        protected double annualSalary;
        public Employee(double annualSalary) { this.annualSalary = annualSalary; }

        public double getAnnualCost() { return annualSalary; } // pulled up
    }

    public static class Salesperson extends Employee {
        public Salesperson(double annualSalary) { super(annualSalary); }
    }

    public static class Engineer extends Employee {
        public Engineer(double annualSalary) { super(annualSalary); }
    }
}
