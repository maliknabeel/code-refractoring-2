package edu.pafiast.refractoring.techniques.generalization;

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
        public String getName() { return name; }
        public double getTotalCharge() { return 25.0; }
    }
}
