package susnick.andrea.datastructures;

public class Main {
    public static void main(String[] args){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        myLinkedList.display();


        System.out.println("Size of list: " + myLinkedList.listSize);
    }
}
