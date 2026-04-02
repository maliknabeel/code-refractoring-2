package com.refactoring.examples.techniques.movingfeatures;

import java.util.Date;

public class IntroduceForeignMethodExample {

    public static String getDescription() {
        return "Introduce Foreign Method: When a server class needs an additional method but you " +
               "can't modify the class, create a method in the client class that accepts an " +
               "instance of the server class as its first argument. Use this when you want to add " +
               "behaviour to a class you cannot change (e.g. a library class).";
    }

    public static String getBadCode() {
        return """
                // BAD: 'nextDay' logic is duplicated everywhere because Date has no nextDay()
                Date newStart = new Date(previousEnd.getYear(),
                                         previousEnd.getMonth(),
                                         previousEnd.getDate() + 1);
                // This date arithmetic is scattered all over the codebase
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Foreign method added to the client class — one place, named clearly
                // This is a "foreign method" - should really be on Date but we can't add it
                private Date nextDay(Date date) {
                    return new Date(date.getYear(), date.getMonth(), date.getDate() + 1);
                }

                // Usage
                Date newStart = nextDay(previousEnd);
                """;
    }

    public static class BadExample {
        @SuppressWarnings("deprecation")
        public String scheduleNextMeeting(int year, int month, int day) {
            // Duplicated inline date arithmetic — no reusable helper
            int nextDay = day + 1;
            int nextMonth = month;
            int nextYear = year;
            if (nextDay > 30) { nextDay = 1; nextMonth++; }
            if (nextMonth > 11) { nextMonth = 0; nextYear++; }
            return nextYear + "-" + String.format("%02d", nextMonth + 1) + "-" + String.format("%02d", nextDay);
        }
    }

    public static class GoodExample {
        // Foreign method introduced on the client — can't change the library class
        private String nextDay(int year, int month, int day) {
            int nd = day + 1;
            int nm = month;
            int ny = year;
            if (nd > 30) { nd = 1; nm++; }
            if (nm > 11) { nm = 0; ny++; }
            return ny + "-" + String.format("%02d", nm + 1) + "-" + String.format("%02d", nd);
        }

        public String scheduleNextMeeting(int year, int month, int day) {
            return nextDay(year, month, day); // clean call using the foreign method
        }
    }
}
