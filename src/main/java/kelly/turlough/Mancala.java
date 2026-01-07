package kelly.turlough;

public class Mancala
{
    linked_list.Node player1Base;
    linked_list.Node player1Start;
    linked_list.Node player1End;

    linked_list.Node player2Base;
    linked_list.Node player2Start;
    linked_list.Node player2End;

    linked_list board;

    //node 1 = p2 base, node 2 = p1 start; nodes 2 - 7 = p1 spaces; node 7 = end
    //node 8 = p1 base; node 9 = p2 start; nodes 9 -14 = p2 spaces; node 14 = end

    //opposites are 7 positions apart

    //important nodes: 1, 2, 7, 8, 9, 14

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
                    break;
                default:
                    board.append(4);
                    break;
            }
        }
        //sets opposites for nodes
        for(int i = 0; i < 7; i++)
        {
            board.get(i).opposite = board.get(i + 7);
            board.get(i + 7).opposite = board.get(i);
        }
    }



    //when creating the loop, end when either pocket has 25 or more stones (majority wins)
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

    public void movePieces(linked_list.Node selectedPocket, int playerTurn)
    {
        int currentPieces = selectedPocket.value;
        linked_list.resetValue(selectedPocket);
        linked_list.Node temp = selectedPocket.next;
        while(currentPieces != 0)
        {
            temp.value += 1;
            currentPieces -= 1;
            //if(temp.next == getBase())
            temp = temp.next;
        }
    }

    public linked_list.Node getCurrentPlayerBase(int player)
    {

        return switch (player) {
            case 1 -> player1Base;
            case 2 -> player2Base;
            default -> null;
        };
    }

    public linked_list.Node getCOppositePlayerBase(int player)
    {
        return switch (player) {
            case 1 -> player2Base;
            case 2 -> player1Base;
            default -> null;
        };
    }

    public linked_list.Node getCurrentPlayerEnd(int player)
    {

        return switch (player) {
            case 1 -> player1End;
            case 2 -> player2End;
            default -> null;
        };
    }

    public linked_list.Node getOppositePlayerEnd(int player)
    {

        return switch (player) {
            case 1 -> player2End;
            case 2 -> player1End;
            default -> null;
        };
    }



    //getters for bases, starts and ends (setters not necessary as they will not change from assigned nodes)
    public linked_list.Node getBase(int playerNumber)
    {
        return switch (playerNumber) {
            case 1 -> player1Base;
            case 2 -> player2Base;
            default -> null;
        };
    }

    public linked_list.Node getStart(int playerNumber)
    {
        return switch (playerNumber) {
            case 1 -> player1Start;
            case 2 -> player2Start;
            default -> null;
        };
    }

    public linked_list.Node getEnd(int playerNumber)
    {
        return switch (playerNumber) {
            case 1 -> player1End;
            case 2 -> player2End;
            default -> null;
        };
    }

}
