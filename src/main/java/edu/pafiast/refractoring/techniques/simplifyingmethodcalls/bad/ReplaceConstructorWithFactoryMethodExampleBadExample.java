package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.bad;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.ReplaceConstructorWithFactoryMethodExample.*;

public class ReplaceConstructorWithFactoryMethodExampleBadExample {
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
