package edu.pafiast.refractoring.techniques.movingfeatures.good;

import java.util.Date;
import edu.pafiast.refractoring.techniques.movingfeatures.*;
import edu.pafiast.refractoring.techniques.movingfeatures.IntroduceForeignMethodExample.*;

public class IntroduceForeignMethodExampleGoodExample {
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
