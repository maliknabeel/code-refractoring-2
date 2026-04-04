package edu.pafiast.refractoring.techniques.generalization;

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
}
