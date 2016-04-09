package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Observable;

public class GameImpl extends GameAbstractImpl implements Observer {

    private Renderer renderer = null;
    private InputHandler inputHandler = null;
    private SecretCode secretCode = null;
    private int numberOfRounds;

    private int currentState;
    private List<GameState>  gameStates;

    private boolean shouldQuit;

    public GameImpl(boolean easy, Renderer inRenderer, InputHandler inInputHandler, SecretCode inSecretCode) {
       super(easy);

        renderer = inRenderer;
        inputHandler = inInputHandler;
        secretCode = inSecretCode;

        numberOfRounds = Settings.NumberOfRounds;

        gameStates = new ArrayList<>();

        IntroState introState = new IntroState(numberOfRounds, secretCode);
        introState.init();
        gameStates.add(introState);

        PlayState playState = new PlayState(numberOfRounds, inputHandler, renderer, ShouldShowCode(), secretCode);
        playState.init();
        gameStates.add(playState);

        GameOverState gameOverState = new GameOverState();
        gameOverState.init();
        gameOverState.addObserver(this);
        gameStates.add(gameOverState);

        shouldQuit = false;

    }

    @Override
    public void runGames(){

        //init the initial state.
        gameStates.get(currentState).enter();

        while(!shouldQuit) {
            gameStates.get(currentState).update();

            if(gameStates.get(currentState).isFinished()) {

                gameStates.get(currentState).exit();

                currentState++;
                if(currentState > gameStates.size()) {
                    currentState = 0;
                }

                gameStates.get(currentState).enter();
            }
        }
    }

    @Override
    public void update(Observable obs, Object obj)
    {
        if (obs == gameStates.get(currentState))
        {
            shouldQuit = true;
        }
    }
}
