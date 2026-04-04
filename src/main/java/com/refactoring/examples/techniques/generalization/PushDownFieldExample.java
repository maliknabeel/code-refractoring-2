package com.refactoring.examples.techniques.generalization;

public class PushDownFieldExample {

    public static String getDescription() {
        return "Push Down Field: When a field is only used by some subclasses, move the field " +
               "to those subclasses. This is the inverse of Pull Up Field. A field in a " +
               "superclass that is only relevant to one subclass misleads readers into thinking " +
               "all subclasses use it.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'quota' in Employee only applies to Salesperson — misleading!
                abstract class Employee {
                    protected double quota;  // irrelevant for Engineers, Managers...
                }

                class Salesperson extends Employee {
                    // uses quota
                }
                class Engineer extends Employee {
                    // quota is here but never used — confusing!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: 'quota' pushed down to only Salesperson
                abstract class Employee { /* no quota */ }

                class Salesperson extends Employee {
                    private double quota;  // only where it belongs
                }

                class Engineer extends Employee {
                    // quota doesn't exist — correct!
                }
                """;
    }
}
