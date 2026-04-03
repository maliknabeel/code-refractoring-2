package com.refactoring.examples.techniques.composingmethods;

public class SplitTemporaryVariableExample {

    public static String getDescription() {
        return "Split Temporary Variable: When you have a temporary variable assigned to more than " +
               "once but is not a loop variable or collecting temporary variable, make a separate " +
               "temporary variable for each assignment. Reusing a temp for different purposes is " +
               "confusing to the reader.";
    }

    public static String getBadCode() {
        return """
                // BAD: 'temp' is reused for two entirely different values - confusing!
                double calculateStats(double height, double weight) {
                    double temp = height * weight;       // used as area
                    System.out.println("Area: " + temp);
                    temp = (height + width) * 2;         // reused as perimeter - confusing!
                    System.out.println("Perimeter: " + temp);
                    return temp;
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Each variable has one purpose and a descriptive name
                double calculateStats(double height, double width) {
                    double area      = height * width;
                    System.out.println("Area: " + area);

                    double perimeter = (height + width) * 2;
                    System.out.println("Perimeter: " + perimeter);

                    return perimeter;
                }
                """;
    }

    public static class BadExample {
        public double[] computePhysics(double initialVelocity, double acceleration, double time) {
            double temp = initialVelocity * time;             // distance calculation
            double distance = temp + 0.5 * acceleration * time * time;
            temp = initialVelocity + acceleration * time;     // velocity - temp reused!
            double finalVelocity = temp;
            return new double[]{distance, finalVelocity};
        }
    }

    public static class GoodExample {
        public double[] computePhysics(double initialVelocity, double acceleration, double time) {
            double initialComponent = initialVelocity * time; // clear purpose
            double distance = initialComponent + 0.5 * acceleration * time * time;

            double finalVelocity = initialVelocity + acceleration * time; // separate variable
            return new double[]{distance, finalVelocity};
        }
    }
}
