package com.refactoring.examples.techniques.composingmethods.good;

import java.util.List;
import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.ReplaceTempWithQueryExample.*;

public class ReplaceTempWithQueryExampleGoodExample {
    private int quantity;
    private double itemPrice;

    public ReplaceTempWithQueryExampleGoodExample(int quantity, double itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double getPrice() {
        return basePrice() * discountFactor();
    }

    public double basePrice() {
        return quantity * itemPrice;
    }

    public double discountFactor() {
        return basePrice() > 1000 ? 0.95 : 0.98;
    }
}
