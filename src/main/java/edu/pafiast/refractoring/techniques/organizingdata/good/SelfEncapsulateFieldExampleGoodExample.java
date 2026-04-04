package edu.pafiast.refractoring.techniques.organizingdata.good;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.SelfEncapsulateFieldExample.*;

public class SelfEncapsulateFieldExampleGoodExample {
    public static class Range {
        private int low;
        private int high;

        public Range(int low, int high) { this.low = low; this.high = high; }

        protected int getLow()  { return low; }
        protected int getHigh() { return high; }

        public boolean includes(int arg) {
            return arg >= getLow() && arg <= getHigh(); // via accessor
        }
    }

    public static class CappedRange extends Range {
        private final int cap;

        public CappedRange(int low, int high, int cap) {
            super(low, high);
            this.cap = cap;
        }

        @Override
        protected int getHigh() { return Math.min(super.getHigh(), cap); }
    }
}
