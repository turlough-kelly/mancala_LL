package kelly.turlough;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Mancala newGame = new Mancala();
        newGame.boardSetup();
        newGame.movePieces(newGame.player1Start, 1);
        newGame.board.printList();


    }
}
