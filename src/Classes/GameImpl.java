package Classes;

import java.util.ArrayList;
import java.util.List;

public class GameImpl extends GameAbstractImpl {

    private Renderer renderer;
    private InputHandler inputHandler;

    private int currentState;
    private List<GameState>  gameStates;

    public GameImpl(boolean easy) {
       super(easy);

        renderer = new TextRenderer();
        inputHandler = new KeyboardInputHandler();

        gameStates = new ArrayList<>();

        IntroState introState = new IntroState();
        introState.init();
        gameStates.add(introState);

        PlayState playState = new PlayState(inputHandler, renderer);
        playState.init();
        gameStates.add(playState);
    }

    @Override
    public void runGames(){

        //main game loop will happen here.
        gameStates.get(currentState).update();
        gameStates.get(currentState).render();

        currentState++;
        //TODO this will be turned into a loop rather than executing each state explicitly in order.
        gameStates.get(currentState).update();
        gameStates.get(currentState).render();
    }
}
