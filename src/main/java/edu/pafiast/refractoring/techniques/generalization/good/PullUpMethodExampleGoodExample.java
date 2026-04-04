package edu.pafiast.refractoring.techniques.generalization.good;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.PullUpMethodExample.*;

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
