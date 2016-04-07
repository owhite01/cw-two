package Classes;

import java.util.Random;

public class ColourFactory {

    public static Colour generateColour(char ch) {
        switch(ch){
            case 'B':{
                return new Blue();
            }
            case 'G':{
                return new Green();
            }
            case 'O':{
                return new Orange();
            }
            case 'P':{
                return new Purple();
            }
            case 'R': {
                return new Red();
            }
            case 'Y':{
                return new Yellow();
            }
        }

        return null;
    }

    public static Colour generateRandomColour(){
        Random randomGenerator = new Random();

        int chosenColor = randomGenerator.nextInt(6);

        switch (chosenColor) {
            case 0:
            {
                return new Blue();
            }
            case 1:
            {
                return new Red();
            }
            case 2:
            {
                return new Green();
            }
            case 3:
            {
                return new Orange();
            }
            case 4:
            {
               return new Purple();
            }
            case 5:
            {
                return new Yellow();
            }
        }

        return null;
    }
}
