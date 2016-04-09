package Classes;

public abstract class GameAbstractImpl implements Game{

    public boolean ShouldShowCode() {
        return showCode;
    }

    private boolean showCode;

    public GameAbstractImpl(boolean easy) {
        showCode = easy;
    }


}
