package com.refactoring.examples.techniques.organizingdata.bad;

import com.refactoring.examples.techniques.organizingdata.*;
import com.refactoring.examples.techniques.organizingdata.ReplaceMagicNumberExample.*;

public class ReplaceMagicNumberExampleBadExample {
    public double potentialEnergy(double mass, double height) {
        return mass * 9.81 * height;
    }

    public double circleArea(double radius) {
        return 3.14159265358979 * radius * radius;
    }

    public double annualToMonthly(double annual) {
        return annual / 12;
    }

    public boolean isAdult(int age) {
        return age >= 18;
    }
}
