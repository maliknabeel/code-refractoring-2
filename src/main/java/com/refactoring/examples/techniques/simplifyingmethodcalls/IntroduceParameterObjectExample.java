package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class IntroduceParameterObjectExample {

    public static String getDescription() {
        return "Introduce Parameter Object: When you have a group of parameters that naturally " +
               "go together, replace them with an object. This reduces parameter lists, creates " +
               "a home for behaviour that manipulates this data, and makes the code more " +
               "expressive.";
    }

    public static String getBadCode() {
        return """
                // BAD: start/end date parameters repeated across many methods
                List<Reading> readingsInRange(Date start, Date end) { ... }
                List<Charge>  chargesInRange(Date start, Date end)  { ... }
                double        incomeInRange(Date start, Date end)   { ... }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: DateRange parameter object groups start/end together
                class DateRange {
                    private final Date start;
                    private final Date end;

                    public DateRange(Date start, Date end) { ... }
                    boolean includes(Date date) { return !date.before(start) && !date.after(end); }
                }

                List<Reading> readingsInRange(DateRange range) { ... }
                List<Charge>  chargesInRange(DateRange range)  { ... }
                double        incomeInRange(DateRange range)   { ... }
                """;
    }

    public static class BadExample {
        public double calculateTotal(String customerName, String customerEmail,
                                     String customerAddress, double price,
                                     int quantity, double taxRate) {
            // 6 parameters — long and hard to read
            double subtotal = price * quantity;
            return subtotal + (subtotal * taxRate / 100);
        }
    }

    public static class GoodExample {
        public static class Customer {
            final String name;
            final String email;
            final String address;

            public Customer(String name, String email, String address) {
                this.name    = name;
                this.email   = email;
                this.address = address;
            }
        }

        public static class OrderDetails {
            final double price;
            final int    quantity;
            final double taxRate;

            public OrderDetails(double price, int quantity, double taxRate) {
                this.price    = price;
                this.quantity = quantity;
                this.taxRate  = taxRate;
            }

            double subtotal() { return price * quantity; }
        }

        public double calculateTotal(Customer customer, OrderDetails order) {
            // 2 meaningful parameters instead of 6 primitives
            double subtotal = order.subtotal();
            return subtotal + (subtotal * order.taxRate / 100);
        }
    }
}
