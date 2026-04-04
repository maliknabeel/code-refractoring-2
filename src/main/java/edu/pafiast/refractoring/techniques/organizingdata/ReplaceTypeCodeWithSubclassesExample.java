package edu.pafiast.refractoring.techniques.organizingdata;

public class ReplaceTypeCodeWithSubclassesExample {

    public static String getDescription() {
        return "Replace Type Code with Subclasses: When you have an immutable type code that " +
               "affects the behaviour of a class, replace the type code with subclasses. This " +
               "enables polymorphism to replace conditional logic based on the type code.";
    }

    public static String getBadCode() {
        return """
                // BAD: Type-based switch/if chains spread through the class
                class Employee {
                    static final int ENGINEER    = 0;
                    static final int SALESPERSON = 1;
                    static final int MANAGER     = 2;

                    private int type;

                    int payAmount() {
                        switch (type) {
                            case ENGINEER:    return monthlySalary;
                            case SALESPERSON: return monthlySalary + commission;
                            case MANAGER:     return monthlySalary + bonus;
                            default: throw new RuntimeException("Invalid type");
                        }
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Each subclass provides its own payAmount() implementation
                abstract class Employee {
                    protected int monthlySalary;
                    abstract int payAmount();

                    static Employee create(int type) {
                        return switch (type) {
                            case 0 -> new Engineer();
                            case 1 -> new Salesperson();
                            case 2 -> new Manager();
                            default -> throw new IllegalArgumentException("Invalid type");
                        };
                    }
                }

                class Engineer    extends Employee {
                    int payAmount() { return monthlySalary; }
                }
                class Salesperson extends Employee {
                    private int commission;
                    int payAmount() { return monthlySalary + commission; }
                }
                class Manager     extends Employee {
                    private int bonus;
                    int payAmount() { return monthlySalary + bonus; }
                }
                """;
    }
}
