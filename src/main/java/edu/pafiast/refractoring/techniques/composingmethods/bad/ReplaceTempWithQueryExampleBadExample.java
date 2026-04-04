package edu.pafiast.refractoring.techniques.composingmethods.bad;

import java.util.List;
import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.ReplaceTempWithQueryExample.*;

public class ReplaceTempWithQueryExampleBadExample {
    private int quantity;
    private double itemPrice;

    public ReplaceTempWithQueryExampleBadExample(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice() {
        double basePrice = quantity * itemPrice;
        double discountFactor = basePrice > 1000 ? 0.95 : 0.98;
        return basePrice * discountFactor;
    }
}
