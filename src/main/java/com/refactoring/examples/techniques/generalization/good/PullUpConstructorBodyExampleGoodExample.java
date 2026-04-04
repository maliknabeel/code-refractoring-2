package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.PullUpConstructorBodyExample.*;

public class PullUpConstructorBodyExampleGoodExample {
    abstract public static class Employee {
        protected final String name;
        protected final String id;

        protected Employee(String name, String id) {
            this.name = name; // common init in one place
            this.id   = id;
        }
    }

    public static class Manager extends Employee {
        private final int grade;
        public Manager(String name, String id, int grade) {
            super(name, id); // delegates
            this.grade = grade;
        }
        public String describe() { return name + " [" + id + "] Grade: " + grade; }
    }

    public static class Salesperson extends Employee {
        private final double commission;
        public Salesperson(String name, String id, double commission) {
            super(name, id); // delegates
            this.commission = commission;
        }
        public String describe() { return name + " [" + id + "] Comm: " + commission; }
    }
}
