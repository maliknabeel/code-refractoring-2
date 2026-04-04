package edu.pafiast.refractoring.techniques.movingfeatures.good;

import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.InlineClassExample.*;

public class InlineClassExampleGoodExample {
    public static class Person {
        private String telephoneAreaCode;
        private String telephoneNumber;

        public String getTelephoneAreaCode()  { return telephoneAreaCode; }
        public String getTelephoneNumber()    { return telephoneNumber; }
        public void   setTelephoneAreaCode(String arg) { this.telephoneAreaCode = arg; }
        public void   setTelephoneNumber(String arg)   { this.telephoneNumber = arg; }

        public String getFormattedNumber() {
            return "(" + telephoneAreaCode + ") " + telephoneNumber;
        }
    }
}
