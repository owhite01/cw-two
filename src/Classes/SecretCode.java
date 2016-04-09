package Classes;

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

        try {
            ColourContainer factory = (ColourContainer)MastermindDriver.getBeanFactory().getBean("colourContainer");
            for (int i = 0; i < pegCount; i++) {
                pegs.add(new Peg(factory.generateRandomColour()));
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}