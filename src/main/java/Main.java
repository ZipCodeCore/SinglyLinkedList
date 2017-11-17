public class Main {

    public static void main(String[] args) {

        SinglyLinkedList<String> myList = new SinglyLinkedList <>();
        myList.add("Zach");
        myList.add("Cool");
        myList.add("Neat");
        myList.add("Awesome");
        myList.add("Wow");

        myList.print();

        System.out.println();
        myList.sort();
        myList.print();




    }
}
