package com.refactoring.examples.techniques.generalization;

public class PushDownMethodExample {

    public static String getDescription() {
        return "Push Down Method: When the behaviour on a superclass is only relevant for some " +
               "of its subclasses, move it to those subclasses. Push Down is the inverse of " +
               "Pull Up — use it when a superclass method makes no sense for all subclasses.";
    }

    public static String getBadCode() {
        return """
                // BAD: getQuota() in Employee only makes sense for Salesperson
                abstract class Employee {
                    double getQuota() { return 0; }  // meaningless for Engineer
                }

                class Salesperson extends Employee {
                    double getQuota() { return quota; }  // meaningful here
                }

                class Engineer extends Employee {
                    // getQuota() inherited but makes no sense here!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: getQuota() pushed down to only the class where it belongs
                abstract class Employee { /* no getQuota() */ }

                class Salesperson extends Employee {
                    double getQuota() { return quota; }  // only here
                }

                class Engineer extends Employee {
                    // getQuota() doesn't exist — correct!
                }
                """;
    }

    public static class BadExample {
        abstract public static class Employee {
            protected final String name;
            public Employee(String name) { this.name = name; }
            public String getName() { return name; }
            public double getQuota() { return 0; } // pushed up when it shouldn't be
        }

        public static class Salesperson extends Employee {
            private final double quota;
            public Salesperson(String name, double quota) { super(name); this.quota = quota; }
            @Override public double getQuota() { return quota; }
        }

        public static class Engineer extends Employee {
            public Engineer(String name) { super(name); }
            // inherits getQuota() — but it makes no sense for an Engineer!
        }
    }

    public static class GoodExample {
        abstract public static class Employee {
            protected final String name;
            public Employee(String name) { this.name = name; }
            public String getName() { return name; }
            // No getQuota() here
        }

        public static class Salesperson extends Employee {
            private final double quota;
            public Salesperson(String name, double quota) { super(name); this.quota = quota; }
            public double getQuota() { return quota; } // pushed down — only here
        }

        public static class Engineer extends Employee {
            public Engineer(String name) { super(name); }
            // No getQuota() — correct
        }
    }
}
