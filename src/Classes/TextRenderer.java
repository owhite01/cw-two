package Classes;


public class TextRenderer implements Renderer {

    @Override
    public void renderBoard(Board board)
    {
        for(int verticalPosition = 0; verticalPosition < board.getHeight(); verticalPosition++)
        {
            for(int horizontalPosition = 0; horizontalPosition < board.getWidth(); horizontalPosition++)
            {
                Peg currentPeg = board.getSlotValue(horizontalPosition, verticalPosition).getPeg();
                if(currentPeg != null) {
                    currentPeg.getColour().render();
                }
                else
                {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
