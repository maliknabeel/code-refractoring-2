package com.refactoring.examples.techniques.composingmethods.good;

import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.ExtractMethodExample.*;

public class ExtractMethodExampleGoodExample {
    private String name = "John";
    private double[] orderAmounts = {10.0, 20.0, 30.0};

    public String printOwing() {
        return printBanner() + calculateAndPrintDetails();
    }

    private String printBanner() {
        return "*************************\n***** Customer Owes *****\n*************************\n";
    }

    private double calculateOutstanding() {
        double result = 0.0;
        for (double amount : orderAmounts) {
            result += amount;
        }
        return result;
    }

    private String calculateAndPrintDetails() {
        double outstanding = calculateOutstanding();
        return "name: " + name + "\namount: " + outstanding + "\n";
    }
}
