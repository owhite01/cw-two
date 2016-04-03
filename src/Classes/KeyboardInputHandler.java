package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        String userInput = "";
        try {
            boolean validInput = false;
            while(validInput == false){
                System.out.print("Enter guess:");
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                userInput = bufferRead.readLine();
                if(inputValidator.validate(userInput) == true){
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

    //TODO make this private and use reflection to validate this
    public Guess generateGuessFromString(String input){
        List<Peg> pegList = new ArrayList<>();
        //TODO change this to use colour factory
        for(char ch: input.toCharArray()){
            switch(ch){
                case 'B':{
                    pegList.add(new Peg(new Blue()));
                }
                break;

                case 'G':{
                    pegList.add(new Peg(new Green()));
                }
                break;

                case 'O':{
                    pegList.add(new Peg(new Orange()));
                }
                break;

                case 'P':{
                    pegList.add(new Peg(new Purple()));
                }
                break;

                case 'R':{
                    pegList.add(new Peg(new Red()));
                }
                break;

                case 'Y':{
                    pegList.add(new Peg(new Yellow()));
                }
                break;
            }
        }

        return new Guess(pegList);

    }
}
