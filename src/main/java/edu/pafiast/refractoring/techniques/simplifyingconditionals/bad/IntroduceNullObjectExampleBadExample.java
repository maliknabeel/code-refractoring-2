package edu.pafiast.refractoring.techniques.simplifyingconditionals.bad;

import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.IntroduceNullObjectExample.*;

public class IntroduceNullObjectExampleBadExample {
    public String getCustomerName(Customer customer) {
        if (customer == null) return "occupant";
        return customer.getName();
    }

    public String getCustomerPlan(Customer customer) {
        if (customer == null) return "BASIC";
        return customer.getPlan();
    }

    public int getPlanCode(Customer customer) {
        if (customer == null) return 0;
        return customer.getPlan() != null ? 1 : 0;
    }
}
