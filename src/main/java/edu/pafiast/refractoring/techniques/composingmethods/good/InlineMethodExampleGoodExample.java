package edu.pafiast.refractoring.techniques.composingmethods.good;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.InlineMethodExample.*;

public class InlineMethodExampleGoodExample {
    private int numberOfLateDeliveries;

    public InlineMethodExampleGoodExample(int numberOfLateDeliveries) {
        this.numberOfLateDeliveries = numberOfLateDeliveries;
    }

    // Inlined: the condition speaks for itself
    public int getRating() {
        return numberOfLateDeliveries > 5 ? 2 : 1;
    }
}
