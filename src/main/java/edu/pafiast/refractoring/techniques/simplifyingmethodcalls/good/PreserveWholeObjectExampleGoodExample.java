package edu.pafiast.refractoring.techniques.simplifyingmethodcalls.good;

import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.*;
import edu.pafiast.refractoring.techniques.simplifyingmethodcalls.PreserveWholeObjectExample.*;

public class PreserveWholeObjectExampleGoodExample {
    public static class HeatingPlan {
        private final int rangeMin;
        private final int rangeMax;

        public HeatingPlan(int rangeMin, int rangeMax) {
            this.rangeMin = rangeMin;
            this.rangeMax = rangeMax;
        }

        public boolean withinRange(Room room) { // receives whole object
            return room.getLow() >= rangeMin && room.getHigh() <= rangeMax;
        }
    }

    public boolean checkRange(Room room, HeatingPlan plan) {
        return plan.withinRange(room); // whole object passed
    }
}
