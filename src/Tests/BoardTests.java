package Tests;
import Classes.Board;
import Classes.Slot;
import org.junit.Test;


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

}
