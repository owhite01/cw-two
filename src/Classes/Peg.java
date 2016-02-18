package Classes;

public class Peg {

    private Colour colour;

    public Peg(Colour colour) {
        this.colour = colour;
    }

    public enum Colour {
        BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW
    }

    public Colour getColour() {
        return colour;
    }


}
