package Classes;

public class PlayState implements GameState {

    private Renderer renderer;
    private InputHandler inputHandler;
    private Board board;
    private int initialPlayCounter;
    private int currentPlayCounter;
    private boolean stateActive;

    public PlayState(int numberOfRoundsInGame, InputHandler inInputHandler, Renderer outputRenderer) {
        renderer = outputRenderer;
        inputHandler = inInputHandler;

        board = new Board(4,12);
        initialPlayCounter = numberOfRoundsInGame;
        currentPlayCounter = numberOfRoundsInGame;
    }

    @Override
    public void init() {
    }

    @Override
    public void enter() {
        currentPlayCounter = initialPlayCounter;
        stateActive = true;
    }

    @Override
    public void exit() {

    }

    @Override
    public void update() {
        System.out.println("You have " + currentPlayCounter + " guesses left");
        System.out.println("");
        System.out.println("What is your next guess?\n" +
                "Type in the characters for your guess and press enter.");
        Guess userGuess = inputHandler.queryGuess();
        board.assignGuessToSlots(userGuess);
        renderer.renderBoard(board);
        System.out.println("");
        currentPlayCounter--;

        if(currentPlayCounter == 0){
            System.out.println("You did not solve the puzzle. Too bad.");
            stateActive = false;
        }

    }

    @Override
    public void render() {
    }

    @Override
    public boolean isFinished()
    {
        return !stateActive;
    }
}
