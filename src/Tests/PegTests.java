package Tests;

import Classes.Blue;
import org.junit.Test;
import Classes.Peg;

import static org.junit.Assert.*;

public class PegTests {

    @Test
    public void constructorReturnsExpectedColourAfterCreation(){
        Blue testBlue = new Blue();
        Peg testPeg = new Peg(testBlue);
        assertEquals(testPeg.getColour().getClass(), Blue.class);
    }
}
