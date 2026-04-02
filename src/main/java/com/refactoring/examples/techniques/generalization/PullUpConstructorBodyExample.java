package com.refactoring.examples.techniques.generalization;

public class PullUpConstructorBodyExample {

    public static String getDescription() {
        return "Pull Up Constructor Body: When you have constructors on subclasses with mostly " +
               "identical bodies, create a superclass constructor and call it from the subclass " +
               "methods. Constructors can't be inherited, but their common body can be extracted " +
               "to a common constructor in the parent class.";
    }

    public static String getBadCode() {
        return """
                // BAD: Both subclass constructors repeat the same initialization logic
                class Manager extends Employee {
                    public Manager(String name, String id, int grade) {
                        this.name  = name;   // duplicated
                        this.id    = id;     // duplicated
                        this.grade = grade;
                    }
                }

                class Salesperson extends Employee {
                    public Salesperson(String name, String id) {
                        this.name = name;    // duplicated
                        this.id   = id;      // duplicated
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Common initialization pulled into Employee's constructor
                class Employee {
                    protected Employee(String name, String id) {
                        this.name = name;
                        this.id   = id;
                    }
                }

                class Manager extends Employee {
                    public Manager(String name, String id, int grade) {
                        super(name, id);  // delegates common init
                        this.grade = grade;
                    }
                }

                class Salesperson extends Employee {
                    public Salesperson(String name, String id) {
                        super(name, id);  // delegates common init
                    }
                }
                """;
    }

    public static class BadExample {
        abstract public static class Employee {
            protected String name;
            protected String id;
        }

        public static class Manager extends Employee {
            private int grade;
            public Manager(String name, String id, int grade) {
                this.name  = name;  // duplicated
                this.id    = id;    // duplicated
                this.grade = grade;
            }
            public String describe() { return name + " [" + id + "] Grade: " + grade; }
        }

        public static class Salesperson extends Employee {
            private double commission;
            public Salesperson(String name, String id, double commission) {
                this.name       = name;       // duplicated
                this.id         = id;         // duplicated
                this.commission = commission;
            }
            public String describe() { return name + " [" + id + "] Comm: " + commission; }
        }
    }

    public static class GoodExample {
        abstract public static class Employee {
            protected final String name;
            protected final String id;

            protected Employee(String name, String id) {
                this.name = name; // common init in one place
                this.id   = id;
            }
        }

        public static class Manager extends Employee {
            private final int grade;
            public Manager(String name, String id, int grade) {
                super(name, id); // delegates
                this.grade = grade;
            }
            public String describe() { return name + " [" + id + "] Grade: " + grade; }
        }

        public static class Salesperson extends Employee {
            private final double commission;
            public Salesperson(String name, String id, double commission) {
                super(name, id); // delegates
                this.commission = commission;
            }
            public String describe() { return name + " [" + id + "] Comm: " + commission; }
        }
    }
}
