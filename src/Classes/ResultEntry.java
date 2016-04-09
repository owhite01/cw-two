package Classes;

import java.util.Vector;

public class ResultEntry {
    private Vector<ResultPeg> pegs;

    public ResultEntry() {
        pegs = new Vector<>();
    }

    public Vector<ResultPeg> getResultPegs() {

        return pegs;
    }
}
