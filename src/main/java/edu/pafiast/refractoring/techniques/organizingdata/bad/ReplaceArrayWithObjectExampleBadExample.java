package edu.pafiast.refractoring.techniques.organizingdata.bad;

import edu.pafiast.refractoring.techniques.organizingdata.*;
import edu.pafiast.refractoring.techniques.organizingdata.ReplaceArrayWithObjectExample.*;

public class ReplaceArrayWithObjectExampleBadExample {
    public String summarise(String[] row) {
        // Magic indices — what do 0, 1, 2 mean?
        String name   = row[0];
        int    wins   = Integer.parseInt(row[1]);
        int    losses = Integer.parseInt(row[2]);
        int    played = wins + losses;
        return name + ": " + wins + "W / " + losses + "L / " + played + " played";
    }
}
