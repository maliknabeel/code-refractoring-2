package com.refactoring.examples.techniques.organizingdata.good;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceSubclassWithFieldsExample.*;

public class ReplaceSubclassWithFieldsExampleGoodExample {
    public static class Person {
        private final boolean isMale;
        private final char    code;
        private final String  label;

        public static Person createMale()   { return new Person(true,  'M', "Male"); }
        public static Person createFemale() { return new Person(false, 'F', "Female"); }

        private Person(boolean isMale, char code, String label) {
            this.isMale = isMale;
            this.code   = code;
            this.label  = label;
        }

        public boolean isMale()  { return isMale; }
        public char    getCode() { return code; }
        public String  getLabel(){ return label; }
    }
}
