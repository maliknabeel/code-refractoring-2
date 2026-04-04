package edu.pafiast.refractoring.techniques.generalization.good;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.FormTemplateMethodExample.*;

public class FormTemplateMethodExampleGoodExample {
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
