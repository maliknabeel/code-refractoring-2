package com.refactoring.examples.techniques.simplifyingconditionals.bad;

import com.refactoring.examples.techniques.simplifyingconditionals.*;
import com.refactoring.examples.techniques.simplifyingconditionals.RemoveControlFlagExample.*;

public class RemoveControlFlagExampleBadExample {
    private boolean alertSent = false;

    private void sendAlert() { alertSent = true; }

    public boolean checkSecurity(String[] people) {
        boolean found = false;
        for (String person : people) {
            if (!found) {
                if (person.equals("Don")  ) { sendAlert(); found = true; }
                if (person.equals("John") ) { sendAlert(); found = true; }
            }
        }
        return alertSent;
    }
}
