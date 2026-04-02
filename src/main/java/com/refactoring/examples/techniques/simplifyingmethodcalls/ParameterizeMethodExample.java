package com.refactoring.examples.techniques.simplifyingmethodcalls;

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

    public static class BadExample {
        private double salary = 50000;

        public void fivePercentRaise()   { salary *= 1.05; }
        public void tenPercentRaise()    { salary *= 1.10; }
        public void fifteenPercentRaise(){ salary *= 1.15; }

        public double getSalary() { return salary; }
    }

    public static class GoodExample {
        private double salary = 50000;

        public void raise(double percentageIncrease) {
            salary *= (1.0 + percentageIncrease / 100.0);
        }

        public double getSalary() { return salary; }
    }
}
