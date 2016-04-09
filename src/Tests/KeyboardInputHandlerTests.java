package Tests;

import Classes.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KeyboardInputHandlerTests {

    @Test
    public void generateGuessFromStringReturnsTheExpectedGuess(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        KeyboardInputHandler testKeyboardHandler = new KeyboardInputHandler(new KeyboardInputValidator(4, colourContainer));
        String testInput = "BYOGRP";
        Guess testGuess = testKeyboardHandler.generateGuessFromString(testInput);
        assertEquals(6, testGuess.getPegs().size());
        assertTrue(testGuess.getPegs().get(0).getColour() instanceof Blue);
        assertTrue(testGuess.getPegs().get(1).getColour() instanceof Yellow);
        assertTrue(testGuess.getPegs().get(2).getColour() instanceof Orange);
        assertTrue(testGuess.getPegs().get(3).getColour() instanceof Green);
        assertTrue(testGuess.getPegs().get(4).getColour() instanceof Red);
        assertTrue(testGuess.getPegs().get(5).getColour() instanceof Purple);
    }

}
