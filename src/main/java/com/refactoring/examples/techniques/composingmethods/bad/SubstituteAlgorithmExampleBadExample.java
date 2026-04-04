package com.refactoring.examples.techniques.composingmethods.bad;

import java.util.List;
import java.util.ArrayList;
import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.SubstituteAlgorithmExample.*;

public class SubstituteAlgorithmExampleBadExample {
    public String foundPerson(String[] people) {
        for (String person : people) {
            if (person.equals("Don"))  return "Don";
            if (person.equals("John")) return "John";
            if (person.equals("Kent")) return "Kent";
        }
        return "";
    }
}
