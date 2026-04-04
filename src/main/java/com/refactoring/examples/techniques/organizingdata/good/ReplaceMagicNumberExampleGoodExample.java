package com.refactoring.examples.techniques.organizingdata.good;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceMagicNumberExample.*;

public class ReplaceMagicNumberExampleGoodExample {
    private static final double GRAVITATIONAL_CONSTANT = 9.81;
    private static final double PI                     = Math.PI;
    private static final int    MONTHS_PER_YEAR        = 12;
    private static final int    LEGAL_ADULT_AGE        = 18;

    public double potentialEnergy(double mass, double height) {
        return mass * GRAVITATIONAL_CONSTANT * height;
    }

    public double circleArea(double radius) {
        return PI * radius * radius;
    }

    public double annualToMonthly(double annual) {
        return annual / MONTHS_PER_YEAR;
    }

    public boolean isAdult(int age) {
        return age >= LEGAL_ADULT_AGE;
    }
}
