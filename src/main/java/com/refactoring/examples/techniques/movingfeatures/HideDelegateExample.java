package com.refactoring.examples.techniques.movingfeatures;

public class HideDelegateExample {

    public static String getDescription() {
        return "Hide Delegate: When a client is calling a delegate class of an object, create " +
               "methods on the server to hide the delegate. This reduces coupling: if the delegate " +
               "changes, only the server needs to change — clients are shielded.";
    }

    public static String getBadCode() {
        return """
                // BAD: Client reaches through Person to get Department, then Manager
                // Client knows too much about the internal structure
                class Client {
                    String getManagerName(Person person) {
                        Department dept = person.getDepartment(); // reaches through
                        return dept.getManager().getName();       // chain of calls
                    }
                }

                class Person {
                    Department department;
                    Department getDepartment() { return department; }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Person hides the delegate — client only talks to Person
                class Person {
                    private Department department;

                    String getManagerName() {
                        return department.getManager().getName(); // hidden from client
                    }
                }

                class Client {
                    String getManagerName(Person person) {
                        return person.getManagerName(); // simple, no chain
                    }
                }
                """;
    }

    public static class BadExample {
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

    public static class GoodExample {
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
}
