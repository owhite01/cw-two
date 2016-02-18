package Classes;

import java.util.Vector;

public class Board {

    private Vector<String> slots;
    private int width;
    private int height;

    public Board(int sizeX, int sizeY)
    {
        slots = new Vector<>(sizeX * sizeY);

        width = sizeX;
        height = sizeY;

        for(int verticalPosition = 0; verticalPosition < height; verticalPosition++)
        {
            for(int horizontalPosition = 0; horizontalPosition < width; horizontalPosition++) {
                slots.add(verticalPosition * width + horizontalPosition, ".");
            }
        }
    }

    public String getSlotValue(int posX, int posY)
    {
        return slots.elementAt(posY * width + posX);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
