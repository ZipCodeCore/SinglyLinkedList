import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        BasicLinkedList<String> myList = new BasicLinkedList<>();
        myList.add("Brian");
        myList.add("Andrew");
        myList.add("Pavel");
        myList.add("Tim");
        myList.add("Linda");
        myList.add("Ryan");
        System.out.println(myList.size());
        myList.remove(1);

        System.out.println(myList.size());

        myList.print();

    }
}
