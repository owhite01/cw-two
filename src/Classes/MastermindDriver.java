package Classes;

public class MastermindDriver {
    // Example - change as you need to...
    public static void main(String[] args) {
        Game g = Factory.getInstance(Game.class, false);
        g.runGames();

        //g = Factory.getInstance(Game.class, false);
        //g.runGames();
    }
}
