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
            head = head.next;
        }else {
            int counter = 1;
            Node<T> current = head;
            while (index < counter){
                current = current.next;
                counter++;
            }
            if (counter == modList)
                tail = current;
            current.setNext(current.next.next);
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
            if (current.data.equals(data))
                return counter;
            previous = current;
            current = current.next;
            counter++;
        }while (previous.next != null);
        return -1;
    }

    public int size(){return modList;}

    public T get(int index) throws NullPointerException{
        int counter = 0;
        if (index > modList)
            throw new NullPointerException();
        Node<T> current = head;

            while (counter != index){
                current = current.next;
                counter++;
            }
        try {
            return current.data;
        } catch (NullPointerException e){
            return null;
        }
    }

    public MyListedList<T> copy(){
        MyListedList<T> copy = new MyListedList<>();
        Node<T> current = head;
        Node<T> previous;
        do{
            copy.add(current.data);
            previous = current;
            current = current.next;
        }while (previous.next != null);
        return copy;
    }
        // based on http://www.sanfoundry.com/java-program-implement-merge-sort-algorithm-linked-list/ and
        // http://stackoverflow.com/questions/18284636/implementing-comprable-method-in-a-generic-way-in-java-for-sorting
        private  <T extends Comparable<T>> Node MergeSort(Node headOriginal){
            if (headOriginal == null || headOriginal.next == null)
                return headOriginal;
            Node head = headOriginal;
            Node next = headOriginal.next;
            while ((next != null) && (next.next != null)) {
                headOriginal = headOriginal.next;
                next = next.next.next;
            }
            next = headOriginal.next;
            headOriginal.next = null;
            return merge(MergeSort(head), MergeSort(next));
        }

        private <T extends Comparable<T>> Node<T> merge(Node<T> head, Node<T> next){
            Node<T> temp = new Node(null);
            Node startHead = temp;
            Node current = startHead;
            while ((head != null) && (next != null)) {
                if (head.data.compareTo(next.data) <= 0){
                    current.next = head;
                    current = head;
                    head = head.next;
                } else {
                    current.next = next;
                    current = next;
                    next = next.next;
                }
            }
            current.next = (head == null) ? next : head;
            return startHead.next;
        }


    public void sort(){
       head =  MergeSort(head);
    }

    private static class Node <T> {
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
