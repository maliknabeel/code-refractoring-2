package com.refactoring.examples.techniques.generalization;

public class PullUpMethodExample {

    public static String getDescription() {
        return "Pull Up Method: When you have methods with identical results on subclasses, move " +
               "them to the superclass. Duplicate methods in subclasses violate DRY and mean " +
               "that fixes or changes must be applied in multiple places.";
    }

    public static String getBadCode() {
        return """
                // BAD: Both subclasses have identical getAnnualCost() — duplicated logic
                class Salesperson extends Employee {
                    double getAnnualCost() { return getMonthlyCost() * 12; }
                }
                class Engineer extends Employee {
                    double getAnnualCost() { return getMonthlyCost() * 12; }  // identical!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: getAnnualCost() pulled up to Employee superclass
                abstract class Employee {
                    abstract double getMonthlyCost();

                    double getAnnualCost() { return getMonthlyCost() * 12; }  // here once!
                }
                class Salesperson extends Employee {
                    double getMonthlyCost() { return salary / 12; }
                }
                class Engineer extends Employee {
                    double getMonthlyCost() { return salary / 12; }
                }
                """;
    }

    public static class BadExample {
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

    public static class GoodExample {
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
}
