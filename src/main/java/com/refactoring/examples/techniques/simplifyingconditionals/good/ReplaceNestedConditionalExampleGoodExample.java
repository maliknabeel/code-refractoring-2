package com.refactoring.examples.techniques.simplifyingconditionals.good;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.ReplaceNestedConditionalExample.*;

public class ReplaceNestedConditionalExampleGoodExample {
    private double deadAmount()     { return 0; }
    private double separatedAmount(){ return 500; }
    private double retiredAmount()  { return 1000; }
    private double normalPayAmount(){ return 3000; }

    public double getPayAmount(Employee e) {
        if (e.isDead)      return deadAmount();
        if (e.isSeparated) return separatedAmount();
        if (e.isRetired)   return retiredAmount();
        return normalPayAmount();
    }
}
