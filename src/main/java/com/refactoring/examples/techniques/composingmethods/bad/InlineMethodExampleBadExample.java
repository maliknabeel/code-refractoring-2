package com.refactoring.examples.techniques.composingmethods.bad;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.InlineMethodExample.*;

public class InlineMethodExampleBadExample {
    private int numberOfLateDeliveries;

    public InlineMethodExampleBadExample(int numberOfLateDeliveries) {
        this.numberOfLateDeliveries = numberOfLateDeliveries;
    }

    public int getRating() {
        return moreThanFiveLateDeliveries() ? 2 : 1;
    }

    // This method exists only to wrap a trivial boolean expression
    private boolean moreThanFiveLateDeliveries() {
        return numberOfLateDeliveries > 5;
    }
}
