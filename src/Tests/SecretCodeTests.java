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
        SecretCode secretCode = new SecretCode(4);
        assertEquals(secretCode.getPegs().size(), 4);
    }

    @Test
    public void generateSecretCodeGeneratesACodeWithTheExpectedPegCount(){
        SecretCode secretCode = new SecretCode(5);
        secretCode.generateSecretCode();
        assertEquals(secretCode.getPegs().size(), 5);
    }

    @Test
    public void generateSecretCodeGeneratesANewCodeWhenCalledASecondTime(){
        SecretCode secretCode = new SecretCode(5);
        secretCode.generateSecretCode();
        List<Peg> firstCode = new ArrayList<>(secretCode.getPegs());
        secretCode.generateSecretCode();
        List<Peg> secondCode = secretCode.getPegs();

        assertFalse(firstCode.containsAll(secondCode));
    }


}
