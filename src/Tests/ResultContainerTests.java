package Tests;

import Classes.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResultContainerTests {

    @Test
    public void testBlackPegIsCreatedAsExpected(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        SecretCode secretCode = new SecretCode(4, colourContainer);
        ResultContainer resultContainer = new ResultContainer(secretCode);
        secretCode.generateSecretCode();
        Vector<Peg> pegList = new Vector<>(4);
        for(int i = 0; i<4; i++){
            pegList.add(new Peg(new Blue()));
        }
        Guess testGuess = new Guess(pegList);

        secretCode.getPegs().clear();
        secretCode.getPegs().add(new Peg(new Blue()));
        secretCode.getPegs().add(new Peg(new Red()));
        secretCode.getPegs().add(new Peg(new Yellow()));
        secretCode.getPegs().add(new Peg(new Purple()));

        resultContainer.generateResultEntryFromGuess(testGuess);
        Vector<ResultPeg> resultPegs = resultContainer.getResultEntries().elementAt(0).getResultPegs();
        assertEquals(1, resultPegs.size());
        assertTrue(resultPegs.elementAt(0) instanceof BlackResultPeg);
    }

    @Test
    public void testWhitePegIsCreatedAsExpected(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        SecretCode secretCode = new SecretCode(4, colourContainer);
        ResultContainer resultContainer = new ResultContainer(secretCode);
        secretCode.generateSecretCode();
        Vector<Peg> pegList = new Vector<>(4);

        pegList.add(new Peg(new Blue()));
        pegList.add(new Peg(new Green()));
        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Blue()));

        Guess testGuess = new Guess(pegList);


        secretCode.getPegs().clear();
        secretCode.getPegs().add(new Peg(new Orange()));
        secretCode.getPegs().add(new Peg(new Blue()));
        secretCode.getPegs().add(new Peg(new Red()));
        secretCode.getPegs().add(new Peg(new Purple()));

        resultContainer.generateResultEntryFromGuess(testGuess);
        Vector<ResultPeg> resultPegs = resultContainer.getResultEntries().elementAt(0).getResultPegs();
        assertEquals(1, resultPegs.size());
        assertTrue(resultPegs.elementAt(0) instanceof WhiteResultPeg);

    }

    @Test
    public void testIfDuplicatesAreInTheGuessOnlyOneWhiteIsReturned(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        SecretCode secretCode = new SecretCode(4, colourContainer);
        ResultContainer resultContainer = new ResultContainer(secretCode);
        secretCode.generateSecretCode();
        Vector<Peg> pegList = new Vector<>(4);

        pegList.add(new Peg(new Blue()));
        pegList.add(new Peg(new Green()));
        pegList.add(new Peg(new Blue()));
        pegList.add(new Peg(new Blue()));

        Guess testGuess = new Guess(pegList);


        secretCode.getPegs().clear();
        secretCode.getPegs().add(new Peg(new Orange()));
        secretCode.getPegs().add(new Peg(new Blue()));
        secretCode.getPegs().add(new Peg(new Red()));
        secretCode.getPegs().add(new Peg(new Purple()));

        resultContainer.generateResultEntryFromGuess(testGuess);
        Vector<ResultPeg> resultPegs = resultContainer.getResultEntries().elementAt(0).getResultPegs();
        assertEquals(1, resultPegs.size());
        assertTrue(resultPegs.elementAt(0) instanceof WhiteResultPeg);
    }

    @Test
    public void testToCheckNoPegsAreReturnedAsExpected(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        SecretCode secretCode = new SecretCode(4, colourContainer);
        ResultContainer resultContainer = new ResultContainer(secretCode);
        secretCode.generateSecretCode();
        Vector<Peg> pegList = new Vector<>(4);

        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Yellow()));

        Guess testGuess = new Guess(pegList);


        secretCode.getPegs().clear();
        secretCode.getPegs().add(new Peg(new Orange()));
        secretCode.getPegs().add(new Peg(new Blue()));
        secretCode.getPegs().add(new Peg(new Red()));
        secretCode.getPegs().add(new Peg(new Purple()));

        resultContainer.generateResultEntryFromGuess(testGuess);
        Vector<ResultPeg> resultPegs = resultContainer.getResultEntries().elementAt(0).getResultPegs();
        assertEquals(0, resultPegs.size());

    }
}
