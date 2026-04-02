package com.refactoring.examples.techniques.generalization;

public class FormTemplateMethodExample {

    public static String getDescription() {
        return "Form Template Method: When you have two methods in subclasses that perform similar " +
               "steps in the same order but with different implementations, get the steps into " +
               "methods with the same signature so the original methods become the same. Then " +
               "pull them up to the superclass. This is the Template Method design pattern.";
    }

    public static String getBadCode() {
        return """
                // BAD: Two statement methods with same structure but duplicated skeleton
                class HtmlStatement {
                    String value(Customer customer) {
                        String result = "<h1>Rental Record for " + customer.getName() + "</h1>\\n";
                        for (Rental r : customer.getRentals()) {
                            result += "\\t" + r.getMovie().getTitle() + "\\t" + r.getCharge() + "\\n";
                        }
                        result += "<p>Amount owed: <em>" + customer.getTotalCharge() + "</em></p>";
                        return result;
                    }
                }

                class TextStatement {
                    String value(Customer customer) {
                        String result = "Rental Record for " + customer.getName() + "\\n";
                        for (Rental r : customer.getRentals()) {
                            result += "\\t" + r.getMovie().getTitle() + "\\t" + r.getCharge() + "\\n";
                        }
                        result += "Amount owed: " + customer.getTotalCharge();
                        return result;
                    }
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Template Method in superclass; only format-specific steps differ
                abstract class Statement {
                    String value(Customer customer) {
                        String result = headerString(customer);
                        for (Rental r : customer.getRentals()) {
                            result += eachRentalString(r);
                        }
                        result += footerString(customer);
                        return result;
                    }

                    protected abstract String headerString(Customer customer);
                    protected abstract String eachRentalString(Rental rental);
                    protected abstract String footerString(Customer customer);
                }

                class HtmlStatement extends Statement {
                    protected String headerString(Customer c)     { return "<h1>..."+c.getName()+"</h1>\\n"; }
                    protected String eachRentalString(Rental r)   { return "\\t<b>"+r.getMovie()+"</b>\\n"; }
                    protected String footerString(Customer c)     { return "<p>Total: "+c.getTotalCharge()+"</p>"; }
                }
                """;
    }

    public static class Customer {
        private final String name;
        public Customer(String name) { this.name = name; }
        String getName() { return name; }
        double getTotalCharge() { return 25.0; }
    }

    public static class BadExample {
        public static class HtmlStatement {
            public String value(Customer customer) {
                return "<h1>Record for " + customer.getName() + "</h1>\nTotal: " + customer.getTotalCharge();
            }
        }

        public static class TextStatement {
            public String value(Customer customer) {
                return "Record for " + customer.getName() + "\nTotal: " + customer.getTotalCharge();
            }
        }
    }

    public static class GoodExample {
        abstract public static class Statement {
            public final String value(Customer customer) {
                return headerString(customer) + detailString(customer) + footerString(customer);
            }

            protected abstract String headerString(Customer customer);
            protected abstract String detailString(Customer customer);
            protected abstract String footerString(Customer customer);
        }

        public static class HtmlStatement extends Statement {
            @Override protected String headerString(Customer c) { return "<h1>Record for " + c.getName() + "</h1>\n"; }
            @Override protected String detailString(Customer c) { return "<ul><li>Details...</li></ul>\n"; }
            @Override protected String footerString(Customer c) { return "<p>Total: " + c.getTotalCharge() + "</p>"; }
        }

        public static class TextStatement extends Statement {
            @Override protected String headerString(Customer c) { return "Record for " + c.getName() + "\n"; }
            @Override protected String detailString(Customer c) { return "  Details...\n"; }
            @Override protected String footerString(Customer c) { return "Total: " + c.getTotalCharge(); }
        }
    }
}
