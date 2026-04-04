package com.refactoring.examples.techniques.organizingdata.good;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceTypeCodeWithStateStrategyExample.*;

public class ReplaceTypeCodeWithStateStrategyExampleGoodExample {
    interface EmployeeType {
        double payAmount(double baseSalary, double extra);
        String getTypeName();
    }

    public static class EngineerType implements EmployeeType {
        @Override public double payAmount(double baseSalary, double extra) { return baseSalary; }
        @Override public String getTypeName() { return "Engineer"; }
    }

    public static class SalespersonType implements EmployeeType {
        @Override public double payAmount(double baseSalary, double extra) { return baseSalary + extra; }
        @Override public String getTypeName() { return "Salesperson"; }
    }

    public static class ManagerType implements EmployeeType {
        @Override public double payAmount(double baseSalary, double extra) { return baseSalary + extra * 2; }
        @Override public String getTypeName() { return "Manager"; }
    }

    public static class Employee {
        private EmployeeType type; // State/Strategy object
        private double baseSalary;
        private double extra;

        public Employee(EmployeeType type, double baseSalary, double extra) {
            this.type = type; this.baseSalary = baseSalary; this.extra = extra;
        }

        public double payAmount()    { return type.payAmount(baseSalary, extra); }
        public String getTypeName()  { return type.getTypeName(); }
        public void   promote()      { this.type = new ManagerType(); } // clean swap
    }
}
