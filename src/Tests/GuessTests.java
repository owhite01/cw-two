package Tests;
import Classes.Blue;
import Classes.Guess;
import Classes.Peg;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class GuessTests {
    @Test
    public void guessOnlyContainsTheExpectedNumberOfPegs(){
        List<Peg> pegList = new ArrayList<>(4);
        for(int i = 0; i<4; i++){
            pegList.add(new Peg(new Blue()));
        }
        Guess testGuess = new Guess(pegList);
        assertEquals(4, testGuess.getPegs().size());
    }
}
