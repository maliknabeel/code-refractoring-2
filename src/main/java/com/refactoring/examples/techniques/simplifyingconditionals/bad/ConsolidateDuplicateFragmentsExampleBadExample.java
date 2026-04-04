package com.refactoring.examples.techniques.simplifyingconditionals.bad;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ConsolidateDuplicateFragmentsExample.*;

public class ConsolidateDuplicateFragmentsExampleBadExample {
    private double lastPrice = 100.0;
    private int    sendCount = 0;

    private void send() { sendCount++; }

    public double getPrice(boolean isSpecialDeal) {
        double price;
        if (isSpecialDeal) {
            price = lastPrice * 0.95;
            send(); // duplicated
        } else {
            price = lastPrice * 0.98;
            send(); // duplicated
        }
        return price;
    }

    public int getSendCount() { return sendCount; }
}
