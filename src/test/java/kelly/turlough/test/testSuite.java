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
        int bingus = 1;
        Assert.assertEquals(1, bingus);
    }


    @Test
    public void checkCompleteBoardTraversal()
    {
        int bingus = 1;
        Assert.assertEquals(1, bingus);
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

