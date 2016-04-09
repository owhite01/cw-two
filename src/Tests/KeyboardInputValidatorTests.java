package Tests;
import Classes.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;


public class KeyboardInputValidatorTests {
    @Test
    public void keyboardValidatorChecksIfEmptyStringIfPassedAsInput(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4, colourContainer);
        String emptyString = "";
        assertEquals(false, keyboardTest.validate(emptyString));


    }

    @Test
    public void keyboardValidatorChecksIfTooManyCharactersAreInString(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4, colourContainer);
        String stringLength = "ABCDE";
        assertEquals(false, keyboardTest.validate(stringLength));

    }

    @Test
    public void keyboardValidatorChecksIfTooFewCharactersAreInString(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4, colourContainer);
        String stringLength = "ABC";
        assertEquals(false, keyboardTest.validate(stringLength));

    }

    @Test
    public void keyboardValidatorChecksIfValidCharactersArePassed(){
        List<Colour> colours = new ArrayList<>();
        colours.add(new Blue());
        colours.add(new Green());
        colours.add(new Yellow());
        colours.add(new Purple());
        colours.add(new Red());
        colours.add(new Orange());

        ColourContainer colourContainer = new ColourContainer();
        colourContainer.setAvailableColours(colours);

        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4, colourContainer);
        String stringLength = "ABCD";
        assertEquals(false, keyboardTest.validate(stringLength));
    }


}
