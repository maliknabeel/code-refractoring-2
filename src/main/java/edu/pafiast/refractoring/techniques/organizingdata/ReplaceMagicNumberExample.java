package edu.pafiast.refractoring.techniques.organizingdata;

public class ReplaceMagicNumberExample {

    public static String getDescription() {
        return "Replace Magic Number with Symbolic Constant: When you have a literal number with " +
               "a special meaning, create a constant, name it after the meaning, and replace the " +
               "number with it. Magic numbers make code mysterious and are hard to change " +
               "consistently.";
    }

    public static String getBadCode() {
        return """
                // BAD: Magic numbers everywhere — what do 9.81, 3600, 12 mean?
                double potentialEnergy(double mass, double height) {
                    return mass * 9.81 * height;  // What is 9.81?
                }

                double hoursToSeconds(int hours) {
                    return hours * 3600;           // Why 3600?
                }

                double annualToMonthly(double annual) {
                    return annual / 12;            // Why 12?
                }
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: Constants make the code self-documenting
                static final double GRAVITATIONAL_CONSTANT   = 9.81;  // m/s²
                static final int    SECONDS_PER_HOUR         = 3600;
                static final int    MONTHS_PER_YEAR          = 12;

                double potentialEnergy(double mass, double height) {
                    return mass * GRAVITATIONAL_CONSTANT * height;
                }

                double hoursToSeconds(int hours) {
                    return hours * SECONDS_PER_HOUR;
                }

                double annualToMonthly(double annual) {
                    return annual / MONTHS_PER_YEAR;
                }
                """;
    }
}
