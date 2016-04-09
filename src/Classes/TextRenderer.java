package Classes;

public class TextRenderer implements Renderer {

    @Override
    public void renderBoard(Board board) {
        for(int verticalPosition = 0; verticalPosition < board.getHeight(); verticalPosition++) {
            for(int horizontalPosition = 0; horizontalPosition < board.getWidth(); horizontalPosition++){
                Peg currentPeg = board.getSlotValue(horizontalPosition, verticalPosition).getPeg();
                if(currentPeg != null) {
                    System.out.print(currentPeg.getColour().getClass().getSimpleName().charAt(0));
                }
                else{
                    System.out.print(".");
                }
            }
            if(board.getResults().size() > verticalPosition){
                System.out.print(" Result: ");
                if (board.getResults().elementAt(verticalPosition).getResultPegs().size() == 0){
                    System.out.print("No pegs");
                }else{
                    int pegCount = board.getResults().elementAt(verticalPosition).getResultPegs().size();
                    for(int pegIndex = 0; pegIndex < pegCount; pegIndex++){
                        ResultPeg currentPeg = board.getResults().elementAt(verticalPosition).getResultPegs().elementAt(pegIndex);
                        currentPeg.render();
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
