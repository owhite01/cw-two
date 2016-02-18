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
    }

    public String getSlotValue(int posX, int posY)
    {
        return mySlots.elementAt(posY * width + posX);
    }

}
