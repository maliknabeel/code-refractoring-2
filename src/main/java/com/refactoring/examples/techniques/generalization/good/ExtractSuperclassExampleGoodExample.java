package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.ExtractSuperclassExample.*;

public class ExtractSuperclassExampleGoodExample {
    abstract public static class Party {
        protected final String name;
        public Party(String name) { this.name = name; }
        public String getName() { return name; }
        public abstract double getAnnualCost();
    }

    public static class Employee extends Party {
        private final double annualCost;
        public Employee(String name, double annualCost) { super(name); this.annualCost = annualCost; }
        @Override public double getAnnualCost() { return annualCost; }
    }

    public static class Department extends Party {
        private final double budget;
        public Department(String name, double budget) { super(name); this.budget = budget; }
        @Override public double getAnnualCost() { return budget; }
    }
}
