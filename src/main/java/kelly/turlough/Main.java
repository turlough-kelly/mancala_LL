package kelly.turlough;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        linked_list list = new linked_list(5);
        list.append(6);

        list.removeLast();

        list.printList();

    }
}
