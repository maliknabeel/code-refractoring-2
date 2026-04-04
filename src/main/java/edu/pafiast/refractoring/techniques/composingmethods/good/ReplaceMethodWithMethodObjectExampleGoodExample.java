package edu.pafiast.refractoring.techniques.composingmethods.good;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.ReplaceMethodWithMethodObjectExample.*;

public class ReplaceMethodWithMethodObjectExampleGoodExample {
    public static class PriceCalculator {
        private final double primaryBase;
        private final double secondaryBase;
        private final double tertiary;

        public PriceCalculator(double primaryBase, double secondaryBase, double tertiary) {
            this.primaryBase   = primaryBase;
            this.secondaryBase = secondaryBase;
            this.tertiary      = tertiary;
        }

        public double compute() {
            double base   = calculateBase();
            double value1 = calculateImportantValue1(base);
            double value2 = calculateImportantValue2(base, value1);
            return base - value1 - value2;
        }

        private double calculateBase() {
            return (primaryBase  - primaryBase  * 0.2)
                 + (secondaryBase - secondaryBase * 0.05)
                 + tertiary;
        }

        private double calculateImportantValue1(double base) {
            return (base - 100) * primaryBase * 0.01;
        }

        private double calculateImportantValue2(double base, double value1) {
            double v2 = value1 * 0.5;
            return (base - value1) > 1000 ? v2 - 20 : v2;
        }
    }

    public double price(double primaryBase, double secondaryBase, double tertiary) {
        return new PriceCalculator(primaryBase, secondaryBase, tertiary).compute();
    }
}
