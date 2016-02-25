package Classes;

public class KeyboardInputHandler implements InputHandler {

    @Override
    public Guess queryGuess() {

        return new Guess(5);
    }
}
