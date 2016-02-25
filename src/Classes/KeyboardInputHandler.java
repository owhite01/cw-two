package Classes;

public class KeyboardInputHandler implements InputHandler {

    private KeyboardInputValidator inputValidator;

    @Override
    public Guess queryGuess() {

        return new Guess(5);
    }
}
