package edu.pafiast.refractoring.techniques.movingfeatures.bad;

import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.RemoveMiddleManExample.*;

public class RemoveMiddleManExampleBadExample {
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

        // Every method is just a delegation — Person is a useless middleman
        String getDeptName()    { return department.getName(); }
        String getManagerName() { return department.getManagerName(); }
        int    getHeadCount()   { return department.getHeadCount(); }
    }
}
