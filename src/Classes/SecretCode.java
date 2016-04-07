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

        Random randomGenerator = new Random();
        for(int i = 0; i < pegCount; i++) {
            int chosenColor = randomGenerator.nextInt(6);

            switch (chosenColor) {
                case 0:
                {
                    pegs.add(new Peg(new Blue()));
                }
                break;
                case 1:
                {
                    pegs.add(new Peg(new Red()));
                }
                break;
                case 2:
                {
                    pegs.add(new Peg(new Green()));
                }
                break;
                case 3:
                {
                    pegs.add(new Peg(new Orange()));
                }
                break;
                case 4:
                {
                    pegs.add(new Peg(new Purple()));
                }
                break;
                case 5:
                {
                    pegs.add(new Peg(new Yellow()));
                }
                break;
            }
        }
    }
}