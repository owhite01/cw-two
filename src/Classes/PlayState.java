package Classes;

public class PlayState implements GameState {

    private Renderer renderer;
    private InputHandler inputHandler;
    private Board board;
    private int initialPlayCounter;
    private int currentPlayCounter;

    public PlayState(int numberOfRoundsInGame, InputHandler inInputHandler, Renderer outputRenderer) {
        renderer = outputRenderer;
        inputHandler = inInputHandler;

        board = new Board(4,12);
        initialPlayCounter = numberOfRoundsInGame;
        currentPlayCounter = numberOfRoundsInGame;
    }

    @Override
    public void init() {
        Blue newBlue = new Blue();
        Peg bluePeg = new Peg(newBlue);
        board.addPeg(bluePeg, 0, 0);
    }

    @Override
    public void enter() {
        currentPlayCounter = initialPlayCounter;
    }

    @Override
    public void exit() {

    }

    @Override
    public void update() {
        currentPlayCounter--;
    }

    @Override
    public void render() {
        renderer.renderBoard(board);
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }
}
