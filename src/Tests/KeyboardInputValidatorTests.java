package Tests;
import Classes.KeyboardInputValidator;
import org.junit.Test;

import static org.junit.Assert.*;


public class KeyboardInputValidatorTests {
    @Test

    public void keyboardValidatorChecksIfEmptyStringIfPassedAsInput(){
        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4);
        String emptyString = "";
        assertEquals(false, keyboardTest.validate(emptyString));


    }

    @Test
    public void keyboardValidatorChecksIfTooManyCharactersAreInString(){
        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4);
        String stringLength = "ABCDE";
        assertEquals(false, keyboardTest.validate(stringLength));

    }

    @Test
    public void keyboardValidatorChecksIfTooFewCharactersAreInString(){
        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4);
        String stringLength = "ABC";
        assertEquals(false, keyboardTest.validate(stringLength));

    }

    @Test
    public void keyboardValidatorChecksIfValidCharactersArePassed(){
        KeyboardInputValidator keyboardTest = new KeyboardInputValidator(4);
        String stringLength = "ABCD";
        assertEquals(false, keyboardTest.validate(stringLength));

    }


}
