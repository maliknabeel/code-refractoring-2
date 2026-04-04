package com.refactoring.examples.techniques.simplifyingconditionals;

public class RemoveControlFlagExample {

    public static String getDescription() {
        return "Remove Control Flag: When you have a variable that is acting as a control flag " +
               "for a series of boolean expressions, use a break or return statement instead. " +
               "Control flags are a sign of structured programming from pre-break/return days; " +
               "they complicate the code unnecessarily.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'found' control flag makes the loop harder to follow
                void checkSecurity(String[] people) {
                    boolean found = false;
                    for (String person : people) {
                        if (!found) {
                            if (person.equals("Don"))  { sendAlert(); found = true; }
                            if (person.equals("John")) { sendAlert(); found = true; }
                        }
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Early return makes the intent obvious — stop when found
                void checkSecurity(String[] people) {
                    for (String person : people) {
                        if (person.equals("Don") || person.equals("John")) {
                            sendAlert();
                            return;  // no control flag needed
                        }
                    }
                }
                """;
    }
}
