package Classes;

public class TextRenderer implements Renderer {

    @Override
    public void renderBoard(Board board)
    {
        for(int verticalPosition = 0; verticalPosition < board.getHeight(); verticalPosition++)
        {
            for(int horizontalPosition = 0; horizontalPosition < board.getWidth(); horizontalPosition++)
            {
                System.out.print(board.getSlotValue(horizontalPosition, verticalPosition));
            }
            System.out.println();
        }
    }
}
