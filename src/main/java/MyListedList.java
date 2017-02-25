/**
 * Created by randallcrame on 2/24/17.
 */
public class MyListedList <T> {

    private Node head;
    private Node tail;
    private int modList;

    MyListedList() {
        this.head = new Node(null);
        this.tail = this.head;
        this.modList = 0;
    }

    public void add(T data){
        Node newNode = new Node(data);
        Node formerTail = this.tail;
        if (modList == 0)
            head = newNode;
        else
            formerTail.setNext(newNode);
        tail = newNode;
        modList++;
    }

    public void remove(int index){
        if (index == 0) {
            head = head.getNext();
        }else {
            int counter = 1;
            Node<T> current = head;
            while (index < counter){
                current = current.getNext();
                counter++;
            }
            if (counter == modList)
                tail = current;
            current.setNext(current.getNext().getNext());
        }
        modList--;
    }

    public boolean contains(T data){
        return !(find(data) == -1);
    }

    public int find(T data){
        Node<T> current = head;
        Node<T> previous;
        int counter = 0;
        do{
            if (current.getData().equals(data))
                return counter;
            previous = current;
            current = current.getNext();
            counter++;
        }while (previous.getNext() != null);
        return -1;
    }

    public int size(){return modList;}

    public T get(int index) throws NullPointerException{
        int counter = 0;
        if (index > modList)
            throw new NullPointerException();
        Node<T> current = head;

            while (counter != index){
                current = current.getNext();
                counter++;
            }
        try {
            return current.getData();
        } catch (NullPointerException e){
            return null;
        }
    }

    public MyListedList<T> copy(){
        MyListedList<T> copy = new MyListedList<>();
        Node<T> current = head;
        Node<T> previous;
        do{
            copy.add(current.getData());
            previous = current;
            current = current.getNext();
        }while (previous.getNext() != null);
        return copy;
    }

    public void sort(){

    }

    private static class Node <T> {
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return this.data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
