package edu.pafiast.refractoring.techniques.organizingdata.good;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceDataValueWithObjectExample.*;

public class ReplaceDataValueWithObjectExampleGoodExample {
    public static class PhoneNumber {
        private final String number;

        public PhoneNumber(String number) {
            if (number == null || !number.matches("\\d{10}")) {
                throw new IllegalArgumentException("Phone number must be 10 digits");
            }
            this.number = number;
        }

        public String getAreaCode()  { return number.substring(0, 3); }
        public String getExchange()  { return number.substring(3, 6); }
        public String getSubscriber(){ return number.substring(6); }

        public String format() {
            return "(" + getAreaCode() + ") " + getExchange() + "-" + getSubscriber();
        }
    }

    public static class Customer {
        private final String name;
        private final PhoneNumber phoneNumber;

        public Customer(String name, PhoneNumber phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() { return name; }
        public PhoneNumber getPhoneNumber() { return phoneNumber; }
    }
}
