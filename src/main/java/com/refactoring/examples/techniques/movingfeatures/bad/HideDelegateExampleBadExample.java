package com.refactoring.examples.techniques.movingfeatures.bad;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.HideDelegateExample.*;

public class HideDelegateExampleBadExample {
    public static class Manager {
        private final String name;
        public Manager(String name) { this.name = name; }
        String getName() { return name; }
    }

    public static class Department {
        private final Manager manager;
        public Department(Manager manager) { this.manager = manager; }
        Manager getManager() { return manager; }
    }

    public static class Person {
        private final Department department;
        public Person(Department department) { this.department = department; }
        Department getDepartment() { return department; } // exposes delegate
    }

    // Client couples itself to both Person AND Department AND Manager
    public String getManagerName(Person person) {
        return person.getDepartment().getManager().getName();
    }
}
