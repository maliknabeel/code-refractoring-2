package com.refactoring.examples.techniques.generalization;

public class PushDownFieldExample {

    public static String getDescription() {
        return "Push Down Field: When a field is only used by some subclasses, move the field " +
               "to those subclasses. This is the inverse of Pull Up Field. A field in a " +
               "superclass that is only relevant to one subclass misleads readers into thinking " +
               "all subclasses use it.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'quota' in Employee only applies to Salesperson — misleading!
                abstract class Employee {
                    protected double quota;  // irrelevant for Engineers, Managers...
                }

                class Salesperson extends Employee {
                    // uses quota
                }
                class Engineer extends Employee {
                    // quota is here but never used — confusing!
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: 'quota' pushed down to only Salesperson
                abstract class Employee { /* no quota */ }

                class Salesperson extends Employee {
                    private double quota;  // only where it belongs
                }

                class Engineer extends Employee {
                    // quota doesn't exist — correct!
                }
                """;
    }

    public static class BadExample {
        abstract public static class Employee {
            protected final String name;
            protected double quota;        // pushed up but only Salesperson uses it
            protected double commissionRate; // pushed up but only Salesperson uses it

            public Employee(String name) { this.name = name; }
            public String getName() { return name; }
        }

        public static class Salesperson extends Employee {
            public Salesperson(String name, double quota, double commissionRate) {
                super(name);
                this.quota = quota;
                this.commissionRate = commissionRate;
            }
            public double getCommission(double sales) { return sales * commissionRate; }
        }

        public static class Engineer extends Employee {
            public Engineer(String name) { super(name); }
            // quota and commissionRate exist but are irrelevant — confusing!
        }
    }

    public static class GoodExample {
        abstract public static class Employee {
            protected final String name;
            public Employee(String name) { this.name = name; }
            public String getName() { return name; }
        }

        public static class Salesperson extends Employee {
            private final double quota;        // pushed down — only here
            private final double commissionRate; // pushed down — only here

            public Salesperson(String name, double quota, double commissionRate) {
                super(name);
                this.quota = quota;
                this.commissionRate = commissionRate;
            }

            public double getQuota()                   { return quota; }
            public double getCommission(double sales)  { return sales * commissionRate; }
        }

        public static class Engineer extends Employee {
            public Engineer(String name) { super(name); }
            // No quota or commissionRate — clean!
        }
    }
}
