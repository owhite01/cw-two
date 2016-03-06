package Classes;

public class KeyboardInputValidator {

    private int guessLength;

    public KeyboardInputValidator(int inGuessLength) {
        guessLength = inGuessLength;

    }

    public boolean validate(String input){
        if(input.isEmpty()){
            return false;
        }
        if(guessLength<input.length()){
            return false;

        }
        return true;
    }

}
