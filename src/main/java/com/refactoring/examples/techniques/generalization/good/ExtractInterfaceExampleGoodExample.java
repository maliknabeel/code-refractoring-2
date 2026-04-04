package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.ExtractInterfaceExample.*;

public class ExtractInterfaceExampleGoodExample {
    interface Billable {
        int     getRate();
        boolean hasSpecialSkill();
    }

    public static class Employee implements Billable {
        private final int     rate;
        private final boolean hasSpecialSkill;

        public Employee(int rate, boolean hasSpecialSkill) {
            this.rate = rate; this.hasSpecialSkill = hasSpecialSkill;
        }

        @Override public int     getRate()         { return rate; }
        @Override public boolean hasSpecialSkill() { return hasSpecialSkill; }
    }

    public static class Contractor implements Billable { // can use the same TimeSheet!
        private final int rate;
        public Contractor(int rate) { this.rate = rate; }
        @Override public int     getRate()         { return rate; }
        @Override public boolean hasSpecialSkill() { return true; }
    }

    public static class TimeSheet {
        public double charge(Billable billable, int days) { // depends on interface
            int base = billable.getRate() * days;
            return billable.hasSpecialSkill() ? base * 1.05 : base;
        }
    }
}
