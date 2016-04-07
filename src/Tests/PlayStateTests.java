package Tests;

import Classes.*;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Vector;

import static org.junit.Assert.*;


public class PlayStateTests {

    @Test
    public void playStateCheckWinConditionIfPlayerHasWon() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(4,4, secretCode);
        secretCode.generateSecretCode();
        Vector<Peg> pegList = new Vector<>(4);

        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Yellow()));

        Guess testGuess = new Guess(pegList);

        secretCode.getPegs().clear();
        secretCode.getPegs().add(new Peg(new Yellow()));
        secretCode.getPegs().add(new Peg(new Yellow()));
        secretCode.getPegs().add(new Peg(new Yellow()));
        secretCode.getPegs().add(new Peg(new Yellow()));

        newBoard.assignGuessToSlots(testGuess);

        PlayState d = new PlayState(12, null, null, false, null);
        Method m = PlayState.class.getDeclaredMethod("checkWinCondition");
        m.setAccessible(true);
        boolean result = (boolean) m.invoke(d);
        assertTrue(result);




    }
}
