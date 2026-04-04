package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.bad;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.PreserveWholeObjectExample.*;

public class PreserveWholeObjectExampleBadExample {
    public static class HeatingPlan {
        private final int rangeMin;
        private final int rangeMax;

        public HeatingPlan(int rangeMin, int rangeMax) {
            this.rangeMin = rangeMin;
            this.rangeMax = rangeMax;
        }

        public boolean withinRange(int low, int high) { // receives fragments
            return low >= rangeMin && high <= rangeMax;
        }
    }

    public boolean checkRange(Room room, HeatingPlan plan) {
        int low  = room.getLow();
        int high = room.getHigh();
        return plan.withinRange(low, high); // passing fragments
    }
}
