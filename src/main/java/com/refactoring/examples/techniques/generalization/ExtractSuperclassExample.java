package com.refactoring.examples.techniques.generalization;

public class ExtractSuperclassExample {

    public static String getDescription() {
        return "Extract Superclass: When you have two classes with similar features, create a " +
               "superclass and move the common features to the superclass. Extracting a " +
               "superclass eliminates duplication by creating a single place for common behaviour " +
               "and data.";
    }

    public static String getBadCode() {
        return """
                // BAD: Employee and Department have duplicated name/annualCost logic
                class Employee {
                    private String name;
                    private int    annualCost;
                    String getName()      { return name; }
                    int    getAnnualCost(){ return annualCost; }
                }

                class Department {
                    private String name;       // duplicated
                    private int    totalCost;  // same concept as annualCost
                    String getName()      { return name; }    // duplicated
                    int    getAnnualCost(){ return totalCost; } // duplicated
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Party superclass holds common name and annualCost
                abstract class Party {
                    protected String name;
                    String getName() { return name; }
                    abstract int getAnnualCost();
                }

                class Employee extends Party {
                    private int annualCost;
                    int getAnnualCost() { return annualCost; }
                }

                class Department extends Party {
                    private List<Employee> staff;
                    int getAnnualCost() {
                        return staff.stream().mapToInt(Employee::getAnnualCost).sum();
                    }
                }
                """;
    }

    public static class BadExample {
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

    public static class GoodExample {
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
}
