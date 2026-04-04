package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.ReplaceDelegationWithInheritanceExample.*;

public class ReplaceDelegationWithInheritanceExampleBadExample {
    public static class Person {
        private String name;
        private int    age;

        public Person(String name, int age) { this.name = name; this.age = age; }
        public String getName()   { return name; }
        public void   setName(String n) { this.name = n; }
        public int    getAge()    { return age; }
        public String toString()  { return name + " (" + age + ")"; }
    }

    // Employee purely delegates — IS-A holds, so this is unnecessary delegation
    public static class Employee {
        private final Person person;
        private int employeeNumber;

        public Employee(String name, int age, int employeeNumber) {
            this.person = new Person(name, age);
            this.employeeNumber = employeeNumber;
        }

        public String getName()   { return person.getName(); }    // delegation
        public int    getAge()    { return person.getAge(); }     // delegation
        public String toString()  { return person.toString(); }   // delegation
        public int    getEmployeeNumber() { return employeeNumber; }
    }
}
