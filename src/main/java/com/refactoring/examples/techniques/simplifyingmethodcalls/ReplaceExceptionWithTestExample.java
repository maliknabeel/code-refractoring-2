package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class ReplaceExceptionWithTestExample {

    public static String getDescription() {
        return "Replace Exception with Test: When you are throwing an exception on a condition " +
               "the caller could check first, change the caller to make the test first. " +
               "Exceptions should be for exceptional, unexpected situations — not ordinary " +
               "control flow that the caller could (and should) check for.";
    }

    public static String getBadCode() {
        return """
                // BAD: Using an exception for a predictable, normal condition
                double getValueForPeriod(int periodNumber) {
                    try {
                        return values[periodNumber];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        return 0;  // using exception for flow control!
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Check the condition explicitly before accessing the array
                double getValueForPeriod(int periodNumber) {
                    if (periodNumber >= values.length) return 0;  // test first
                    return values[periodNumber];
                }
                """;
    }
}
