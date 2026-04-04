package edu.pafiast.refractoring.techniques.movingfeatures.good;

import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.RemoveMiddleManExample.*;

public class RemoveMiddleManExampleGoodExample {
    public static class Department {
        private final String name;
        private final String managerName;
        private final int headCount;

        public Department(String name, String managerName, int headCount) {
            this.name = name;
            this.managerName = managerName;
            this.headCount = headCount;
        }

        public String getName()        { return name; }
        String getManagerName() { return managerName; }
        public int    getHeadCount()   { return headCount; }
    }

    public static class Person {
        private final Department department;
        public Person(Department department) { this.department = department; }

        // Expose the real object — no middleman
        public Department getDepartment() { return department; }
    }
}
