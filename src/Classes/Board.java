package Classes;

import java.util.Vector;

public class Board {

    private Vector<Slot> slots;
    private int width;
    private int height;

    public Board(int sizeX, int sizeY) {
        if(sizeX <= 0 || sizeY <= 0) {
            throw new IllegalArgumentException();
        }

        slots = new Vector<>(sizeX * sizeY);

        width = sizeX;
        height = sizeY;

        for(int verticalPosition = 0; verticalPosition < height; verticalPosition++) {
            for(int horizontalPosition = 0; horizontalPosition < width; horizontalPosition++) {
                slots.add(verticalPosition * width + horizontalPosition, new Slot());
            }
        }
    }

    public Slot getSlotValue(int posX, int posY) {
        return slots.elementAt(posY * width + posX);
    }

    public void addPeg(Peg peg, int posX, int posY) {
        slots.elementAt(posY * width + posX).setPeg(peg);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void processGuess(Guess guess) {

    }
}
