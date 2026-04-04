package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.PullUpMethodExample.*;

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
