package Classes;

import java.util.Arrays;
import java.util.Vector;

public class ResultContainer {
    private Vector<ResultEntry> resultEntries;
    private SecretCode secretCode;

    public ResultContainer(SecretCode secretCode) {
        this.resultEntries = new Vector<>();
        this.secretCode = secretCode;

        reset();
    }

    public void reset() {
        resultEntries.clear();
    }

    public void generateResultEntryFromGuess(Guess guess) {

        ResultEntry newResultEntry = new ResultEntry();

        int whitePegCount = 0;
        int blackPegCount = 0;

        Boolean[] verifiedSlots = new Boolean[guess.getPegs().size()];
        Arrays.fill(verifiedSlots, false);

        //first check for black pegs
        for(int pegIndex = 0; pegIndex < guess.getPegs().size(); pegIndex++) {
            Peg secretCodePeg = secretCode.getPegs().elementAt(pegIndex);
            Peg guessPeg = guess.getPegs().elementAt(pegIndex);

            //Check if current peg is black
            if(secretCodePeg.getColour().getClass().equals(guessPeg.getColour().getClass())){
                blackPegCount++;
                verifiedSlots[pegIndex] = true;
            }
        }

        for(int pegIndex = 0; pegIndex < guess.getPegs().size(); pegIndex++){
            Peg guessPeg = guess.getPegs().elementAt(pegIndex);

            for(int whitePegCheckIndex = 0; whitePegCheckIndex < guess.getPegs().size(); whitePegCheckIndex++) {
                if (whitePegCheckIndex != pegIndex) {
                    Peg whiteCheckPeg = secretCode.getPegs().elementAt(whitePegCheckIndex);
                    if (whiteCheckPeg.getColour().getClass().equals(guessPeg.getColour().getClass())) {
                        if (!verifiedSlots[whitePegCheckIndex]) {
                            whitePegCount++;
                            verifiedSlots[whitePegCheckIndex] = true;
                            break;
                        }
                    }
                }
            }
        }

        for(int blackPegCountIndex = 0; blackPegCountIndex < blackPegCount; blackPegCountIndex++){
            newResultEntry.getResultPegs().add(new BlackResultPeg());
        }

        for(int whitePegCountIndex = 0; whitePegCountIndex < whitePegCount; whitePegCountIndex++){
            newResultEntry.getResultPegs().add(new WhiteResultPeg());
        }

        resultEntries.add(newResultEntry);
    }

    public Vector<ResultEntry> getResultEntries() {
        return resultEntries;
    }
}
