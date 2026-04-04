package edu.pafiast.refractoring.techniques.organizingdata;

public class ReplaceArrayWithObjectExample {

    public static String getDescription() {
        return "Replace Array with Object: When you have an array in which certain elements mean " +
               "different things, replace the array with an object that has a field for each " +
               "element. Arrays should be used only for a collection of similar objects.";
    }

    public static String getBadCode() {
        return """
                // BAD: An array used to hold heterogeneous values — each index has a special meaning
                String[] row = new String[3];
                row[0] = "Liverpool";  // team name
                row[1] = "15";         // wins
                row[2] = "3";          // losses
                String teamName = row[0];
                int wins        = Integer.parseInt(row[1]);
                """;
    }

    public static String getGoodCode() {
        return """
                // GOOD: A proper object with named, typed fields
                class Performance {
                    private String teamName;
                    private int    wins;
                    private int    losses;

                    // getters, setters, behaviour...
                }

                Performance performance = new Performance("Liverpool", 15, 3);
                String teamName = performance.getTeamName();
                int    wins     = performance.getWins();
                """;
    }
}
