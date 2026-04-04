package com.refactoring.examples.techniques.generalization.good;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.CollapseHierarchyExample.*;

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
