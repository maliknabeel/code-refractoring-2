package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.PullUpConstructorBodyExample.*;

public class PullUpConstructorBodyExampleBadExample {
    abstract public static class Employee {
        protected String name;
        protected String id;
    }

    public static class Manager extends Employee {
        private int grade;
        public Manager(String name, String id, int grade) {
            this.name  = name;  // duplicated
            this.id    = id;    // duplicated
            this.grade = grade;
        }
        public String describe() { return name + " [" + id + "] Grade: " + grade; }
    }

    public static class Salesperson extends Employee {
        private double commission;
        public Salesperson(String name, String id, double commission) {
            this.name       = name;       // duplicated
            this.id         = id;         // duplicated
            this.commission = commission;
        }
        public String describe() { return name + " [" + id + "] Comm: " + commission; }
    }
}
