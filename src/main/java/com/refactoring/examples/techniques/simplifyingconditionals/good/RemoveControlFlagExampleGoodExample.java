package com.refactoring.examples.techniques.simplifyingconditionals.good;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.RemoveControlFlagExample.*;

public class RemoveControlFlagExampleGoodExample {
    private boolean alertSent = false;

    private void sendAlert() { alertSent = true; }

    public boolean checkSecurity(String[] people) {
        for (String person : people) {
            if (person.equals("Don") || person.equals("John")) {
                sendAlert();
                return true; // explicit early return
            }
        }
        return false;
    }
}
