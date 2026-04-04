package edu.pafiast.refractoring.techniques.simplifyingmethodcalls;

public class ParameterizeMethodExample {

    public static String getDescription() {
        return "Parameterize Method: When several methods do similar things but with different " +
               "values in the method body, create one method that uses a parameter for the " +
               "different values. This removes duplication and makes the behaviour explicit.";
    }

    public static String getBadCode() {
        return """
                // BAD: Three almost-identical methods — different only in the raise percentage
                void fivePercentRaise()  { salary *= 1.05; }
                void tenPercentRaise()   { salary *= 1.10; }
                void fifteenPercentRaise(){ salary *= 1.15; }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: One parameterized method handles all cases
                void raise(double percentage) {
                    salary *= (1 + percentage / 100);
                }

                // Usage:
                raise(5);   // replaces fivePercentRaise()
                raise(10);  // replaces tenPercentRaise()
                """;
    }
}
