package Classes;

import java.util.List;
import java.util.Random;

public class ColourContainer {

    private List<Colour> availableColours = null;

    // a setter method to set List
    public void setAvailableColours(List<Colour> inColours) {
        availableColours = inColours;
    }

    public Colour generateColour(char ch) {
        for(Colour colorToCheck : availableColours) {
            String colourName = colorToCheck.getClass().getSimpleName();
            if(colourName.startsWith(Character.toString(ch))){
               return colorToCheck;
            }
        }

        return null;
    }

    public Colour generateRandomColour(){
        Random randomGenerator = new Random();
        int chosenColor = randomGenerator.nextInt(availableColours.size());

        return (Colour)availableColours.toArray()[chosenColor];
    }
}
