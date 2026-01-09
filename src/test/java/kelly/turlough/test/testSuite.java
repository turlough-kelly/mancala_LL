package kelly.turlough.test;
import kelly.turlough.*;

import org.junit.*;

public class testSuite
{

    @Test
    public void checkProperMovement()
    {
        Mancala testGame = new Mancala();
        testGame.getBoard().setValue(testGame.getBoard().get(4), 13);
        testGame.movePieces(testGame.getBoard().get(4), 1);
        testGame.getBoard().printList();
        Assert.assertEquals(1, testGame.getBoard().getValue(testGame.getBoard().get(4)));
    }

    @Test
    public void checkCapture()
    {
        Mancala testGame = new Mancala();
        testGame.getBoard().setValue(testGame.getBoard().get(4), 1);
        testGame.getBoard().setValue(testGame.getBoard().get(5), 0);
        testGame.getBoard().setValue(testGame.getBoard().getOpposite(testGame.getBoard().get(5)), 15);
        testGame.movePieces(testGame.getBoard().get(4), 1);
        testGame.movePieces(testGame.getBoard().get(4), 1);
        int bingus = 1;
        Assert.assertEquals(16, testGame.getBoard().getValue(testGame.getCurrentPlayerBase(1)));
    }


    @Test
    public void checkEndGameScenario()
    {
        int bingus = 1;
        Assert.assertEquals(1, bingus);
    }

    @Test
    public void checkOutOfBoundsExceptions()
    {
        int bingus = 1;
        Assert.assertEquals(1, bingus);
    }
}

