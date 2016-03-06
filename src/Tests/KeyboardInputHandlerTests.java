package Tests;

import Classes.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class KeyboardInputHandlerTests {

    @Test
    public void generateGuessFromStringReturnsTheExpectedGuess(){
        KeyboardInputHandler testKeyboardHandler = new KeyboardInputHandler(new KeyboardInputValidator(4));
        String testInput = "BYOGRP";
        Guess testGuess = testKeyboardHandler.generateGuessFromString(testInput);
        assertEquals(4, testGuess.getPegs().size());
        assertTrue(testGuess.getPegs().get(0).getColour() instanceof Blue);
        assertTrue(testGuess.getPegs().get(1).getColour() instanceof Yellow);
        assertTrue(testGuess.getPegs().get(2).getColour() instanceof Orange);
        assertTrue(testGuess.getPegs().get(3).getColour() instanceof Green);
        assertTrue(testGuess.getPegs().get(4).getColour() instanceof Red);
        assertTrue(testGuess.getPegs().get(5).getColour() instanceof Purple);




    }

}
