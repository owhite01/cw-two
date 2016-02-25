package Classes;

public class PlayState implements GameState {

    private Renderer renderer;
    private InputHandler inputHandler;
    private Board board;

    public PlayState(InputHandler inInputHandler, Renderer outputRenderer) {
        renderer = outputRenderer;
        inputHandler = inInputHandler;

        board = new Board(4,12);
    }

    @Override
    public void init() {
        Blue newBlue = new Blue();
        Peg bluePeg = new Peg(newBlue);
        board.addPeg(bluePeg, 0, 0);
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        renderer.renderBoard(board);
    }
}
