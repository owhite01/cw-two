package Classes;

import java.util.ArrayList;
import java.util.List;

public class GameImpl extends GameAbstractImpl {

    private Renderer renderer;
    private Board board;

    private int currentState;
    private List<GameState>  gameStates;

    public GameImpl(boolean easy) {
       super(easy);

        renderer = new TextRenderer();
        board = new Board(4,12);

        gameStates = new ArrayList<>();

        IntroState introState = new IntroState();
        introState.init();
        gameStates.add(introState);
    }

    @Override
    public void runGames(){

        //main game loop will happen here.
        gameStates.get(currentState).update();
        gameStates.get(currentState).render();

        Blue newBlue = new Blue();
        Peg bluePeg = new Peg(newBlue);
        board.addPeg(bluePeg, 0, 0);
        renderer.renderBoard(board);
    }
}
