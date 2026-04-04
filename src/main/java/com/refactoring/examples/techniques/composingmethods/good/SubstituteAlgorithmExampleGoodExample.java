package com.refactoring.examples.techniques.composingmethods.good;

import java.util.List;
import java.util.ArrayList;
import com.refactoring.examples.techniques.composingmethods.*;
import com.refactoring.examples.techniques.composingmethods.SubstituteAlgorithmExample.*;

public class SubstituteAlgorithmExampleGoodExample {
    private static final List<String> CANDIDATES = List.of("Don", "John", "Kent");

    public String foundPerson(String[] people) {
        for (String person : people) {
            if (CANDIDATES.contains(person)) {
                return person;
            }
        }
        return "";
    }
}
