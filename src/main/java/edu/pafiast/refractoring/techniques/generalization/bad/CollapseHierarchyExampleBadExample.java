package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.CollapseHierarchyExample.*;

public class CollapseHierarchyExampleBadExample {
    public static class Employee {
        protected String name;
        protected int    grade;
        public Employee(String name, int grade) { this.name = name; this.grade = grade; }
        public String getName()  { return name; }
        public int    getGrade() { return grade; }
    }

    // ActiveEmployee adds nothing — empty subclass
    public static class ActiveEmployee extends Employee {
        public ActiveEmployee(String name, int grade) { super(name, grade); }
        // No new fields, no overrides, no reason to exist
    }
}
