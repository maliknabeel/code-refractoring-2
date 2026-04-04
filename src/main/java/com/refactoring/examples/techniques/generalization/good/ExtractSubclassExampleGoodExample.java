package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.ExtractSubclassExample.*;

public class ExtractSubclassExampleGoodExample {
    public static class Employee {
        private final int rate;
        public Employee(int rate) { this.rate = rate; }
        int getRate() { return rate; }
    }

    public static class JobItem {
        protected final int unitPrice;
        protected final int quantity;

        public JobItem(int unitPrice, int quantity) {
            this.unitPrice = unitPrice;
            this.quantity  = quantity;
        }

        public int getUnitPrice()   { return unitPrice; }
        public int getTotalPrice()  { return getUnitPrice() * quantity; }
    }

    public static class LaborItem extends JobItem {
        private final Employee employee;

        public LaborItem(int quantity, Employee employee) {
            super(0, quantity);
            this.employee = employee;
        }

        @Override public int getUnitPrice() { return employee.getRate(); } // polymorphism
    }
}
