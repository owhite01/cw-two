package Classes;

public class PlayerInputState implements GameState {

    private InputHandler inputHandler;

    public PlayerInputState(InputHandler inInputHandler) {
        inputHandler = inInputHandler;
    }

    @Override
    public void init() {

    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void update() {
        System.out.println("What is your next guess?\n" +
                "Type in the characters for your guess and press enter.");
        System.out.print("Enter guess:");
        inputHandler.queryGuess();
    }

    @Override
    public void render() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
