package Classes;

public interface GameState {
    void init();
    void enter();
    void exit();
    void update();
    void render();
    boolean isFinished();

}
