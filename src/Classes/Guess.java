package Classes;

import java.util.ArrayList;
import java.util.List;

public class Guess {
    private List<Peg> pegList;

    public Guess(List<Peg> pegs) {
        pegList = pegs;

    }

    public List<Peg> getPegs() {
        return pegList;
    }
}
