package edu.pafiast.refractoring.techniques.generalization.good;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.CollapseHierarchyExample.*;

public class CollapseHierarchyExampleGoodExample {
    // Hierarchy collapsed — Employee handles everything
    public static class Employee {
        private final String name;
        private final int    grade;

        public Employee(String name, int grade) { this.name = name; this.grade = grade; }
        public String getName()  { return name; }
        public int    getGrade() { return grade; }
    }
}
