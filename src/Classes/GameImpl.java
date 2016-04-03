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

        renderer = new TextRenderer();
        //TODO create a keyboard inptut validator factory
        //TODO data drives the validator input
        inputHandler = new KeyboardInputHandler(new KeyboardInputValidator(4));
        //TODO data drives the number of rounds
        numberOfRounds = 12;
        gameStates = new ArrayList<>();
        //TODO data drives the length of the secret code
        secretCode = new SecretCode(4);

        IntroState introState = new IntroState(numberOfRounds, secretCode);
        introState.init();
        gameStates.add(introState);

        PlayState playState = new PlayState(numberOfRounds, inputHandler, renderer);
        playState.init();
        gameStates.add(playState);

        PlayerInputState playerInputState = new PlayerInputState(inputHandler);
        playerInputState.init();
        gameStates.add(playerInputState);
    }

    @Override
    public void runGames(){

        //init the initial state.
        gameStates.get(currentState).enter();

        while(true) {
            gameStates.get(currentState).update();
            gameStates.get(currentState).render();

            if(gameStates.get(currentState).isFinished()) {

                gameStates.get(currentState).exit();

                currentState++;
                if(currentState > 2) {
                    currentState = 0;
                }

                gameStates.get(currentState).enter();
            }
        }
    }
}
