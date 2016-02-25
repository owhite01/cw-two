package Tests;
import Classes.Board;
import org.junit.Test;


import static org.junit.Assert.*;

public class BoardTest {
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

}
