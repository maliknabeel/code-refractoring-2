package edu.pafiast.refractoring.techniques.organizingdata.bad;

import edu.pafiast.refractoring.techniques.organizingdata.*;

public class EncapsulateFieldExampleBadExample {
    public static class Person {
        public String name; // public — no protection
        public int    age;  // public — no validation
    }
}
