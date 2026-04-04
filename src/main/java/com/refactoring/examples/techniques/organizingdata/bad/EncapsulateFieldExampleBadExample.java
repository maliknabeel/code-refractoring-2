package com.refactoring.examples.techniques.organizingdata.bad;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.EncapsulateFieldExample.*;

public class EncapsulateFieldExampleBadExample {
    public static class Person {
        public String name; // public — no protection
        public int    age;  // public — no validation
    }
}
