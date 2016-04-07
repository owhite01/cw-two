package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class SecretCode {
    private Vector<Peg> pegs;
    private int pegCount;

    public SecretCode(int inPegCount) {
        pegs = new Vector<>();

        pegCount = inPegCount;
        generateSecretCode();
    }


    public Vector<Peg> getPegs() {
        return pegs;

    }

    public void generateSecretCode(){
        pegs.clear();

        ColourFactory colourFactory = new ColourFactory();
        for(int i = 0; i < pegCount; i++) {
            pegs.add(new Peg(colourFactory.generateRandomColour()));
        }
    }
}