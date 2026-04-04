package com.refactoring.examples.techniques.generalization.bad;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.ExtractInterfaceExample.*;

public class ExtractInterfaceExampleBadExample {
    public static class Employee {
        private final int     rate;
        private final boolean hasSpecialSkill;

        public Employee(int rate, boolean hasSpecialSkill) {
            this.rate = rate; this.hasSpecialSkill = hasSpecialSkill;
        }

        public int     getRate()          { return rate; }
        public boolean hasSpecialSkill()  { return hasSpecialSkill; }
        public String  getTeamName()      { return "Engineering"; } // not used by TimeSheet
    }

    public static class TimeSheet {
        public double charge(Employee employee, int days) { // coupled to Employee
            int base = employee.getRate() * days;
            return employee.hasSpecialSkill() ? base * 1.05 : base;
        }
    }
}
