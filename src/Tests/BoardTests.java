package Tests;
import Classes.*;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.Assert.*;

public class BoardTests {
    @Test
    public void constructorCreatesBoardWithExpectedDimension(){
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(5,5, secretCode);
        assertEquals(newBoard.getHeight(), 5);
        assertEquals(newBoard.getWidth(), 5);
    }
    @Test(expected=IllegalArgumentException.class)
    public void constructorCreatesThrowsExceptionWhenNegativeValuesArePassed(){
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(-5,-5, secretCode);
    }

    @Test(expected=IllegalArgumentException.class)
    public void constructorCreatesThrowsExceptionWhenZeroValuesArePassed(){
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(0,0, secretCode);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void getSlotReturnsValueOutOfRangeWhenPassedTooLargeValues(){
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(9,9, secretCode);
        newBoard.getSlotValue(10,10);
    }

    @Test
    public void getSlotReturnsAValidSlotWhenPassedValidValues() {
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(9,9, secretCode);
        Slot testSlot = newBoard.getSlotValue(8,8);

        assertNotEquals(testSlot, null);
    }

    @Test (expected=IllegalArgumentException.class)
    public void boardThrowsIfGuessHasMorePegsThanWidthOfTheBoard(){
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(4,4, secretCode);
        Vector<Peg> pegList = new Vector<>(5);
        for(int i = 0; i<5; i++){
            pegList.add(new Peg(new Blue()));
        }
        Guess testGuess = new Guess(pegList);
        newBoard.assignGuessToSlots(testGuess);

    }

    @Test
    public void boardAssignsCorrectSlotsFromGuess(){
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(4,4, secretCode);
        Vector<Peg> pegList = new Vector<>(4);
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
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(4,4, secretCode);
        Vector<Peg> pegList = new Vector<>(4);
        pegList.add(new Peg(new Blue()));
        pegList.add(new Peg(new Red()));
        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Purple()));

        Guess testGuess = new Guess(pegList);
        newBoard.assignGuessToSlots(testGuess);
        newBoard.assignGuessToSlots(testGuess);


        assertTrue(newBoard.getSlotValue(0,0).getPeg().getColour() instanceof Blue);
        assertTrue(newBoard.getSlotValue(1,0).getPeg().getColour() instanceof Red);
        assertTrue(newBoard.getSlotValue(2,0).getPeg().getColour() instanceof Yellow);
        assertTrue(newBoard.getSlotValue(3,0).getPeg().getColour() instanceof Purple);

        assertTrue(newBoard.getSlotValue(0,1).getPeg().getColour() instanceof Blue);
        assertTrue(newBoard.getSlotValue(1,1).getPeg().getColour() instanceof Red);
        assertTrue(newBoard.getSlotValue(2,1).getPeg().getColour() instanceof Yellow);
        assertTrue(newBoard.getSlotValue(3,1).getPeg().getColour() instanceof Purple);





    }

    @Test (expected=IndexOutOfBoundsException.class)
    public void boardThrowsIfUserInsertsMoreGuessesThanTheBoardCanContain(){
        SecretCode secretCode = new SecretCode(4);
        Board newBoard = new Board(4,4, secretCode);
        Vector<Peg> pegList = new Vector<>(4);
        pegList.add(new Peg(new Blue()));
        pegList.add(new Peg(new Red()));
        pegList.add(new Peg(new Yellow()));
        pegList.add(new Peg(new Purple()));

        Guess testGuess = new Guess(pegList);
        for(int i = 0; i<20;i++){
            newBoard.assignGuessToSlots(testGuess);
        }



    }

}
