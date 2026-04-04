package com.refactoring.examples.techniques.simplifyingmethodcalls.good;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.RemoveSettingMethodExample.*;

public class RemoveSettingMethodExampleGoodExample {
    public static class Customer {
        private final String customerId; // final — can't be changed

        public Customer(String customerId) { this.customerId = customerId; }

        public String getCustomerId() { return customerId; }
        // Setter intentionally absent
    }
}
