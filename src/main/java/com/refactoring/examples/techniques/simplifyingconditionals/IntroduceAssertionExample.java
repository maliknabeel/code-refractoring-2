package com.refactoring.examples.techniques.simplifyingconditionals;

public class IntroduceAssertionExample {

    public static String getDescription() {
        return "Introduce Assertion: When a section of code assumes something about the state " +
               "of the program, make the assumption explicit with an assertion. Assertions serve " +
               "as executable documentation — they make assumptions visible and catch bugs early " +
               "in development rather than producing mysterious results later.";
    }

    public static String getBadCode() {
        return """
                // BAD: The code assumes expenseLimit >= 0 and primaryProject != null,
                //       but nothing communicates or enforces these assumptions
                double getExpenseLimit() {
                    return (expenseLimit != NULL_EXPENSE)
                        ? expenseLimit
                        : primaryProject.getMemberExpenseLimit();
                    // What if expenseLimit < 0? What if primaryProject is null?
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Assertions make assumptions explicit and catch violations immediately
                double getExpenseLimit() {
                    assert expenseLimit != NULL_EXPENSE || primaryProject != null
                        : "Either expenseLimit must be set or primaryProject must not be null";

                    if (expenseLimit != NULL_EXPENSE) {
                        assert expenseLimit >= 0 : "Expense limit cannot be negative";
                        return expenseLimit;
                    }
                    return primaryProject.getMemberExpenseLimit();
                }
                """;
    }

    public static class BadExample {
        private static final double NULL_EXPENSE = -1;
        private double expenseLimit;
        private Project primaryProject;

        public BadExample(double expenseLimit, Project primaryProject) {
            this.expenseLimit   = expenseLimit;
            this.primaryProject = primaryProject;
        }

        public double getExpenseLimit() {
            // Hidden assumption: either expenseLimit is set OR primaryProject != null
            return (expenseLimit != NULL_EXPENSE)
                    ? expenseLimit
                    : primaryProject.getMemberExpenseLimit();
        }

        public static class Project {
            public double getMemberExpenseLimit() { return 500.0; }
        }
    }

    public static class GoodExample {
        private static final double NULL_EXPENSE = -1;
        private double expenseLimit;
        private Project primaryProject;

        public GoodExample(double expenseLimit, Project primaryProject) {
            this.expenseLimit   = expenseLimit;
            this.primaryProject = primaryProject;
        }

        public double getExpenseLimit() {
            // Assertion makes the invariant visible and testable
            if (expenseLimit == NULL_EXPENSE && primaryProject == null) {
                throw new AssertionError(
                    "Either expenseLimit must be set or primaryProject must not be null");
            }
            if (expenseLimit != NULL_EXPENSE && expenseLimit < 0) {
                throw new AssertionError("Expense limit cannot be negative: " + expenseLimit);
            }

            return (expenseLimit != NULL_EXPENSE)
                    ? expenseLimit
                    : primaryProject.getMemberExpenseLimit();
        }

        public static class Project {
            public double getMemberExpenseLimit() { return 500.0; }
        }
    }
}
