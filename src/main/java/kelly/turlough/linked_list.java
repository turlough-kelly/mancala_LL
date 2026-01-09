package kelly.turlough;

public class linked_list
{
    private Node head;
    private Node tail;
    private int length;

    public class Node
    {
        int value;
        Node next;
        Node opposite;
        int owner = 0;


        Node(int value)
        {
            this.value = value;
        }
    }

    linked_list(int value)
    {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public static void resetValue(Node node)
    {
        node.value = 0;
    }

    public Node getHead()
    {
        return head;
    }

    public void setHead(Node node)
    {
        head = node;
    }

    public Node getTail()
    {
        return tail;
    }

    public int getLength()
    {
        return length;
    }

    public int getValue(Node node) { return node.value; }

    public void setValue(Node node, int value) { node.value = value; }

    public Node getOpposite(Node node) { return node.opposite; }

    //below to do

    public void printList()
    {
        int i = 0;
        Node temp = head;
        //do separately for head
        System.out.println("Node index: " + i);
        System.out.println("Node value: " + temp.value);
        System.out.println("Opposite value: " + temp.opposite.value);
        System.out.println("--------------------");
        temp = temp.next;
        i++;
        while(temp != head)
        {
            System.out.println("Node index: " + i);
            System.out.println("Node value: " + temp.value);
            System.out.println("Opposite value: " + temp.opposite.value);
            System.out.println("--------------------");
            temp = temp.next;
            i++;
        }
    }


    public void printAllDetails()
    {
        if(length == 0)
        {
            System.out.println("List is empty.");
        }
        else
        {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
            System.out.println("Current Length: " + length);
        }
    }

    public void add(int value)
    {
        if(length == 0)
        {
            append(value);
        }
        else
        {

        }
    }

    public void prepend(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }

        else
        {
            newNode.next = head;
            head = newNode;
        }
    }

    public void append(int value)
    {
        Node newNode = new Node(value);
        if(length == 0)
        {
            head = newNode;
            tail = newNode;
        }

        else
        {
            tail.next = newNode;
            tail = newNode;
        }

        length++;
    }

    public Node removeFirst()
    {
        if(length == 0)
        {
            return null;
        }
        Node removed = head;
        head = head.next;
        removed.next = null;

        length--;

        return removed;
    }

    public Node removeLast()
    {
        if(length < 1)
        {
            return null;
        }
        Node temp = head;
        Node pre = head;

        while(temp.next != null)
        {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if(length == 0)
        {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node remove(int pos)
    {
        if(pos > length)
        {
            return null;
        }
        if(pos == length)
        {
            return removeLast();
        }
        if(pos == 1)
        {
            return removeFirst();
        }
        Node temp = head;
        Node pre = head;
        for(int i = 0; i < pos; i++)
        {
            pre = temp;
            temp = temp.next;
        }
        pre.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public Node get(int index)
    {
        if(length < index || index < 0)
        {
            return null;
        }

        Node temp = head;
        for(int i = 0; i < index; i++)
        {
            temp = temp.next;
        }


        return temp;
    }

    //node 1 = p1 base, node 2 = p1 start; nodes 2 - 7 = p1 spaces; node 7 = end
    //node 8 = p2 base; node 9 = p2 start; nodes 9 -14 = p2 spaces; node 14 = end

    //important nodes: 1, 2, 7, 8, 9, 14

//
//    public void mancalaSetup(Node p1b, Node p2b, Node p1s, Node p2s, Node p1e, Node p2e)
//    {
//        head = p1b;
//        Node temp = head;
//        append(4);
//        p1s = tail;
//
//        while(temp.next != null)
//        {
//            switch(length)
//            {
//                case 6:
//                    append(4);
//                    p1e = tail;
//                    temp = temp.next;
//                    System.out.println("Added");
//                    break;
//                case 7:
//                    append(0);
//                    p2b = tail;
//                    temp = temp.next;
//                    System.out.println("Added");
//                    break;
//                case 8:
//                    append(4);
//                    p2s = tail;
//                    temp = temp.next;
//                    System.out.println("Added");
//                    break;
//                case 13:
//                    append(4);
//                    p2e = tail;
//                    temp = temp.next;
//                    System.out.println("Added");
//                    break;
//                default:
//                    append(4);
//                    temp = tail;
//                    System.out.println("Added");
//                    break;
//            }
//        }
//    }

//    public void clearList()
//    {
//
//    }
//
//    public void get()
//    {
//
//    }
//
//    public void updateNode()
//    {
//
//    }




}


