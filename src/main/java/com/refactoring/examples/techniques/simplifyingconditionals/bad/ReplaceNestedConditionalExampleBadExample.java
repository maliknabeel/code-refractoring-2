package com.refactoring.examples.techniques.simplifyingconditionals.bad;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ReplaceNestedConditionalExample.*;

public class ReplaceNestedConditionalExampleBadExample {
    private double deadAmount()     { return 0; }
    private double separatedAmount(){ return 500; }
    private double retiredAmount()  { return 1000; }
    private double normalPayAmount(){ return 3000; }

    public double getPayAmount(Employee e) {
        double result;
        if (e.isDead) {
            result = deadAmount();
        } else {
            if (e.isSeparated) {
                result = separatedAmount();
            } else {
                if (e.isRetired) {
                    result = retiredAmount();
                } else {
                    result = normalPayAmount();
                }
            }
        }
        return result;
    }
}
