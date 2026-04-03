package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class ReplaceConstructorWithFactoryMethodExample {

    public static String getDescription() {
        return "Replace Constructor with Factory Method: When you want to do more than simple " +
               "construction when you create an object, replace the constructor with a factory " +
               "method. Factory methods can have descriptive names, can return subtypes, and can " +
               "return cached instances — none of which constructors can do.";
    }

    public static String getBadCode() {
        return """
                // BAD: Constructor takes a type code and callers must know magic integers
                class Employee {
                    static final int ENGINEER = 0, SALESMAN = 1, MANAGER = 2;

                    public Employee(int type) {
                        this.type = type;
                    }
                }

                // Caller:
                Employee e = new Employee(Employee.ENGINEER);  // opaque, returns only Employee
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Descriptive factory methods, can return appropriate subtype
                class Employee {
                    public static Employee createEngineer()   { return new Engineer(); }
                    public static Employee createSalesperson(){ return new Salesperson(); }
                    public static Employee createManager()    { return new Manager(); }

                    protected Employee() {}
                }

                // Caller:
                Employee e = Employee.createEngineer();  // self-documenting!
                """;
    }

    public static class BadExample {
        public static class Employee {
            static final int ENGINEER    = 0;
            static final int SALESPERSON = 1;
            static final int MANAGER     = 2;

            private final int type;

            public Employee(int type) { this.type = type; } // type code in constructor

            public int getType() { return type; }
            public String getTypeName() {
                return switch (type) {
                    case ENGINEER    -> "Engineer";
                    case SALESPERSON -> "Salesperson";
                    case MANAGER     -> "Manager";
                    default -> "Unknown";
                };
            }
        }
    }

    public static class GoodExample {
        abstract public static class Employee {
            public abstract String getTypeName();

            public static Employee createEngineer()    { return new EngineerEmployee(); }
            public static Employee createSalesperson() { return new SalespersonEmployee(); }
            public static Employee createManager()     { return new ManagerEmployee(); }
        }

        private static class EngineerEmployee extends Employee {
            @Override public String getTypeName() { return "Engineer"; }
        }

        private static class SalespersonEmployee extends Employee {
            @Override public String getTypeName() { return "Salesperson"; }
        }

        private static class ManagerEmployee extends Employee {
            @Override public String getTypeName() { return "Manager"; }
        }
    }
}
