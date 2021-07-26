package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by Nathan on 7/25/22.
 */
public class SinglyLinkedList<T extends Comparable> {

    class Node {
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }
    }

    public Node head;
    public Node tail;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void add(T data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addHead(T data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public boolean contains(T data){
        Node current = head;
        while(current != null){
            if(current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeTail(){
        Node current = head;
        if(current == null){
            return;
        }
        Node nextNode = current.next;
        while(current.next != null){
            if(nextNode.next == null){
                tail = current;
                current.next = null;
                return;
            }
            current = nextNode;
            nextNode = current.next;
        }
    }

    public void removeHead(){
        Node current = head;
        if(current == null || current.next == null){
            return;
        }
        if(head != null){
            head = current.next;
        }

    }

    public void remove(Integer index){
        if(index < 0 || index > this.size()){
            throw new UnsupportedOperationException("Index is out of bounds :(");
        }
        if(index == 0){
            this.removeHead();
            return;
        }
        if(index == (this.size() - 1)){
            this.removeTail();
            return;
        } else {
            Integer currentIndex = 0;
            Node current = head;
            while(currentIndex < (index - 1)){
                current = current.next;
                currentIndex++;
            }
            Node nextNode = current.next;
            current.next = nextNode.next;
        }
    }

    public Integer findIndex(T data){
        Node current = head;
        Integer index = 0;
        if(current == null){
            return -1;
        }
        while(current != null){
            if(current.data == data){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public Integer size(){
        Integer size = 0;
        Node current = head;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    public Node get(Integer index){
        if(index < 0 || index > (this.size() -1)){
            throw new UnsupportedOperationException("Chosen index is outside the scope of this list! :(");
        }
        Node current = head;
        Integer currentIndex = 0;
        while(currentIndex != index){
            current = current.next;
            currentIndex++;
        }
        return current;
    }

    public void displayNodes() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public SinglyLinkedList<T> clone(){
        SinglyLinkedList<T> cloned = new SinglyLinkedList<T>();
        Node current = head;
        while(current != null){
            cloned.add(current.data);
            current = current.next;
        }
        return cloned;
    }

    public void reverse(){
        tail = head;
        Node origin = head;
        Node prev = null;
        Node current = null;

        while(origin != null){
            current = origin;
            origin = origin.next;
            current.next = prev;
            prev = current;
            head = current;
        }
    }

    public void sort(){
        Node current = head;
        for (int i = 0; i < size(); i++) {
            current = head;
            while(current.next != null){
                if(compareTo(current.getData(), current.next.getData()) > 0){
                    T nextValue = current.next.getData();
                    current.next.data = current.data;
                    current.data = nextValue;
                }
                current = current.next;
            }
        }
        
    }

    public Integer compareTo(T obj, T obj2){
        return obj.compareTo(obj2);
    }

    public SinglyLinkedList<T> slice(Integer start, Integer end){
//        SinglyLinkedList<T> cloned = this.clone();
//        for (int i = 0; i < start; i++) {
//            cloned.removeHead();
//        }
//        for (int i = this.size(); i > end; i--) {
//            cloned.removeTail();
//        }
        SinglyLinkedList<T> cloned = new SinglyLinkedList<T>();
        for (int i = 0; i < end; i++) {
            if(i >= start){
                cloned.add(get(i).getData());
            }
        }
        return cloned;
    }





}
