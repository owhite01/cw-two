package Classes;

public class PlayState implements GameState {

    private Renderer renderer;
    private InputHandler inputHandler;
    private Board board;
    private ResultContainer resultContainer;
    private int initialPlayCounter;
    private int currentPlayCounter;
    private boolean stateActive;
    private boolean shouldShowSecretCode;
    private SecretCode secretCode;

    public PlayState(int numberOfRoundsInGame, InputHandler inInputHandler, Renderer outputRenderer, boolean showSecretCode, SecretCode inSecretCode) {
        renderer = outputRenderer;
        inputHandler = inInputHandler;
        secretCode = inSecretCode;

        board = new Board(Settings.CodeLength, Settings.NumberOfRounds, inSecretCode);
        resultContainer = new ResultContainer(secretCode);

        initialPlayCounter = numberOfRoundsInGame;
        currentPlayCounter = numberOfRoundsInGame;
        shouldShowSecretCode = showSecretCode;
    }

    @Override
    public void init() {
    }

    @Override
    public void enter() {
        currentPlayCounter = initialPlayCounter;
        stateActive = true;
        board.reset();
        resultContainer.reset();
    }

    @Override
    public void exit() {

    }

    @Override
    public void update() {
        renderer.renderUserInputPrompt(currentPlayCounter);

        Guess userGuess = inputHandler.queryGuess();
        board.assignGuessToSlots(userGuess);
        resultContainer.generateResultEntryFromGuess(userGuess);

        renderer.renderSecretCodeOutput(shouldShowSecretCode, secretCode);

        renderer.renderStateOfBoard(board, resultContainer);
        System.out.println("");

        if(checkWinCondition()){
            renderer.renderGameWon();
            stateActive = false;
        }

        currentPlayCounter--;

        if(currentPlayCounter == 0){
            renderer.renderGameLost();
            stateActive = false;
        }

    }

    @Override
    public boolean isFinished()
    {
        return !stateActive;
    }

    private boolean checkWinCondition() {
        ResultEntry latestResultEntry = resultContainer.getResultEntries().lastElement();

        if(latestResultEntry.getResultPegs().size() < board.getWidth()){
            return false;
        }

        for(ResultPeg resultPeg: latestResultEntry.getResultPegs()){
            if(!(resultPeg instanceof BlackResultPeg)){
                return false;
            }
        }

        return true;
    }
}
