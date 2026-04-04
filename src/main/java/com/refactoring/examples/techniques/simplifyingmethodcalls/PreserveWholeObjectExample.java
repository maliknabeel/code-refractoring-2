package com.refactoring.examples.techniques.simplifyingmethodcalls;

public class PreserveWholeObjectExample {

    public static String getDescription() {
        return "Preserve Whole Object: When you are getting several values from an object and " +
               "passing these values as parameters in a method call, send the whole object " +
               "instead. This reduces the number of parameters and makes the code less fragile " +
               "to changes in what data the method needs.";
    }

    public static String getBadCode() {
        return """
                // BAD: Extracting individual values from Room just to pass them separately
                boolean withinRange(Room room) {
                    int low  = room.getLow();    // extracting...
                    int high = room.getHigh();   // extracting...
                    return plan.withinRange(low, high);  // passing fragments
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Pass the whole Room object — less coupling to its internals
                boolean withinRange(Room room) {
                    return plan.withinRange(room);  // Room passed whole
                }

                // HeatingPlan:
                boolean withinRange(Room room) {
                    return room.getLow()  >= rangeMin
                        && room.getHigh() <= rangeMax;
                }
                """;
    }

    public static class Room {
        private final int low;
        private final int high;
        public Room(int low, int high) { this.low = low; this.high = high; }
        public int getLow()  { return low; }
        public int getHigh() { return high; }
    }
}
