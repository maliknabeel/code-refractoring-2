package edu.pafiast.refractoring.techniques.composingmethods.bad;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.SplitTemporaryVariableExample.*;

public class SplitTemporaryVariableExampleBadExample {
    public double[] computePhysics(double initialVelocity, double acceleration, double time) {
        double temp = initialVelocity * time;             // distance calculation
        double distance = temp + 0.5 * acceleration * time * time;
        temp = initialVelocity + acceleration * time;     // velocity - temp reused!
        double finalVelocity = temp;
        return new double[]{distance, finalVelocity};
    }
}
