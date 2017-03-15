package mattern.william;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by williammattern on 2/24/17.
 */
public class MyLinkedList<T extends Comparable> {
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

        MyLink(){}

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

    public T get(int index){
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

    public void sort(){
        start = mergeSort(start);
    }

    private MyLink<T> mergeSort(MyLink<T> headOriginal){
        if(headOriginal == null || headOriginal.next == null){
            return headOriginal;
        }

        int count = 0;
        MyLink<T> a = headOriginal;
        while (a != null){
            count++;
            a = a.next;
        }
        int middle = count/2;
        MyLink<T> l = headOriginal, r = null;
        MyLink<T> p2 = headOriginal;
        int countHalf = 0;

        while (p2 != null){
            countHalf++;
            MyLink<T> next = p2.next;
            if(countHalf == middle){
                p2.next = null;
                r = next;
            }
            p2 = next;
        }

        MyLink<T> h1 = mergeSort(l);
        MyLink<T> h2 = mergeSort(r);
        return merge(h1,h2);
    }

    private MyLink<T> merge(MyLink<T> left, MyLink<T> right){
        MyLink<T> head = new MyLink<T>();
        MyLink<T> current = head;
        while((left != null) && (right != null)){
            if(left.data.compareTo(right.data)<=0){
                current.next = left;
                current = left;
                left = left.next;
            } else {
                current.next = right;
                current = right;
                right = right.next;
            }
        }
        current.next = (left == null)?right:left;
        return head.next;
    }

    public void printList(){
        MyLink<T> head = start;
        while(head != null){
            System.out.println(head.data.toString());
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> names = new MyLinkedList<String>();
        {
            names.add("Mary");
            names.add("Steve");
            names.add("Paul");
            names.add("Amber");
            names.add("Raiden");
            names.add("Steve");
            names.add("Skip");
            names.add("Joe");
            names.add("Conrad");
            names.add("Mohommad");
            names.add("Terrance");
            names.add("Bill");
            names.add("Erin");
            names.add("Sue");
            names.add("Amanda");
            names.add("Sara");
        }
        names.printList();
        System.out.println("");
        names.sort();
        names.printList();
    }
}
