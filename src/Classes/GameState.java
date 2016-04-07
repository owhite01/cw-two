package Classes;

public interface GameState {
    void init();
    void enter();
    void exit();
    void update();
    boolean isFinished();

}
