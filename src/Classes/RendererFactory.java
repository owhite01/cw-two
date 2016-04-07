package Classes;

public final class RendererFactory {
    public static Renderer generateRenderer() {
        return new TextRenderer();
    }
}
