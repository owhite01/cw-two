package Classes;

public class KeyboardInputValidator {

    private int guessLength;

    public KeyboardInputValidator(int inGuessLength) {
        guessLength = inGuessLength;

    }

    public boolean validate(String input){
        //TODO this should be data driven
        //TODO should allow users to enter lower case
        String validCharacters = "BGOPRY";

        if(input.isEmpty()){
            return false;
        }
        if(guessLength<input.length()){
            return false;

        }
        if(guessLength>input.length()){
            return false;
        }

        for (char ch: input.toCharArray()) {
            if(validCharacters.indexOf(ch) == -1){
                return false;

            }
        }



        return true;
    }

}
