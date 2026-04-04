package com.refactoring.examples.techniques.movingfeatures.bad;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.InlineClassExample.*;

public class InlineClassExampleBadExample {
    public static class TelephoneNumber {
        String areaCode;
        String number;
    }

    public static class Person {
        private final TelephoneNumber telephone = new TelephoneNumber();

        public String getAreaCode()  { return telephone.areaCode; }
        public String getNumber()    { return telephone.number; }
        public void   setAreaCode(String arg) { telephone.areaCode = arg; }
        public void   setNumber(String arg)   { telephone.number = arg; }
    }
}
