package Classes;

public class PlayState implements GameState {

    private Renderer renderer;
    private InputHandler inputHandler;
    private Board board;
    private int initialPlayCounter;
    private int currentPlayCounter;
    private boolean stateActive;
    private boolean shouldShowSecretCode;
    private SecretCode secretCode;

    public PlayState(int numberOfRoundsInGame, InputHandler inInputHandler, Renderer outputRenderer, boolean showSecretCode, SecretCode inSecretCode) {
        renderer = outputRenderer;
        inputHandler = inInputHandler;

        board = new Board(Settings.CodeLength, Settings.NumberOfRounds, inSecretCode);
        initialPlayCounter = numberOfRoundsInGame;
        currentPlayCounter = numberOfRoundsInGame;
        shouldShowSecretCode = showSecretCode;
        secretCode = inSecretCode;
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

        if(shouldShowSecretCode) {
            for(Peg peg : secretCode.getPegs()) {
                System.out.print(peg.getColour().getClass().getSimpleName().charAt(0));
            }
            System.out.println(" Secret Code");
        }
        else {
            System.out.println(".... Secret Code");
        }

        renderer.renderBoard(board);
        System.out.println("");

        if(checkWinCondition()){
            System.out.println("You solved the puzzle! Good job.");
            stateActive = false;
        }

        currentPlayCounter--;

        if(currentPlayCounter == 0){
            System.out.println("You did not solve the puzzle. Too bad.");
            stateActive = false;
        }

    }

    @Override
    public boolean isFinished()
    {
        return !stateActive;
    }

    private boolean checkWinCondition() {
        Result latestResult = board.getResults().lastElement();

        if(latestResult.getResultPegs().size() < board.getWidth()){
            return false;
        }

        for(ResultPeg resultPeg: latestResult.getResultPegs()){
            if(!(resultPeg instanceof BlackResultPeg)){
                return false;
            }
        }

        return true;
    }
}
