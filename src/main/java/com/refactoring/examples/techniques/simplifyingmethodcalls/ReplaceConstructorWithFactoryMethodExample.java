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
}
