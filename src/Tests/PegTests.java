package Tests;

import org.junit.Test;
import Classes.Peg;

import static org.junit.Assert.*;

public class PegTests {

    @Test
    public void constructorReturnsExpectedColourAfterCreation(){
        Peg testPeg = new Peg(Peg.Colour.BLUE);
        assertEquals(testPeg.getColour(), Peg.Colour.BLUE);
    }
}
