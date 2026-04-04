package edu.pafiast.refractoring.techniques.composingmethods.bad;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.ReplaceMethodWithMethodObjectExample.*;

public class ReplaceMethodWithMethodObjectExampleBadExample {
    public double price(double primaryBase, double secondaryBase, double tertiary) {
        double primaryDiscount   = primaryBase  * 0.1 * 2;
        double secondaryDiscount = secondaryBase * 0.05;
        double base = (primaryBase  - primaryDiscount)
                    + (secondaryBase - secondaryDiscount)
                    + tertiary;
        double importantValue1 = (base - 100) * primaryBase * 0.01;
        double importantValue2 = importantValue1 * 0.5;
        if ((base - importantValue1) > 1000) {
            importantValue2 -= 20;
        }
        return base - importantValue1 - importantValue2;
    }
}
