package Classes;

//TODO use spring DI for this
public class Factory {
    public static Game getInstance(Class c, Boolean b){
        return new GameImpl(b);
    }
}
