package edu.pafiast.refractoring.techniques.generalization.bad;

import edu.pafiast.refractoring.techniques.generalization.*;
import edu.pafiast.refractoring.techniques.generalization.FormTemplateMethodExample.*;

public class FormTemplateMethodExampleBadExample {
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
