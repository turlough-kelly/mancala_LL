package kelly.turlough;

public class Main {
    public static void main(String[] args)
    {
        Mancala newGame = new Mancala();
        newGame.turn(2);
        newGame.board.printList();


    }
}
