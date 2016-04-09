package Tests;

import Classes.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;

public class SecretCodeTests {
    @Test
    public void generateSecretCodeGeneratesACodeWithTheRightPegCountOnConstruction() {
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
        assertEquals(secretCode.getPegs().size(), 4);
    }

    @Test
    public void generateSecretCodeGeneratesACodeWithTheExpectedPegCount(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        SecretCode secretCode = new SecretCode(5, colourContainer);
        secretCode.generateSecretCode();
        assertEquals(secretCode.getPegs().size(), 5);
    }

    @Test
    public void generateSecretCodeGeneratesANewCodeWhenCalledASecondTime(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        SecretCode secretCode = new SecretCode(5, colourContainer);
        secretCode.generateSecretCode();
        List<Peg> firstCode = new ArrayList<>(secretCode.getPegs());
        secretCode.generateSecretCode();
        List<Peg> secondCode = secretCode.getPegs();

        assertFalse(firstCode.containsAll(secondCode));
    }


}
