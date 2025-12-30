package kelly.turlough;

public class linked_list
{
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        int value;
        Node next;
        Node prev;


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

    public Node getHead()
    {
        return head;
    }

    public Node getTail()
    {
        return tail;
    }

    public int getLength()
    {
        return length;
    }

    //below to do

    public void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.value);
            temp = temp.next;
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

//    public void prepend()
//    {
//
//    }

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


