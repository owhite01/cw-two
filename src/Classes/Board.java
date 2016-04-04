package Classes;

import java.util.Arrays;
import java.util.Vector;

public class Board {

    private Vector<Slot> slots;
    private SecretCode secretCode;
    private Vector<Result> results;
    private int width;
    private int height;
    private int nextAvailableSlot;

    public Board(int sizeX, int sizeY, SecretCode inSecretCode) {
        secretCode = inSecretCode;

        if (sizeX <= 0 || sizeY <= 0) {
            throw new IllegalArgumentException();
        }

        slots = new Vector<>(sizeX * sizeY);

        width = sizeX;
        height = sizeY;
        nextAvailableSlot = 0;

        for (int verticalPosition = 0; verticalPosition < height; verticalPosition++) {
            for (int horizontalPosition = 0; horizontalPosition < width; horizontalPosition++) {
                slots.add(verticalPosition * width + horizontalPosition, new Slot());
            }
        }

        results = new Vector<>(sizeY);
    }

    public Slot getSlotValue(int posX, int posY) {
        return slots.elementAt(posY * width + posX);
    }

    private void addPeg(Peg peg, int posX, int posY) {
        slots.elementAt(posY * width + posX).setPeg(peg);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void assignGuessToSlots(Guess guess) {
        if(guess.getPegs().size() > width){
            throw new IllegalArgumentException("Guess is too big for the board!");
        }

        for(Peg peg: guess.getPegs()){
            addPeg(peg, nextAvailableSlot%width, nextAvailableSlot/width);
            nextAvailableSlot++;
        }

        Result newResult = new Result();

        int whitePegCount = 0;
        int blackPegCount = 0;

        Boolean[] verifiedSlots = new Boolean[guess.getPegs().size()];
        Arrays.fill(verifiedSlots, false);

        //first check for black pegs
        for(int pegIndex = 0; pegIndex < guess.getPegs().size(); pegIndex++) {
            Peg secretCodePeg = secretCode.getPegs().elementAt(pegIndex);
            Peg guessPeg = guess.getPegs().elementAt(pegIndex);

            //Check if current peg is black
            if(secretCodePeg.getColour().getClass().equals(guessPeg.getColour().getClass())){
                blackPegCount++;
                verifiedSlots[pegIndex] = true;
            }
        }

        for(int pegIndex = 0; pegIndex < guess.getPegs().size(); pegIndex++){
            Peg guessPeg = guess.getPegs().elementAt(pegIndex);

            for(int whitePegCheckIndex = 0; whitePegCheckIndex < guess.getPegs().size(); whitePegCheckIndex++) {
                if (whitePegCheckIndex != pegIndex) {
                    Peg whiteCheckPeg = secretCode.getPegs().elementAt(whitePegCheckIndex);
                    if (whiteCheckPeg.getColour().getClass().equals(guessPeg.getColour().getClass())) {
                         if (!verifiedSlots[whitePegCheckIndex]) {
                             whitePegCount++;
                             verifiedSlots[whitePegCheckIndex] = true;
                             break;
                         }
                    }
                }
            }
        }

        for(int blackPegCountIndex = 0; blackPegCountIndex < blackPegCount; blackPegCountIndex++){
            newResult.getPegs().add(new BlackResultPeg());
        }

        for(int whitePegCountIndex = 0; whitePegCountIndex < whitePegCount; whitePegCountIndex++){
            newResult.getPegs().add(new WhiteResultPeg());
        }

        results.add(newResult);
    }

    public Vector<Result> getResults() {
        return results;
    }
}
