package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Guess {
    private Vector<Peg> pegList;

    public Guess(Vector<Peg> pegs) {
        pegList = pegs;

    }

    public Vector<Peg> getPegs() {
        return pegList;
    }
}
