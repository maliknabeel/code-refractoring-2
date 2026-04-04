package com.refactoring.examples.techniques.generalization;

public class PushDownMethodExample {

    public static String getDescription() {
        return "Push Down Method: When the behaviour on a superclass is only relevant for some " +
               "of its subclasses, move it to those subclasses. Push Down is the inverse of " +
               "Pull Up — use it when a superclass method makes no sense for all subclasses.";
    }

    public static String getBadCode() {
        return """
                // BAD: getQuota() in Employee only makes sense for Salesperson
                abstract class Employee {
                    double getQuota() { return 0; }  // meaningless for Engineer
                }

                class Salesperson extends Employee {
                    double getQuota() { return quota; }  // meaningful here
                }

                class Engineer extends Employee {
                    // getQuota() inherited but makes no sense here!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: getQuota() pushed down to only the class where it belongs
                abstract class Employee { /* no getQuota() */ }

                class Salesperson extends Employee {
                    double getQuota() { return quota; }  // only here
                }

                class Engineer extends Employee {
                    // getQuota() doesn't exist — correct!
                }
                """;
    }
}
