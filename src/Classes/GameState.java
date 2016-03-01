package Classes;

public interface GameState {
    void init();
    void update();
    void render();
    boolean isFinished();

}
