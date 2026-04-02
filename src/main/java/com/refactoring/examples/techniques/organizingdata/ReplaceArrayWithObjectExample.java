package com.refactoring.examples.techniques.organizingdata;

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

    public static class BadExample {
        public String summarise(String[] row) {
            // Magic indices — what do 0, 1, 2 mean?
            String name   = row[0];
            int    wins   = Integer.parseInt(row[1]);
            int    losses = Integer.parseInt(row[2]);
            int    played = wins + losses;
            return name + ": " + wins + "W / " + losses + "L / " + played + " played";
        }
    }

    public static class GoodExample {
        public static class Performance {
            private final String teamName;
            private final int    wins;
            private final int    losses;

            public Performance(String teamName, int wins, int losses) {
                this.teamName = teamName;
                this.wins     = wins;
                this.losses   = losses;
            }

            public String getTeamName() { return teamName; }
            public int    getWins()     { return wins; }
            public int    getLosses()   { return losses; }
            public int    getPlayed()   { return wins + losses; }
        }

        public String summarise(Performance p) {
            return p.getTeamName() + ": " + p.getWins() + "W / " + p.getLosses()
                   + "L / " + p.getPlayed() + " played";
        }
    }
}
