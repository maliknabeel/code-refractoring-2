package com.refactoring.examples.techniques.composingmethods;

public class RemoveAssignmentsToParametersExample {

    public static String getDescription() {
        return "Remove Assignments to Parameters: When code assigns a value to a parameter inside " +
               "a method body, use a local variable instead. Assigning to parameters reduces " +
               "clarity because parameters should communicate what was passed in, not serve as " +
               "general-purpose variables.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'inputVal' parameter is reassigned - confusing, hides the original value
                int discount(int inputVal, int quantity) {
                    if (inputVal > 50) {
                        inputVal -= 2;   // Modifying the parameter directly!
                    }
                    if (quantity > 100) {
                        inputVal -= 1;   // Still modifying the parameter!
                    }
                    return inputVal;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Parameter is never modified; result tracked in a separate variable
                int discount(int inputVal, int quantity) {
                    int result = inputVal;  // local copy
                    if (inputVal > 50) {
                        result -= 2;
                    }
                    if (quantity > 100) {
                        result -= 1;
                    }
                    return result;
                }
                """;
    }
}
