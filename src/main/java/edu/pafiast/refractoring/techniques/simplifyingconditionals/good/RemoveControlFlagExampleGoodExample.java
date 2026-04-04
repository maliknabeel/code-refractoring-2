package edu.pafiast.refractoring.techniques.simplifyingconditionals.good;

import edu.pafiast.refractoring.techniques.simplifyingconditionals.*;
import edu.pafiast.refractoring.techniques.simplifyingconditionals.RemoveControlFlagExample.*;

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
