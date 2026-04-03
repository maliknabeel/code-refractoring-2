package com.refactoring.examples.techniques.generalization;

public class ExtractSubclassExample {

    public static String getDescription() {
        return "Extract Subclass: When a class has features that are used only in some instances, " +
               "create a subclass for that subset of features. Using a subclass is better than " +
               "using a type code to conditionally provide features — it's more expressive and " +
               "uses polymorphism.";
    }

    public static String getBadCode() {
        return """
                // BAD: JobItem has fields/methods only relevant when it's a labour item
                class JobItem {
                    private int    unitPrice;
                    private int    quantity;
                    private boolean isLabor;     // type flag
                    private Employee employee;   // only used when isLabor == true

                    int getUnitPrice() {
                        return isLabor ? employee.getRate() : unitPrice;  // type switch
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: LaborItem extracted as a subclass — clean separation
                class JobItem {
                    protected int unitPrice;
                    protected int quantity;

                    int getUnitPrice() { return unitPrice; }
                    int getTotalPrice() { return unitPrice * quantity; }
                }

                class LaborItem extends JobItem {
                    private Employee employee;

                    public LaborItem(int quantity, Employee employee) {
                        this.quantity = quantity;
                        this.employee = employee;
                    }

                    @Override int getUnitPrice() { return employee.getRate(); }
                }
                """;
    }

    public static class BadExample {
        public static class Employee {
            private final int rate;
            public Employee(int rate) { this.rate = rate; }
            int getRate() { return rate; }
        }

        public static class JobItem {
            private final int unitPrice;
            private final int quantity;
            private final boolean isLabor;
            private final Employee employee;

            public JobItem(int unitPrice, int quantity) {
                this.unitPrice = unitPrice; this.quantity = quantity;
                this.isLabor = false; this.employee = null;
            }

            public JobItem(int quantity, Employee employee) {
                this.unitPrice = 0; this.quantity = quantity;
                this.isLabor = true; this.employee = employee;
            }

            public int getUnitPrice() {
                return isLabor ? employee.getRate() : unitPrice; // type switch
            }

            public int getTotalPrice() { return getUnitPrice() * quantity; }
        }
    }

    public static class GoodExample {
        public static class Employee {
            private final int rate;
            public Employee(int rate) { this.rate = rate; }
            int getRate() { return rate; }
        }

        public static class JobItem {
            protected final int unitPrice;
            protected final int quantity;

            public JobItem(int unitPrice, int quantity) {
                this.unitPrice = unitPrice;
                this.quantity  = quantity;
            }

            public int getUnitPrice()   { return unitPrice; }
            public int getTotalPrice()  { return getUnitPrice() * quantity; }
        }

        public static class LaborItem extends JobItem {
            private final Employee employee;

            public LaborItem(int quantity, Employee employee) {
                super(0, quantity);
                this.employee = employee;
            }

            @Override public int getUnitPrice() { return employee.getRate(); } // polymorphism
        }
    }
}
