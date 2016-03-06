package Tests;
import Classes.Blue;
import Classes.Board;
import Classes.Peg;
import Classes.Slot;
import Classes.Guess;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTests {
    @Test
    public void constructorCreatesBoardWithExpectedDimension(){
        Board newBoard = new Board(5,5);
        assertEquals(newBoard.getHeight(), 5);
        assertEquals(newBoard.getWidth(), 5);
    }
    @Test(expected=IllegalArgumentException.class)
    public void constructorCreatesThrowsExceptionWhenNegativeValuesArePassed(){
        Board newBoard = new Board(-5,-5);
    }

    @Test(expected=IllegalArgumentException.class)
    public void constructorCreatesThrowsExceptionWhenZeroValuesArePassed(){
        Board newBoard = new Board(0,0);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void getSlotReturnsValueOutOfRangeWhenPassedTooLargeValues(){
        Board newBoard = new Board(9,9);
        newBoard.getSlotValue(10,10);
    }

    @Test
    public void getSlotReturnsAValidSlotWhenPassedValidValues() {
        Board newBoard = new Board(9,9);
        Slot testSlot = newBoard.getSlotValue(8,8);

        assertNotEquals(testSlot, null);
    }

    @Test (expected=IllegalArgumentException.class)
    public void boardThrowsIfGuessHasMorePegsThanWidthOfTheBoard(){
        Board newBoard = new Board(4,4);
        List<Peg> pegList = new ArrayList<>(5);
        for(int i = 0; i<5; i++){
            pegList.add(new Peg(new Blue()));
        }
        Guess testGuess = new Guess(pegList);
        newBoard.assignGuessToSlots(testGuess);

    }

    @Test
    public void boardAssignsCorrectSlotsFromGuess(){
        Board newBoard = new Board(4,4);
        List<Peg> pegList = new ArrayList<>(4);
        for(int i = 0; i<4; i++){
            pegList.add(new Peg(new Blue()));
        }
        Guess testGuess = new Guess(pegList);
        newBoard.assignGuessToSlots(testGuess);

        assertTrue(newBoard.getSlotValue(0,0).getPeg().getColour() instanceof Blue);
        assertTrue(newBoard.getSlotValue(1,0).getPeg().getColour() instanceof Blue);
        assertTrue(newBoard.getSlotValue(2,0).getPeg().getColour() instanceof Blue);
        assertTrue(newBoard.getSlotValue(3,0).getPeg().getColour() instanceof Blue);

    }

    @Test
    public void boardInsertsGuessAfterEachOtherAsExpected(){

    }

    @Test (expected=IllegalArgumentException.class)
    public void boardThrowsIfUserInsertsMoreGuessesThanTheBoardCanContain(){

    }

}
