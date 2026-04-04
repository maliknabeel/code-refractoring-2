package edu.pafiast.refractoring.techniques.organizingdata.good;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.EncapsulateFieldExample.*;

public class EncapsulateFieldExampleGoodExample {
    public static class Person {
        private String name;
        private int    age;

        public String getName() { return name; }

        public void setName(String name) {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank");
            }
            this.name = name;
        }

        public int getAge() { return age; }

        public void setAge(int age) {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Age must be between 0 and 150");
            }
            this.age = age;
        }
    }
}
