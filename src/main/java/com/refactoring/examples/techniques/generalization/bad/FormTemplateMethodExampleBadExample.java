package com.refactoring.examples.techniques.generalization.bad;

import com.refactoring.examples.techniques.generalization.*;
import com.refactoring.examples.techniques.generalization.FormTemplateMethodExample.*;

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
