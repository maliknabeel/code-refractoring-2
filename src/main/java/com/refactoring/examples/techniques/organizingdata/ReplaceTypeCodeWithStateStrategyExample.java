package com.refactoring.examples.techniques.organizingdata;

public class ReplaceTypeCodeWithStateStrategyExample {

    public static String getDescription() {
        return "Replace Type Code with State/Strategy: When you have a type code that affects " +
               "the behaviour of a class AND the type code changes during the object's lifetime, " +
               "replace the type code with a State or Strategy object. Unlike subclassing, " +
               "this allows the type to change at runtime.";
    }

    public static String getBadCode() {
        return """
                // BAD: Employee type can change (promotion), but type-code-based if/switch
                //      means we'd need to create a new object or have messy state transitions
                class Employee {
                    private int type;  // can change from ENGINEER to MANAGER

                    double payAmount() {
                        if (type == ENGINEER)    return baseSalary;
                        if (type == SALESPERSON) return baseSalary + commission;
                        if (type == MANAGER)     return baseSalary + bonus;
                        throw new RuntimeException("Unknown type");
                    }

                    void promote() {
                        if (type == ENGINEER) type = MANAGER; // type mutation — risky
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: EmployeeType is the State object; it can be swapped at runtime
                interface EmployeeType {
                    double payAmount(Employee e);
                }

                class Engineer    implements EmployeeType {
                    public double payAmount(Employee e) { return e.getBaseSalary(); }
                }
                class Manager     implements EmployeeType {
                    public double payAmount(Employee e) { return e.getBaseSalary() + e.getBonus(); }
                }

                class Employee {
                    private EmployeeType type; // the State object

                    double payAmount() { return type.payAmount(this); }

                    void promote() { type = new Manager(); }  // clean state switch
                }
                """;
    }

    public static class BadExample {
        public static class Employee {
            static final int ENGINEER    = 0;
            static final int SALESPERSON = 1;
            static final int MANAGER     = 2;

            private int    type;
            private double baseSalary;
            private double commission;
            private double bonus;

            public Employee(int type, double baseSalary, double commission, double bonus) {
                this.type = type; this.baseSalary = baseSalary;
                this.commission = commission; this.bonus = bonus;
            }

            public double payAmount() {
                return switch (type) {
                    case ENGINEER    -> baseSalary;
                    case SALESPERSON -> baseSalary + commission;
                    case MANAGER     -> baseSalary + bonus;
                    default -> throw new RuntimeException("Unknown type");
                };
            }

            public void promote() { if (type == ENGINEER) type = MANAGER; }
        }
    }

    public static class GoodExample {
        interface EmployeeType {
            double payAmount(double baseSalary, double extra);
            String getTypeName();
        }

        public static class EngineerType implements EmployeeType {
            @Override public double payAmount(double baseSalary, double extra) { return baseSalary; }
            @Override public String getTypeName() { return "Engineer"; }
        }

        public static class SalespersonType implements EmployeeType {
            @Override public double payAmount(double baseSalary, double extra) { return baseSalary + extra; }
            @Override public String getTypeName() { return "Salesperson"; }
        }

        public static class ManagerType implements EmployeeType {
            @Override public double payAmount(double baseSalary, double extra) { return baseSalary + extra * 2; }
            @Override public String getTypeName() { return "Manager"; }
        }

        public static class Employee {
            private EmployeeType type; // State/Strategy object
            private double baseSalary;
            private double extra;

            public Employee(EmployeeType type, double baseSalary, double extra) {
                this.type = type; this.baseSalary = baseSalary; this.extra = extra;
            }

            public double payAmount()    { return type.payAmount(baseSalary, extra); }
            public String getTypeName()  { return type.getTypeName(); }
            public void   promote()      { this.type = new ManagerType(); } // clean swap
        }
    }
}
