package mattern.william;

import java.util.Comparator;

/**
 * Created by williammattern on 2/24/17.
 */
public class MyLinkedList<T extends Comparable> implements Comparator<T> {
    private MyLink<T> start;
    private MyLink<T> end;
    private int size;

    public MyLinkedList(){
        this.start = null;
        this.end = null;
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
        insertAtTail(t);
    }

    private void insertAtStart(T t){
        MyLink<T> newLink = new MyLink<T>(t);
        newLink.setNext(start);
        start = newLink;
        size++;
    }

    private void insertAtTail(T t){
        MyLink<T> newLink = new MyLink<T>(t);
        newLink.setNext(null);
        if(isEmpty()){
            start = newLink;
        } else {
            end.setNext(newLink);
        }
        end = newLink;
        size++;
    }

    public boolean contains(T t){
        if(get(t) != null){
            return true;
        }
        return false;
    }

    public int find(T t){//used only when implementing insertAtTail() in the add() method
        int index = 0;
        MyLink<T> theLink = start;
        if(!isEmpty()){
            while(!theLink.getData().equals(t)){
                if(theLink.getNext() == null){
                    return -1;
                }
                index++;
                theLink = theLink.getNext();
            }
        }
        return index;
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

    public T get(int index){//only used when implementing insertAtTail in the add method
        MyLink<T> theLink= start;
        while(theLink.next != null) {
            for (int i = index; i > 0; i--) {
                theLink = theLink.next;
            }
            return theLink.getData();
        }
        throw new IndexOutOfBoundsException();
    }

    public MyLinkedList<T> copy(){
        if(!isEmpty()) {
            MyLinkedList<T> copyList = new MyLinkedList<T>();
            MyLink<T> copyNode = start;
            while(copyNode.getNext() != null){
                copyList.add(copyNode.getData());
                copyNode = copyNode.getNext();
            }
            copyList.add(copyNode.getData());
            return copyList;
        }
        return null;
    }

    public int compare(T o1, T o2) {
        return 0;
    }
}
