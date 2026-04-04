package edu.pafiast.refractoring.techniques.composingmethods.good;

import java.util.List;
import java.util.ArrayList;
import edu.pafiast.refractoring.techniques.composingmethods.*;
import edu.pafiast.refractoring.techniques.composingmethods.SubstituteAlgorithmExample.*;

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
