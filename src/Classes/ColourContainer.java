package Classes;

import java.util.List;
import java.util.Random;

public class ColourContainer {

    private List<Colour> availableColours = null;

    public void setAvailableColours(List<Colour> inColours) {
        availableColours = inColours;
    }

    public List<Colour> getAvailableColours() {
        return availableColours;
    }

    public Colour getColour(char ch) {
        for(Colour colorToCheck : availableColours) {
            String colourName = colorToCheck.getClass().getSimpleName();
            if(colourName.startsWith(Character.toString(ch))){
               return colorToCheck;
            }
        }

        return null;
    }

    public Colour getRandomColour(){
        Random randomGenerator = new Random();
        int chosenColor = randomGenerator.nextInt(availableColours.size());

        return (Colour)availableColours.toArray()[chosenColor];
    }
}
