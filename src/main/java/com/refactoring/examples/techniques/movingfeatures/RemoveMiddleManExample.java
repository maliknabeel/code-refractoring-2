package com.refactoring.examples.techniques.movingfeatures;

public class RemoveMiddleManExample {

    public static String getDescription() {
        return "Remove Middle Man: When a class is doing too much simple delegation, get the " +
               "client to call the delegate directly. It is the opposite of Hide Delegate. " +
               "If half of a class's methods are delegation methods, it becomes an unnecessary " +
               "middleman that just adds indirection.";
    }

    public static String getBadCode() {
        return """
                // BAD: Person is just a middleman — every call goes straight to Department
                class Person {
                    private Department department;

                    Manager getManager()         { return department.getManager(); }
                    String  getDepartmentName()  { return department.getName(); }
                    int     getHeadCount()       { return department.getHeadCount(); }
                    double  getBudget()          { return department.getBudget(); }
                    // ...endless delegation methods...
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Expose the department directly; clients call it themselves
                class Person {
                    private Department department;

                    public Department getDepartment() { return department; }
                }

                // Client:
                person.getDepartment().getManager();
                person.getDepartment().getName();
                """;
    }

    public static class BadExample {
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

    public static class GoodExample {
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
}
