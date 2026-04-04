package com.refactoring.examples.techniques.organizingdata.bad;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceDataValueWithObjectExample.*;

public class ReplaceDataValueWithObjectExampleBadExample {
    public static class Customer {
        private final String name;
        private final String phoneNumber; // raw string

        public Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() { return name; }
        public String getPhoneNumber() { return phoneNumber; }

        public boolean isValidPhone() {
            return phoneNumber != null && phoneNumber.matches("\\d{10}");
        }
    }
}
