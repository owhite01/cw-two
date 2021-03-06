package Classes;

import java.util.Vector;

public class Board {

    private Vector<Slot> slots;
    private SecretCode secretCode;
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

        reset();
    }

    public void reset() {

        nextAvailableSlot = 0;

        slots.clear();

        for (int verticalPosition = 0; verticalPosition < height; verticalPosition++) {
            for (int horizontalPosition = 0; horizontalPosition < width; horizontalPosition++) {
                slots.add(verticalPosition * width + horizontalPosition, new Slot());
            }
        }
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

    }
}
