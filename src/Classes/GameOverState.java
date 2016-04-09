package Classes;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Observable;


public class GameOverState extends Observable implements GameState {

    private Renderer renderer;
    private Boolean isFinished;

    public GameOverState(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void init() {
        isFinished = false;
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

        renderer.renderGameOver();
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            userInput = bufferRead.readLine();

            if(!userInput.equals("Y")){
                setChanged();
                notifyObservers();
            } else {
                isFinished = true;
            }

        }catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public boolean isFinished(){
        return isFinished;
    }
}
