package edu.pafiast.refractoring.techniques.composingmethods.bad;

import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.ExtractMethodExample.*;

public class ExtractMethodExampleBadExample {
    private String name = "John";
    private double[] orderAmounts = {10.0, 20.0, 30.0};

    public String printOwing() {
        StringBuilder sb = new StringBuilder();
        double outstanding = 0.0;
        sb.append("*************************\n");
        sb.append("***** Customer Owes *****\n");
        sb.append("*************************\n");
        for (double amount : orderAmounts) {
            outstanding += amount;
        }
        sb.append("name: ").append(name).append("\n");
        sb.append("amount: ").append(outstanding).append("\n");
        return sb.toString();
    }
}
