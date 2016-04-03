package Classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class GameOverState implements GameState {
    @Override
    public void init() {

    }

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void update() {
        String userInput = "";
        System.out.print("Enter Y for another game or anything else to quit: ");

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = bufferRead.readLine();

        }catch (IOException e) {
            System.out.println(e.toString());
        }


    }

    @Override
    public void render() {

    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
