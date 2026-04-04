package com.refactoring.examples.techniques.simplifyingconditionals.bad;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ReplaceConditionalWithPolymorphismExample.*;

public class ReplaceConditionalWithPolymorphismExampleBadExample {
    enum BirdType { EUROPEAN, AFRICAN, NORWEGIAN_BLUE }

    public static class Bird {
        private final BirdType type;
        private final double   numberOfCoconuts;
        private final boolean  isNailed;

        public Bird(BirdType type, double numberOfCoconuts, boolean isNailed) {
            this.type = type; this.numberOfCoconuts = numberOfCoconuts; this.isNailed = isNailed;
        }

        private double baseSpeed()   { return 40.0; }
        private double loadFactor()  { return 2.0; }

        public double getSpeed() {
            return switch (type) {
                case EUROPEAN       -> baseSpeed();
                case AFRICAN        -> baseSpeed() - loadFactor() * numberOfCoconuts;
                case NORWEGIAN_BLUE -> isNailed ? 0 : baseSpeed();
            };
        }
    }
}
