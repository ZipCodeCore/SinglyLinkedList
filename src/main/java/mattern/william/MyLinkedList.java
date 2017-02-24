package mattern.william;

/**
 * Created by williammattern on 2/24/17.
 */
public class MyLinkedList<T> {
    private MyLink<T> start;
    private int size;

    public MyLinkedList(){
        this.start = null;
        this.size = 0;
    }

    private class MyLink<T>{
        private T data;
        private MyLink<T> next;

        MyLink(T t){
            this.data = t;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public MyLink<T> getNext() {
            return next;
        }

        public void setNext(MyLink<T> next) {
            this.next = next;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void add(T t){
        insertAtStart(t);
    }

    private void insertAtStart(T t){
        MyLink<T> newLink = new MyLink<T>(t);
        newLink.setNext(start);
        start = newLink;
        size++;
    }

    public boolean contains(T t){
        if(get(t) != null){
            return true;
        }
        return false;
    }

    public int find(T t){
        return -1;
    }

    private MyLink<T> get(T t){
        MyLink<T> theLink = start;
        if(!isEmpty()) {
            while (!theLink.getData().equals(t)) {
                if (theLink.getNext() == null) {
                    return null;
                } else {
                    theLink = theLink.getNext();
                }
            }
        } else {
            System.out.println("empty list");
        }
        return theLink;
    }

    public MyLinkedList<T> copy(MyLinkedList<T> linkedList){
        return null;
    }

    public void sort(){}
}
