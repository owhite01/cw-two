package Classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInputHandler implements InputHandler {

    private KeyboardInputValidator inputValidator;

    @Override
    public Guess queryGuess() {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }

        return new Guess(5);
    }
}
