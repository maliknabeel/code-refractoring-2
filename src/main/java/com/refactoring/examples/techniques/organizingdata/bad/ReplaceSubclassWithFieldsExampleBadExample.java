package com.refactoring.examples.techniques.organizingdata.bad;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceSubclassWithFieldsExample.*;

public class ReplaceSubclassWithFieldsExampleBadExample {
    abstract public static class Person {
        abstract boolean isMale();
        abstract char    getCode();
        abstract String  getLabel();
    }

    public static class Male extends Person {
        @Override boolean isMale()  { return true; }
        @Override char    getCode() { return 'M'; }
        @Override String  getLabel(){ return "Male"; }
    }

    public static class Female extends Person {
        @Override boolean isMale()  { return false; }
        @Override char    getCode() { return 'F'; }
        @Override String  getLabel(){ return "Female"; }
    }
}
