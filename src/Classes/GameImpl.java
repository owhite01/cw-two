package Classes;

import java.util.ArrayList;
import java.util.List;

public class GameImpl extends GameAbstractImpl {

    private Renderer renderer;
    private InputHandler inputHandler;
    private int numberOfRounds;
    private SecretCode secretCode;

    private int currentState;
    private List<GameState>  gameStates;

    public GameImpl(boolean easy) {
       super(easy);

        renderer = RendererFactory.generateRenderer();
        inputHandler = InputHandlerFactory.generateInputHandler(Settings.CodeLength);
        numberOfRounds = Settings.NumberOfRounds;

        gameStates = new ArrayList<>();
        //TODO data drives the length of the secret code
        secretCode = new SecretCode(Settings.CodeLength);

        IntroState introState = new IntroState(numberOfRounds, secretCode);
        introState.init();
        gameStates.add(introState);

        PlayState playState = new PlayState(numberOfRounds, inputHandler, renderer, ShouldShowCode(), secretCode);
        playState.init();
        gameStates.add(playState);

        GameOverState gameOverState = new GameOverState();
        gameOverState.init();
        gameStates.add(gameOverState);

    }

    @Override
    public void runGames(){

        //init the initial state.
        gameStates.get(currentState).enter();

        //TODO make this loop quit if the user chooses to end the game.
        while(true) {
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
}
