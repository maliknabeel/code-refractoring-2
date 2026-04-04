package com.refactoring.examples.techniques.simplifyingconditionals.good;

import java.time.LocalDate;
import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.DecomposeConditionalExample.*;

public class DecomposeConditionalExampleGoodExample {
    private boolean isSummer(LocalDate date, Plan plan) {
        return !date.isBefore(plan.summerStart()) && !date.isAfter(plan.summerEnd());
    }

    private double summerCharge(int quantity, Plan plan) {
        return quantity * plan.summerRate();
    }

    private double winterCharge(int quantity, Plan plan) {
        return quantity * plan.winterRate() + plan.winterServiceCharge();
    }

    public double getCharge(LocalDate date, int quantity, Plan plan) {
        return isSummer(date, plan) ? summerCharge(quantity, plan) : winterCharge(quantity, plan);
    }
}
