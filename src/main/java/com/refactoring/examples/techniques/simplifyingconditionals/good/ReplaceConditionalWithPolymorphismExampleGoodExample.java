package com.refactoring.examples.techniques.simplifyingconditionals.good;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ReplaceConditionalWithPolymorphismExample.*;

public class ReplaceConditionalWithPolymorphismExampleGoodExample {
    abstract public static class Bird {
        protected double baseSpeed() { return 40.0; }
        public abstract double getSpeed();
    }

    public static class EuropeanBird extends Bird {
        @Override public double getSpeed() { return baseSpeed(); }
    }

    public static class AfricanBird extends Bird {
        private final double numberOfCoconuts;
        public AfricanBird(double numberOfCoconuts) { this.numberOfCoconuts = numberOfCoconuts; }
        @Override public double getSpeed() { return baseSpeed() - 2.0 * numberOfCoconuts; }
    }

    public static class NorwegianBlueBird extends Bird {
        private final boolean isNailed;
        public NorwegianBlueBird(boolean isNailed) { this.isNailed = isNailed; }
        @Override public double getSpeed() { return isNailed ? 0 : baseSpeed(); }
    }
}
