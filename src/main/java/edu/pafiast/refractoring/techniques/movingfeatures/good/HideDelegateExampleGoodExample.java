package edu.pafiast.refractoring.techniques.movingfeatures.good;

import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.HideDelegateExample.*;

public class HideDelegateExampleGoodExample {
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

        // Delegate is hidden — client only needs to know Person
        public String getManagerName() {
            return department.getManager().getName();
        }
    }

    public String getManagerName(Person person) {
        return person.getManagerName(); // no chaining
    }
}
