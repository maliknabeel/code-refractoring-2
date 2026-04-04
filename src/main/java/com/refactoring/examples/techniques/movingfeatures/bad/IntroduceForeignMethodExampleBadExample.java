package com.refactoring.examples.techniques.movingfeatures.bad;

import java.util.Date;
import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.IntroduceForeignMethodExample.*;

public class IntroduceForeignMethodExampleBadExample {
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
