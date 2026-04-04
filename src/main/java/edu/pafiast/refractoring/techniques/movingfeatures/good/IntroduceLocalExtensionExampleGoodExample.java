package edu.pafiast.refractoring.techniques.movingfeatures.good;

import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.IntroduceLocalExtensionExample.*;

public class IntroduceLocalExtensionExampleGoodExample {
    // Local Extension: a wrapper that bundles all extra behaviour
    public static class MfDate {
        private final int year;
        private final int month;
        private final int day;

        public MfDate(int year, int month, int day) {
            this.year  = year;
            this.month = month;
            this.day   = day;
        }

        public MfDate nextDay()  { return new MfDate(year, month, day + 1); }
        public MfDate nextWeek() { return new MfDate(year, month, day + 7); }

        public boolean isWeekend(int dayOfWeek) {
            return dayOfWeek == 6 || dayOfWeek == 7;
        }

        public String format() {
            return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
        }
    }

    public String processDate(int year, int month, int day) {
        MfDate date = new MfDate(year, month, day);
        return "Next week: " + date.nextWeek().format();
    }
}
