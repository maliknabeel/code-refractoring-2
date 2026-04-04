package edu.pafiast.refractoring.techniques.organizingdata.bad;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceTypeCodeWithSubclassesExample.*;

public class ReplaceTypeCodeWithSubclassesExampleBadExample {
    public static class Employee {
        static final int ENGINEER    = 0;
        static final int SALESPERSON = 1;
        static final int MANAGER     = 2;

        private final int type;
        private final int monthlySalary;
        private final int commission;
        private final int bonus;

        public Employee(int type, int monthlySalary, int commission, int bonus) {
            this.type = type; this.monthlySalary = monthlySalary;
            this.commission = commission; this.bonus = bonus;
        }

        public int payAmount() {
            return switch (type) {
                case ENGINEER    -> monthlySalary;
                case SALESPERSON -> monthlySalary + commission;
                case MANAGER     -> monthlySalary + bonus;
                default -> throw new RuntimeException("Unknown type");
            };
        }
    }
}
