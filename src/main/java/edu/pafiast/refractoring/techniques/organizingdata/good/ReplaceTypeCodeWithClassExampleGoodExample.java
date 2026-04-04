package edu.pafiast.refractoring.techniques.organizingdata.good;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceTypeCodeWithClassExample.*;

public class ReplaceTypeCodeWithClassExampleGoodExample {
    public static class BloodGroup {
        public static final BloodGroup O  = new BloodGroup(0, "O");
        public static final BloodGroup A  = new BloodGroup(1, "A");
        public static final BloodGroup B  = new BloodGroup(2, "B");
        public static final BloodGroup AB = new BloodGroup(3, "AB");

        private final int    code;
        private final String label;

        private BloodGroup(int code, String label) {
            this.code  = code;
            this.label = label;
        }

        public int    getCode()  { return code; }
        public String getLabel() { return label; }

        @Override public String toString() { return label; }
    }

    public static class Person {
        private BloodGroup bloodGroup;

        public void setBloodGroup(BloodGroup bg) { this.bloodGroup = bg; }
        public BloodGroup getBloodGroup()        { return bloodGroup; }
    }
}
