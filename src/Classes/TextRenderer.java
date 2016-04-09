package Classes;

public class TextRenderer implements Renderer {

    @Override
    public void renderIntro(int initialNumberOfRounds) {
        System.out.println("Welcome to Mastermind.");
        System.out.print("This is a text version of the classic board game Mastermind.\n" +
                "The computer will think of a secret code.\n" +
                "The code consists of 4 colored pegs.\n" +
                "The pegs may be one of six colors: blue, green , orange, purple, red, or yellow.\n" +
                "A color may appear more than once in the code.\n" +
                "\n" +
                "You try to guess what colored pegs are in the code and what order they are in\n" +
                "After making a guess the result will be displayed.\n" +
                "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n" +
                "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n" +
                "\n" +
                "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n" +
                "When entering guesses you only need to enter the first character of the color as a capital letter.\n" +
                "\n" +
                "You have " + initialNumberOfRounds + " to guess the answer or you lose the game.\n");

        System.out.println();
        System.out.println("Generating secret code ....");
    }

    @Override
    public void renderGameOver() {
        System.out.print("Enter Y for another game or anything else to quit: ");
    }

    @Override
    public void renderUserInputPrompt(int currentPlayCounter) {
        System.out.println("You have " + currentPlayCounter + " guesses left");
        System.out.println("");
        System.out.println("What is your next guess?\n" +
                "Type in the characters for your guess and press enter.");
    }

    @Override
    public void renderSecretCodeOutput(boolean shouldShowSecretCode, SecretCode secretCode) {

        if(shouldShowSecretCode) {
            for(Peg peg : secretCode.getPegs()) {
                System.out.print(peg.getColour().getClass().getSimpleName().charAt(0));
            }
            System.out.println(" Secret Code");
        }
        else {
            System.out.println(".... Secret Code");
        }
    }

    @Override
    public void renderGameWon(){
        System.out.println("You solved the puzzle! Good job.");
    }

    @Override
    public void renderGameLost() {
        System.out.println("You did not solve the puzzle. Too bad.");
    }

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

                        if(currentPeg instanceof BlackResultPeg) {
                            System.out.print("Black");
                        } else if(currentPeg instanceof WhiteResultPeg) {
                            System.out.print("White");
                        }
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
