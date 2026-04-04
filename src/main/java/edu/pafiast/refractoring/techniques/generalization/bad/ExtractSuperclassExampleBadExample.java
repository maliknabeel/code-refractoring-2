package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.ExtractSuperclassExample.*;

public class ExtractSuperclassExampleBadExample {
    public static class Employee {
        private final String name;
        private final double annualCost;
        public Employee(String name, double annualCost) { this.name = name; this.annualCost = annualCost; }
        public String getName()       { return name; }
        public double getAnnualCost() { return annualCost; }
    }

    public static class Department {
        private final String name;       // duplicated
        private final double totalBudget; // same idea as annualCost
        public Department(String name, double totalBudget) { this.name = name; this.totalBudget = totalBudget; }
        public String getName()       { return name; }       // duplicated
        public double getAnnualCost() { return totalBudget; } // duplicated
    }
}
