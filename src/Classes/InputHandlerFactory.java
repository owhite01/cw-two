package Classes;

public final class InputHandlerFactory {
    public static InputHandler generateInputHandler(int guessLength) {
        return new KeyboardInputHandler(new KeyboardInputValidator(guessLength));
    }
}
