package Classes;

public class KeyboardInputValidator {

    private int guessLength;
    private ColourContainer colourContainer;

    public KeyboardInputValidator(int inGuessLength, ColourContainer inColourContainer) {
        guessLength = inGuessLength;
        colourContainer = inColourContainer;
    }

    public boolean validate(String input){
        StringBuilder sb = new StringBuilder(colourContainer.getAvailableColours().size());

        for(Colour colour : colourContainer.getAvailableColours()){
            sb.append(colour.getClass().getSimpleName());
        }

        String validCharacters = sb.toString();

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
