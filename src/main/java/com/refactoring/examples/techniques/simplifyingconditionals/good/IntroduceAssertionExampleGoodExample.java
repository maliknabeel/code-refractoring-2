package com.refactoring.examples.techniques.simplifyingconditionals.good;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.IntroduceAssertionExample.*;

public class IntroduceAssertionExampleGoodExample {
    private static final double NULL_EXPENSE = -1;
    private double expenseLimit;
    private Project primaryProject;

    public IntroduceAssertionExampleGoodExample(double expenseLimit, Project primaryProject) {
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
