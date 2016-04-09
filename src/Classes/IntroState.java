package Classes;

public class IntroState implements GameState {

    private Renderer renderer;
    private int initialNumberOfRounds;
    private SecretCode secretCode;
    private boolean isActive;

    public IntroState(Renderer renderer, int numberOfGuesses, SecretCode code) {
        this.renderer = renderer;
        initialNumberOfRounds = numberOfGuesses;
        secretCode = code;
        isActive = false;
    }

    @Override
    public void init() {

    }

    @Override
    public void enter() {
        isActive = true;
    }

    @Override
    public void exit() {
        isActive = false;
    }

    @Override
    public void update() {
        renderer.renderIntro(initialNumberOfRounds);
        secretCode.generateSecretCode();
        isActive = false;
    }

    @Override
    public boolean isFinished() {
        return !isActive;
    }
}
