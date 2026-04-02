package com.refactoring.examples.techniques.composingmethods;

import java.util.List;
import java.util.ArrayList;

public class SubstituteAlgorithmExample {

    public static String getDescription() {
        return "Substitute Algorithm: When you want to replace an existing algorithm with a new one, " +
               "replace the body of the method implementing the algorithm with the new one. Sometimes " +
               "you find a cleaner way to do something, or a library provides functionality that " +
               "replaces your hand-rolled code.";
    }

    public static String getBadCode() {
        return """
                // BAD: Manual loop to find a name in a list - verbose and error-prone
                String findPerson(String[] people) {
                    for (String person : people) {
                        if (person.equals("Don")) return "Don";
                        if (person.equals("John")) return "John";
                        if (person.equals("Kent")) return "Kent";
                    }
                    return "";
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Use a Set and Java streams for clarity and performance
                String findPerson(String[] people) {
                    List<String> candidates = List.of("Don", "John", "Kent");
                    return Arrays.stream(people)
                                 .filter(candidates::contains)
                                 .findFirst()
                                 .orElse("");
                }
                """;
    }

    public static class BadExample {
        public String foundPerson(String[] people) {
            for (String person : people) {
                if (person.equals("Don"))  return "Don";
                if (person.equals("John")) return "John";
                if (person.equals("Kent")) return "Kent";
            }
            return "";
        }
    }

    public static class GoodExample {
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
}
