package com.refactoring.examples.techniques.movingfeatures.good;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.ExtractClassExample.*;

public class ExtractClassExampleGoodExample {
    public static class TelephoneNumber {
        private final String areaCode;
        private final String number;

        public TelephoneNumber(String areaCode, String number) {
            this.areaCode = areaCode;
            this.number = number;
        }

        public String getTelephoneNumber() {
            return "(" + areaCode + ") " + number;
        }
    }

    public static class Person {
        private final String name;
        private final TelephoneNumber officeTelephone;

        public Person(String name, TelephoneNumber officeTelephone) {
            this.name = name;
            this.officeTelephone = officeTelephone;
        }

        public String getName() { return name; }

        public String getTelephoneNumber() {
            return officeTelephone.getTelephoneNumber();
        }
    }
}
