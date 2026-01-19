package kelly.turlough;

import java.util.Scanner;

public class Mancala
{
    linked_list board;

    linked_list.Node player1Base;
    linked_list.Node player1Start;
    linked_list.Node player1End;

    linked_list.Node player2Base;
    linked_list.Node player2Start;
    linked_list.Node player2End;


    //mainly to be used for testing

    //node 1 = p2 base, node 2 = p1 start; nodes 2 - 7 = p1 spaces; node 7 = end
    //node 8 = p1 base; node 9 = p2 start; nodes 9 -14 = p2 spaces; node 14 = end

    //opposites are 7 positions apart

    //important nodes: 1, 2, 7, 8, 9, 14
    public Mancala()
    {
        boardSetup();
        gameLoop();
    }

    public linked_list getBoard() { return board; }

    public void boardSetup()
    {
        board = new linked_list(0);
        player2Base = board.getHead();
        while(board.getLength() != 14)
        {
            switch(board.getLength())
            {
                case 1:
                    board.append(4);
                    player1Start = board.get(1);
                    break;
                case 6:
                    board.append(4);
                    player1End= board.get(6);
                    break;
                case 7:
                    board.append(0);
                    player1Base = board.get(7);
                    break;
                case 8:
                    board.append(4);
                    player2Start = board.get(8);
                    break;
                case 13:
                    board.append(4);
                    player2End = board.get(13);
                    board.get(13).next = board.get(0);
                    break;
                default:
                    board.append(4);
                    break;
            }
        }

        //sets opposites for nodes
        for(int i = 0; i < 7; i++)
        {
            //need to update, opposites are 1/6, 2/5, 3/4, 4/3, 5/2, 6/1
            board.get(i).opposite = board.get(i + 7);
            board.get(i).owner = 1;
            board.get(i + 7).opposite = board.get(i);
            board.get(i + 7).owner = 2;
        }


    }

    public void gameLoop()
    {
        System.out.println("Welome to Mancala! Player 1 is going first.");

        while(!checkGameEnd())
        {
            turn(1);
            if(!checkGameEnd())
            {
                turn(2);
            }
        }

        System.out.println("Thanks for playing Mancala!");
    }




    public void turn(int playerTurn)
    {
        printGameBoard(playerTurn);
        System.out.println("\nIt is player " + playerTurn + "'s turn.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a node from 1 - 6: ");
        int selectedNode = scanner.nextInt();
        if(selectedNode < 1 || selectedNode > 6)
        {
            System.out.println("This node is not valid. Please select another");
            while(selectedNode < 0 || selectedNode > 6)
            {
                selectedNode = scanner.nextInt();
            }
        }


        if(playerTurn == 2)
        {
            selectedNode += 7;
        }
        if(board.get(selectedNode).value == 0)
        {
            System.out.println("This node is empty and cannot be selected.\n");
            turn(playerTurn);
        }

        else
        {
            movePieces(board.get(selectedNode), playerTurn);
        }
    }

    public void movePieces(linked_list.Node selectedPocket, int playerTurn)
    {
        int currentPieces = selectedPocket.value;
        linked_list.resetValue(selectedPocket);
        linked_list.Node temp = selectedPocket;

        while(currentPieces != 0)
        {
            temp = temp.next;
            temp.value += 1;
            currentPieces -= 1;
            if (playerTurn == 1)
            {
                if (temp == player2Base)
                {
                    System.out.println("Skipping base...");
                    temp = temp.next;
                }
            }
            else if (playerTurn == 2)
            {
                if (temp == player1Base)
                {
                    System.out.println("Skipping base...");
                    temp = temp.next;
                }
            }
        }
        //check after turn conditions
        if((playerTurn == 1 && temp == getCurrentPlayerBase(playerTurn)) || (playerTurn == 2 && temp == getCurrentPlayerBase(playerTurn)))
        {
            System.out.println("Extra turn!");
            if(!checkGameEnd())
            {
                turn(playerTurn);
            }

        }

        if(temp.value == 1 && temp.owner == playerTurn)
        {
            System.out.println("Pieces captured!");
            capture(temp, playerTurn);
        }
    }


    //to run if last stone is placed in empty pocket on player's side
    public void capture(linked_list.Node currentNode, int currentPlayer)
    {
        int currentNodeValue = currentNode.value;
        int oppositeNodeValue = currentNode.opposite.value;
        switch(currentPlayer)
        {
            case 1:
                player1Base.value += (currentNodeValue + oppositeNodeValue);
                break;

            case 2:
                player2Base.value += (currentNodeValue + oppositeNodeValue);
                break;
        }

        linked_list.resetValue(currentNode);
        linked_list.resetValue(currentNode.opposite);
    }


    public linked_list.Node getCurrentPlayerBase(int player)
    {

        return switch (player) {
            case 1 -> player1Base;
            case 2 -> player2Base;
            default -> null;
        };
    }

    public boolean checkGameEnd()
    {
        int p1 = board.get(1).value + board.get(2).value + board.get(3).value + board.get(4).value + board.get(5).value+ board.get(6).value;
        System.out.println("p1 value: " + p1);
        int p2 = board.get(8).value + board.get(9).value + board.get(10).value + board.get(11).value + board.get(12).value + board.get(13).value;
        System.out.println("p1 value: " + p2);

        return p1 == 0 || p2 == 0;
    }

    public void printGameBoard(int playerTurn)
    {
        System.out.println("\n\n\n");

        switch(playerTurn)
        {
            //switch cases to print the board in different orientations, depending on the player going
            case 1:
                System.out.println("Player 2 Pockets        | " + board.get(13).value + " |" + "| " + board.get(12).value + " |" + "| " + board.get(11).value + " |" + "| " + board.get(10).value + " |" + "| " + board.get(9).value + " |" + "| " + board.get(8).value + " |");
                System.out.println("\nYour pockets            | " + board.get(1).value + " |" + "| " + board.get(2).value + " |" + "| " + board.get(3).value + " |" + "| " + board.get(4).value + " |" + "| " + board.get(5).value + " |" + "| " + board.get(6).value + " |");
                System.out.println("                          1    2    3    4    5    6  \n");
                break;
            case 2:
                System.out.println("Player 1 Pockets        | " + board.get(6).value + " |" + "| " + board.get(5).value + " |" + "| " + board.get(4).value + " |" + "| " + board.get(3).value + " |" + "| " + board.get(2).value + " |" + "| " + board.get(1).value + " |");
                System.out.println("\nYour pockets            | " + board.get(8).value + " |" + "| " + board.get(9).value + " |" + "| " + board.get(10).value + " |" + "| " + board.get(11).value + " |" + "| " + board.get(12).value + " |" + "| " + board.get(13).value + " |");
                System.out.println("                          1    2    3    4    5    6  \n");
                break;
        }
        System.out.println("\nPlayer 1 Mancala: " + board.get(7).value + "\nPlayer 2 Mancala: " + board.get(0).value);
    }


//    public linked_list.Node getCOppositePlayerBase(int player)
//    {
//        return switch (player) {
//            case 1 -> player2Base;
//            case 2 -> player1Base;
//            default -> null;
//        };
//    }
//
//    public linked_list.Node getCurrentPlayerEnd(int player)
//    {
//
//        return switch (player) {
//            case 1 -> player1End;
//            case 2 -> player2End;
//            default -> null;
//        };
//    }
//
//    public linked_list.Node getOppositePlayerEnd(int player)
//    {
//
//        return switch (player) {
//            case 1 -> player2End;
//            case 2 -> player1End;
//            default -> null;
//        };
//    }
//
//
//
//    //getters for bases, starts and ends (setters not necessary as they will not change from assigned nodes)
//    public linked_list.Node getBase(int playerNumber)
//    {
//        return switch (playerNumber) {
//            case 1 -> player1Base;
//            case 2 -> player2Base;
//            default -> null;
//        };
//    }
//
//    public linked_list.Node getStart(int playerNumber)
//    {
//        return switch (playerNumber) {
//            case 1 -> player1Start;
//            case 2 -> player2Start;
//            default -> null;
//        };
//    }
//
//    public linked_list.Node getEnd(int playerNumber)
//    {
//        return switch (playerNumber) {
//            case 1 -> player1End;
//            case 2 -> player2End;
//            default -> null;
//        };
//    }

}
