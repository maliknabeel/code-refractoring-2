package com.refactoring.examples.techniques.simplifyingmethodcalls;

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

    public static class BadExample {
        private int height;
        private int width;

        public void setValue(String type, int amount) {
            if ("height".equals(type))      height = amount;
            else if ("width".equals(type))  width  = amount;
            else throw new IllegalArgumentException("Unknown type: " + type);
        }

        public int getHeight() { return height; }
        public int getWidth()  { return width; }
    }

    public static class GoodExample {
        private int height;
        private int width;

        public void setHeight(int height) { this.height = height; }
        public void setWidth(int width)   { this.width  = width; }

        public int getHeight() { return height; }
        public int getWidth()  { return width; }
    }
}
