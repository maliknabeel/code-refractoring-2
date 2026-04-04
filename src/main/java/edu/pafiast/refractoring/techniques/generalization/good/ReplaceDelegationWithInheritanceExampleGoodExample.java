package edu.pafiast.refractoring.techniques.generalization.good;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.ReplaceDelegationWithInheritanceExample.*;

public class ReplaceDelegationWithInheritanceExampleGoodExample {
    public static class Person {
        private String name;
        private int    age;

        public Person(String name, int age) { this.name = name; this.age = age; }
        public String getName()   { return name; }
        public void   setName(String n) { this.name = n; }
        public int    getAge()    { return age; }
        @Override public String toString() { return name + " (" + age + ")"; }
    }

    // Employee IS-A Person — extend, not delegate
    public static class Employee extends Person {
        private final int employeeNumber;

        public Employee(String name, int age, int employeeNumber) {
            super(name, age);
            this.employeeNumber = employeeNumber;
        }

        public int getEmployeeNumber() { return employeeNumber; }
        // getName(), getAge(), toString() all inherited — no delegation noise
    }
}
