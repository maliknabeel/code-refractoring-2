package com.refactoring.examples.techniques.simplifyingconditionals.good;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ConsolidateConditionalExample.*;

public class ConsolidateConditionalExampleGoodExample {
    private boolean isNotEligibleForDisability(Employee e) {
        return e.seniority < 2 || e.monthsDisabled > 12 || e.isPartTime;
    }

    public double disabilityAmount(Employee e) {
        if (isNotEligibleForDisability(e)) return 0;
        return e.baseSalary * 0.6;
    }
}
