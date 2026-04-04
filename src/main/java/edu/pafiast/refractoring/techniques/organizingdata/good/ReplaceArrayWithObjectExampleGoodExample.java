package edu.pafiast.refractoring.techniques.organizingdata.good;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceArrayWithObjectExample.*;

public class ReplaceArrayWithObjectExampleGoodExample {
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
