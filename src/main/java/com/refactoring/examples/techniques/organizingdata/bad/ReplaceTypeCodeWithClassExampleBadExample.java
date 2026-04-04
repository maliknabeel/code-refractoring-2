package com.refactoring.examples.techniques.organizingdata.bad;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceTypeCodeWithClassExample.*;

public class ReplaceTypeCodeWithClassExampleBadExample {
    public static class Person {
        public static final int O  = 0;
        public static final int A  = 1;
        public static final int B  = 2;
        public static final int AB = 3;

        private int bloodGroup;

        public void setBloodGroup(int bloodGroup) {
            this.bloodGroup = bloodGroup; // no validation
        }

        public int getBloodGroup() { return bloodGroup; }
    }
}
