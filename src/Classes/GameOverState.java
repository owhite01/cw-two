package Classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Observable;


public class GameOverState extends Observable implements GameState {
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
        String userInput;
        System.out.print("Enter Y for another game or anything else to quit: ");

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = bufferRead.readLine();

            if(userInput.equals("Y")){
                setChanged();
                notifyObservers();
            }

        }catch (IOException e) {
            System.out.println(e.toString());
        }


    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
