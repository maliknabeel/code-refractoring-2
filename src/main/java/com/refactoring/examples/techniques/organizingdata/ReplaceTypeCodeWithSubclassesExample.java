package com.refactoring.examples.techniques.organizingdata;

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

    public static class BadExample {
        public static class Employee {
            static final int ENGINEER    = 0;
            static final int SALESPERSON = 1;
            static final int MANAGER     = 2;

            private final int type;
            private final int monthlySalary;
            private final int commission;
            private final int bonus;

            public Employee(int type, int monthlySalary, int commission, int bonus) {
                this.type = type; this.monthlySalary = monthlySalary;
                this.commission = commission; this.bonus = bonus;
            }

            public int payAmount() {
                return switch (type) {
                    case ENGINEER    -> monthlySalary;
                    case SALESPERSON -> monthlySalary + commission;
                    case MANAGER     -> monthlySalary + bonus;
                    default -> throw new RuntimeException("Unknown type");
                };
            }
        }
    }

    public static class GoodExample {
        abstract public static class Employee {
            protected final int monthlySalary;
            public Employee(int monthlySalary) { this.monthlySalary = monthlySalary; }
            public abstract int payAmount();
        }

        public static class Engineer extends Employee {
            public Engineer(int monthlySalary) { super(monthlySalary); }
            @Override public int payAmount() { return monthlySalary; }
        }

        public static class Salesperson extends Employee {
            private final int commission;
            public Salesperson(int monthlySalary, int commission) {
                super(monthlySalary);
                this.commission = commission;
            }
            @Override public int payAmount() { return monthlySalary + commission; }
        }

        public static class Manager extends Employee {
            private final int bonus;
            public Manager(int monthlySalary, int bonus) {
                super(monthlySalary);
                this.bonus = bonus;
            }
            @Override public int payAmount() { return monthlySalary + bonus; }
        }
    }
}
