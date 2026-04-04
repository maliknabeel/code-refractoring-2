package edu.pafiast.refractoring.techniques.generalization;

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
}
