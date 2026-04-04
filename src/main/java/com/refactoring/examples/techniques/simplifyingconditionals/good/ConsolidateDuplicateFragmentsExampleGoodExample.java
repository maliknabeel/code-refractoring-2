package com.refactoring.examples.techniques.simplifyingconditionals.good;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ConsolidateDuplicateFragmentsExample.*;

public class ConsolidateDuplicateFragmentsExampleGoodExample {
    private double lastPrice = 100.0;
    private int    sendCount = 0;

    private void send() { sendCount++; }

    public double getPrice(boolean isSpecialDeal) {
        double price = isSpecialDeal ? lastPrice * 0.95 : lastPrice * 0.98;
        send(); // called once
        return price;
    }

    public int getSendCount() { return sendCount; }
}
