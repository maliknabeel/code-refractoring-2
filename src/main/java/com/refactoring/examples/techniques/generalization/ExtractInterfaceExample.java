package com.refactoring.examples.techniques.generalization;

public class ExtractInterfaceExample {

    public static String getDescription() {
        return "Extract Interface: When several clients use the same subset of a class's " +
               "interface, or two classes have part of their interfaces in common, extract the " +
               "subset into an interface. Extracting an interface is great when you want to " +
               "describe operations the client uses so that alternative implementations can be " +
               "provided.";
    }

    public static String getBadCode() {
        return """
                // BAD: Client depends directly on Employee class — hard to test or swap
                class TimeSheet {
                    double charge(Employee employee, int days) {
                        int base = employee.getRate() * days;
                        if (employee.hasSpecialSkill()) return base * 1.05;
                        return base;
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Billable interface extracted — TimeSheet only depends on the interface
                interface Billable {
                    int     getRate();
                    boolean hasSpecialSkill();
                }

                class Employee implements Billable {
                    public int     getRate()          { return hourlyRate; }
                    public boolean hasSpecialSkill()  { return specialSkill; }
                }

                class TimeSheet {
                    double charge(Billable billable, int days) {
                        int base = billable.getRate() * days;
                        if (billable.hasSpecialSkill()) return base * 1.05;
                        return base;
                    }
                }
                """;
    }

    public static class BadExample {
        public static class Employee {
            private final int     rate;
            private final boolean hasSpecialSkill;

            public Employee(int rate, boolean hasSpecialSkill) {
                this.rate = rate; this.hasSpecialSkill = hasSpecialSkill;
            }

            public int     getRate()          { return rate; }
            public boolean hasSpecialSkill()  { return hasSpecialSkill; }
            public String  getTeamName()      { return "Engineering"; } // not used by TimeSheet
        }

        public static class TimeSheet {
            public double charge(Employee employee, int days) { // coupled to Employee
                int base = employee.getRate() * days;
                return employee.hasSpecialSkill() ? base * 1.05 : base;
            }
        }
    }

    public static class GoodExample {
        interface Billable {
            int     getRate();
            boolean hasSpecialSkill();
        }

        public static class Employee implements Billable {
            private final int     rate;
            private final boolean hasSpecialSkill;

            public Employee(int rate, boolean hasSpecialSkill) {
                this.rate = rate; this.hasSpecialSkill = hasSpecialSkill;
            }

            @Override public int     getRate()         { return rate; }
            @Override public boolean hasSpecialSkill() { return hasSpecialSkill; }
        }

        public static class Contractor implements Billable { // can use the same TimeSheet!
            private final int rate;
            public Contractor(int rate) { this.rate = rate; }
            @Override public int     getRate()         { return rate; }
            @Override public boolean hasSpecialSkill() { return true; }
        }

        public static class TimeSheet {
            public double charge(Billable billable, int days) { // depends on interface
                int base = billable.getRate() * days;
                return billable.hasSpecialSkill() ? base * 1.05 : base;
            }
        }
    }
}
