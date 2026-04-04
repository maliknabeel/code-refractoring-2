package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.RemoveSettingMethodExample.*;

public class RemoveSettingMethodExampleGoodExample {
    public static class Customer {
        private final String customerId; // final — can't be changed

        public Customer(String customerId) { this.customerId = customerId; }

        public String getCustomerId() { return customerId; }
        // Setter intentionally absent
    }
}
