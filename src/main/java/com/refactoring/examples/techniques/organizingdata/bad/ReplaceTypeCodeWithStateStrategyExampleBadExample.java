package com.refactoring.examples.techniques.organizingdata.bad;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceTypeCodeWithStateStrategyExample.*;

public class ReplaceTypeCodeWithStateStrategyExampleBadExample {
    public static class Employee {
        static final int ENGINEER    = 0;
        static final int SALESPERSON = 1;
        static final int MANAGER     = 2;

        private int    type;
        private double baseSalary;
        private double commission;
        private double bonus;

        public Employee(int type, double baseSalary, double commission, double bonus) {
            this.type = type; this.baseSalary = baseSalary;
            this.commission = commission; this.bonus = bonus;
        }

        public double payAmount() {
            return switch (type) {
                case ENGINEER    -> baseSalary;
                case SALESPERSON -> baseSalary + commission;
                case MANAGER     -> baseSalary + bonus;
                default -> throw new RuntimeException("Unknown type");
            };
        }

        public void promote() { if (type == ENGINEER) type = MANAGER; }
    }
}
