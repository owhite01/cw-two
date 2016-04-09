package Classes;

import java.util.Vector;

public class SecretCode {
    private Vector<Peg> pegs;
    private int pegCount;
    private ColourContainer colourContainer;

    public SecretCode(int inPegCount, ColourContainer inColourContainer) {
        pegs = new Vector<>();

        pegCount = inPegCount;
        colourContainer = inColourContainer;
        generateSecretCode();
    }

    public Vector<Peg> getPegs() {
        return pegs;
    }

    public void generateSecretCode(){
        pegs.clear();
        for (int i = 0; i < pegCount; i++) {
            pegs.add(new Peg(colourContainer.getRandomColour()));
        }
    }
}