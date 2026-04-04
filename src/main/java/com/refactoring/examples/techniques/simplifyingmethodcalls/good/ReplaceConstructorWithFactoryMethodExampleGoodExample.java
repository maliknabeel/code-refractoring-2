package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.ReplaceConstructorWithFactoryMethodExample.*;

public class ReplaceConstructorWithFactoryMethodExampleGoodExample {
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
