/**
 * Created by randallcrame on 2/24/17.
 */
public class MyListedList <T> {

    private Node head;
    private int modList;

    public void add(T data){}
    public void remove(int index){}
    public boolean contains(T data){return false;};
    public int find(T data){return 0;}
    public int size(){return 0;}
    public T get(int index){return null;}
    public MyListedList<T> copy(){return null;}
    public void sort(){}

    private static class Node <T> {
        private T data;
        private Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }
}
