package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class KeyboardInputHandler implements InputHandler {

    private KeyboardInputValidator inputValidator;

    public KeyboardInputHandler(KeyboardInputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public Guess queryGuess() {
        String userInput = "";
        try {
            boolean validInput = false;
            while(!validInput){
                System.out.print("Enter guess:");
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                userInput = bufferRead.readLine();
                if(inputValidator.validate(userInput)){
                    validInput = true;
                }
                else{
                    System.out.println("Invalid input!");
                }
            }

        }
        catch (IOException e) {
            System.out.println(e.toString());
        }

        System.out.println("");
        return generateGuessFromString(userInput);
    }

    public Guess generateGuessFromString(String input){
        Vector<Peg> pegList = new Vector<>();

        for(char ch: input.toCharArray()){
            pegList.add(new Peg(ColourFactory.generateColour(ch)));
        }

        return new Guess(pegList);
    }
}
