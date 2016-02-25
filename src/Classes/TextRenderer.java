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
                    switch (currentPeg.getColour()) {
                        case BLUE:
                        {
                            System.out.print("B");
                        }
                        break;
                        case GREEN:
                        {
                            System.out.print("G");
                        }
                        break;
                        case ORANGE:
                        {
                            System.out.print("O");
                        }
                        break;
                        case PURPLE:
                        {
                            System.out.print("P");
                        }
                        break;
                        case RED:
                        {
                            System.out.print("R");
                        }
                        break;
                        case YELLOW:
                        {
                            System.out.print("Y");
                        }
                        break;
                    }
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
