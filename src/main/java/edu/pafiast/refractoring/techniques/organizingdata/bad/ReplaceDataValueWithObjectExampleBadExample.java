package edu.pafiast.refractoring.techniques.organizingdata.bad;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceDataValueWithObjectExample.*;

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
