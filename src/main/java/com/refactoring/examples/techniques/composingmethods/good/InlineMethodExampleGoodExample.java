package com.refactoring.examples.techniques.composingmethods.good;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.InlineMethodExample.*;

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
