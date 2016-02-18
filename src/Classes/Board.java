package Classes;

import java.util.Vector;

public class Board {

    private Vector<String> mySlots;
    private int width;
    private int height;

    public Board(int sizeX, int sizeY)
    {
        mySlots = new Vector<>(sizeX * sizeY);

        width = sizeX;
        height = sizeY;

        for(int verticalPosition = 0; verticalPosition < height; verticalPosition++)
        {
            for(int horizontalPosition = 0; horizontalPosition < width; horizontalPosition++) {
                mySlots.add(verticalPosition * width + horizontalPosition, ".");
            }
        }
    }

    public String getSlotValue(int posX, int posY)
    {
        return mySlots.elementAt(posY * width + posX);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
