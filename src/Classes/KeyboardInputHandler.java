package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KeyboardInputHandler implements InputHandler {
    //TODO add mock for the bufferreader to enable testing
    //TODO create a guess factory taking a string
    //TODO replace systemout with observer pattern for the renderer

    private KeyboardInputValidator inputValidator;

    public KeyboardInputHandler(KeyboardInputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public Guess queryGuess() {
        try {
            boolean validInput = false;
            String s = "";
            while(validInput == false){
                System.out.print("Enter guess:");
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                s = bufferRead.readLine();
                if(inputValidator.validate(s) == true){
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


        return generateGuessFromString();
    }

    private Guess generateGuessFromString(){
        return new Guess(new ArrayList<>());

    }
}
