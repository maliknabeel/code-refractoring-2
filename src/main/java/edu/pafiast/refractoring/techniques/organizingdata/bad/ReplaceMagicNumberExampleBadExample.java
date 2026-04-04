package edu.pafiast.refractoring.techniques.organizingdata.bad;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceMagicNumberExample.*;

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
