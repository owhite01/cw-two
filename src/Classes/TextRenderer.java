package Classes;

public class TextRenderer implements Renderer {

    @Override
    public void renderStateOfBoard(Board board, ResultContainer resultContainer) {
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
            if(resultContainer.getResultEntries().size() > verticalPosition){
                System.out.print(" Result: ");
                if (resultContainer.getResultEntries().elementAt(verticalPosition).getResultPegs().size() == 0){
                    System.out.print("No pegs");
                }else{
                    int pegCount = resultContainer.getResultEntries().elementAt(verticalPosition).getResultPegs().size();
                    for(int pegIndex = 0; pegIndex < pegCount; pegIndex++){
                        ResultPeg currentPeg = resultContainer.getResultEntries().elementAt(verticalPosition).getResultPegs().elementAt(pegIndex);
                        currentPeg.render();
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
