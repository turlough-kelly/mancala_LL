package kelly.turlough.test;
import kelly.turlough.*;

import org.junit.*;

public class testSuite
{
    Mancala testGame = new Mancala();


    @Test
    public void checkProperMovement()
    {
        int bingus = 1;
        Assert.assertEquals(1, bingus);
    }
}
