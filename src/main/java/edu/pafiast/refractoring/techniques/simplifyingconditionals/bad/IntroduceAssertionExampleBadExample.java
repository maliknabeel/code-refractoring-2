package edu.pafiast.refractoring.techniques.simplifyingconditionals.bad;

import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.IntroduceAssertionExample.*;

public class IntroduceAssertionExampleBadExample {
    private static final double NULL_EXPENSE = -1;
    private double expenseLimit;
    private Project primaryProject;

    public IntroduceAssertionExampleBadExample(double expenseLimit, Project primaryProject) {
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
