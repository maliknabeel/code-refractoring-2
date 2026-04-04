package edu.pafiast.refractoring.techniques.organizingdata.good;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceTypeCodeWithSubclassesExample.*;

public class ReplaceTypeCodeWithSubclassesExampleGoodExample {
    abstract public static class Employee {
        protected final int monthlySalary;
        public Employee(int monthlySalary) { this.monthlySalary = monthlySalary; }
        public abstract int payAmount();
    }

    public static class Engineer extends Employee {
        public Engineer(int monthlySalary) { super(monthlySalary); }
        @Override public int payAmount() { return monthlySalary; }
    }

    public static class Salesperson extends Employee {
        private final int commission;
        public Salesperson(int monthlySalary, int commission) {
            super(monthlySalary);
            this.commission = commission;
        }
        @Override public int payAmount() { return monthlySalary + commission; }
    }

    public static class Manager extends Employee {
        private final int bonus;
        public Manager(int monthlySalary, int bonus) {
            super(monthlySalary);
            this.bonus = bonus;
        }
        @Override public int payAmount() { return monthlySalary + bonus; }
    }
}
