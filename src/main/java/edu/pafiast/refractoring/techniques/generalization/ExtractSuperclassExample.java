package edu.pafiast.refractoring.techniques.generalization;

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
}
