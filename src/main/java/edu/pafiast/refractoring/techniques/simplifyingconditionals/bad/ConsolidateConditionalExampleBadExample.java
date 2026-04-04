package edu.pafiast.refractoring.techniques.simplifyingconditionals.bad;

import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.ConsolidateConditionalExample.*;

public class ConsolidateConditionalExampleBadExample {
    public double disabilityAmount(Employee e) {
        if (e.seniority < 2)        return 0;
        if (e.monthsDisabled > 12)  return 0;
        if (e.isPartTime)           return 0;
        return e.baseSalary * 0.6;
    }
}
