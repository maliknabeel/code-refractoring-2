package edu.pafiast.refractoring.techniques.simplifyingconditionals.good;

import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.ConsolidateConditionalExample.*;

public class ConsolidateConditionalExampleGoodExample {
    private boolean isNotEligibleForDisability(Employee e) {
        return e.seniority < 2 || e.monthsDisabled > 12 || e.isPartTime;
    }

    public double disabilityAmount(Employee e) {
        if (isNotEligibleForDisability(e)) return 0;
        return e.baseSalary * 0.6;
    }
}
