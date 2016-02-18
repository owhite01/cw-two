package Classes;

public class GameImpl extends GameAbstractImpl {

    public GameImpl(boolean easy) {
        super(easy);
    }

    @Override
    public void runGames(){
        System.out.println("Welcome to Mastermind.");
    }
}
