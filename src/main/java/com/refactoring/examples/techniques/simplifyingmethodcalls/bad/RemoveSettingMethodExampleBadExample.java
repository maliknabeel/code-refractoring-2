package com.refactoring.examples.techniques.simplifyingmethodcalls.bad;

import com.refactoring.examples.techniques.simplifyingmethodcalls.*;
import com.refactoring.examples.techniques.simplifyingmethodcalls.RemoveSettingMethodExample.*;

public class RemoveSettingMethodExampleBadExample {
    public static class Customer {
        private String customerId;

        public Customer(String customerId) { this.customerId = customerId; }

        public void   setCustomerId(String id) { this.customerId = id; } // should not exist
        public String getCustomerId()           { return customerId; }
    }
}
