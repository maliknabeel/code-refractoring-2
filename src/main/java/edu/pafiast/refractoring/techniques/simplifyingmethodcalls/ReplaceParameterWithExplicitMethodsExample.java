package edu.pafiast.refractoring.techniques.simplifyingmethodcalls;

public class ReplaceParameterWithExplicitMethodsExample {

    public static String getDescription() {
        return "Replace Parameter with Explicit Methods: When you have a method that runs " +
               "different code depending on the values of an enumerated parameter, create a " +
               "separate method for each value of the parameter. This is the inverse of " +
               "Parameterize Method — use it when the branches are fundamentally different actions.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'type' parameter forces the caller to know magic string values
                void setValue(String type, int amount) {
                    if (type.equals("height")) height = amount;
                    else if (type.equals("width")) width = amount;
                    else throw new IllegalArgumentException("Unknown type: " + type);
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Explicit, type-safe methods replace the string-dispatched one
                void setHeight(int height) { this.height = height; }
                void setWidth(int width)   { this.width  = width; }
                """;
    }
}
