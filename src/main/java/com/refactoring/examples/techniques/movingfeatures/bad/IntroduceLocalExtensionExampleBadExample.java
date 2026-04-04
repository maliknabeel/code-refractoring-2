package com.refactoring.examples.techniques.movingfeatures.bad;

import com.refactoring.examples.techniques.movingfeatures.*;
import com.refactoring.examples.techniques.movingfeatures.IntroduceLocalExtensionExample.*;

public class IntroduceLocalExtensionExampleBadExample {
    // Foreign methods scattered in client code
    private String addDays(int year, int month, int day, int daysToAdd) {
        return year + "-" + month + "-" + (day + daysToAdd);
    }

    private boolean isWeekend(int dayOfWeek) {
        return dayOfWeek == 6 || dayOfWeek == 7;
    }

    public String processDate(int year, int month, int day) {
        String nextWeek = addDays(year, month, day, 7);
        return "Next week: " + nextWeek;
    }
}
