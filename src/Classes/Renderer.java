package Classes;

public interface Renderer {
    void renderIntro(int initialNumberOfRounds);
    void renderGameOver();
    void renderUserInputPrompt(int currentPlayCounter);
    void renderSecretCodeOutput(boolean shouldShowSecretCode, SecretCode secretCode);
    void renderGameWon();
    void renderGameLost();
    void renderStateOfBoard(Board board, ResultContainer resultContainer);
}
