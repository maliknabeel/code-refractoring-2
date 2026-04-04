package com.refactoring.examples.techniques.organizingdata.bad;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.SelfEncapsulateFieldExample.*;

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
