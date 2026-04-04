package com.refactoring.examples.techniques.generalization.bad;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.ExtractSubclassExample.*;

public class ExtractSubclassExampleBadExample {
    public static class Employee {
        private final int rate;
        public Employee(int rate) { this.rate = rate; }
        int getRate() { return rate; }
    }

    public static class JobItem {
        private final int unitPrice;
        private final int quantity;
        private final boolean isLabor;
        private final Employee employee;

        public JobItem(int unitPrice, int quantity) {
            this.unitPrice = unitPrice; this.quantity = quantity;
            this.isLabor = false; this.employee = null;
        }

        public JobItem(int quantity, Employee employee) {
            this.unitPrice = 0; this.quantity = quantity;
            this.isLabor = true; this.employee = employee;
        }

        public int getUnitPrice() {
            return isLabor ? employee.getRate() : unitPrice; // type switch
        }

        public int getTotalPrice() { return getUnitPrice() * quantity; }
    }
}
