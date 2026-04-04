package com.refactoring.examples.techniques.simplifyingconditionals.bad;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ConsolidateConditionalExample.*;

public class ConsolidateConditionalExampleBadExample {
    public double disabilityAmount(Employee e) {
        if (e.seniority < 2)        return 0;
        if (e.monthsDisabled > 12)  return 0;
        if (e.isPartTime)           return 0;
        return e.baseSalary * 0.6;
    }
}
