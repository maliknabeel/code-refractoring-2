package edu.pafiast.refractoring.techniques.simplifyingconditionals.bad;

import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.ConsolidateDuplicateFragmentsExample.*;

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
