package edu.pafiast.refractoring.techniques.generalization;

public class PullUpFieldExample {

    public static String getDescription() {
        return "Pull Up Field: When two subclasses have the same field, move the field to the " +
               "superclass. Duplicate fields in subclasses cause duplicate code and inconsistency. " +
               "Moving them up eliminates the duplication and provides a single point of change.";
    }

    public static String getBadCode() {
        return """
                // BAD: Both subclasses have identical 'name' field — duplicated
                class Employee    { }
                class Salesperson extends Employee { private String name; }
                class Engineer    extends Employee { private String name; }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: 'name' pulled up to the superclass — no duplication
                class Employee {
                    protected String name;
                }
                class Salesperson extends Employee { /* name inherited */ }
                class Engineer    extends Employee { /* name inherited */ }
                """;
    }
}
