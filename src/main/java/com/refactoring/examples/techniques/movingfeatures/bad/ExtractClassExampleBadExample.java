package com.refactoring.examples.techniques.movingfeatures.bad;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.ExtractClassExample.*;

public class ExtractClassExampleBadExample {
    public static class Person {
        private String name;
        private String officeAreaCode;
        private String officeNumber;

        public Person(String name, String officeAreaCode, String officeNumber) {
            this.name = name;
            this.officeAreaCode = officeAreaCode;
            this.officeNumber = officeNumber;
        }

        public String getName() { return name; }

        public String getTelephoneNumber() {
            return "(" + officeAreaCode + ") " + officeNumber;
        }

        public String getOfficeAreaCode() { return officeAreaCode; }
        public String getOfficeNumber() { return officeNumber; }
    }
}
