package edu.pafiast.refractoring.techniques.composingmethods.good;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.SplitTemporaryVariableExample.*;

public class SplitTemporaryVariableExampleGoodExample {
    public double[] computePhysics(double initialVelocity, double acceleration, double time) {
        double initialComponent = initialVelocity * time; // clear purpose
        double distance = initialComponent + 0.5 * acceleration * time * time;

        double finalVelocity = initialVelocity + acceleration * time; // separate variable
        return new double[]{distance, finalVelocity};
    }
}
