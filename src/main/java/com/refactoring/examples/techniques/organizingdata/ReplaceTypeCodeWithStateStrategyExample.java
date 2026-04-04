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
}
