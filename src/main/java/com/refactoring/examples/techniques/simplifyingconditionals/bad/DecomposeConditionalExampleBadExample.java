package com.refactoring.examples.techniques.simplifyingconditionals.bad;

import java.time.LocalDate;
import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.DecomposeConditionalExample.*;

public class DecomposeConditionalExampleBadExample {
    public double getCharge(LocalDate date, int quantity, Plan plan) {
        if (!date.isBefore(plan.summerStart()) && !date.isAfter(plan.summerEnd())) {
            return quantity * plan.summerRate();
        } else {
            return quantity * plan.winterRate() + plan.winterServiceCharge();
        }
    }
}
