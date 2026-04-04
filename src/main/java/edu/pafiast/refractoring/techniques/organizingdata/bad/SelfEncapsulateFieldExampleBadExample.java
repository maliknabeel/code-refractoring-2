package edu.pafiast.refractoring.techniques.organizingdata.bad;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.SelfEncapsulateFieldExample.*;

public class SelfEncapsulateFieldExampleBadExample {
    public static class Range {
        private int low;
        private int high;

        public Range(int low, int high) { this.low = low; this.high = high; }

        public boolean includes(int arg) {
            return arg >= low && arg <= high; // direct field access
        }
    }
}
