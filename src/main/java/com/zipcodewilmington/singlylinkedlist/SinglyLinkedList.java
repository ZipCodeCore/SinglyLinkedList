package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {



    class Node<T>{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(T data){
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode; //on the first iteration, head and tail mean the same thing
    }


    public Integer size(){
        Integer count = 0;
        Node current = this.head;
        count = current.next == null ? 0 : 1;
        while(current.next != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public Integer find(T valueToFind){
        Node current = this.head;
        Integer index = 0;
        if(current == null)
            return -1;
        while(current != null){
            if(current.data.equals(valueToFind))
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public Boolean contains(T valueToFind){
        return this.find(valueToFind) >= 0;
    }


    public void remove(T valueToFind){
        Node current = head;
        Node last = head;
        while(current != null){
            if(current.data.equals(valueToFind))
                if(current.next == null) {
                    last.next = null;
                } else if(current == last){
                    head = current.next;
                }
                else {
                    last.next = current.next;
                }
            last = current;
            current = current.next;

        }
    }

    public void display() {
        Node current = head;
        //checkListEmpty("There's no list, idiot.");
        System.out.println("Nodes of singly linked list:");
        while (current != null) {
            System.out.println(current.data + "");
            current = current.next;
        }
    }

    public T get(Integer index){
        Node current = head;
        Integer currentIndex = 0;
        if(index >= size())
            return null;
        if(index == size() - 1)
            return (T)tail.data;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return (T)current.data;
    }

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> copiedList = new SinglyLinkedList<T>();
        Node current = head;

        while(current != null){
            copiedList.addNode((T)current.data);
            current = current.next;
        }
        return copiedList;
    }

    public void set(Integer index, T valueToSet){
        Node current = head;

        for(int i = 0; i < index; i++){
            current = current.next;
        }
        current.data = valueToSet;
    }
    //10    1
    //15
    //2
    //1
    public void sort(){
        Node current = head;
        for(int i = 0; i < size(); i++){
            current = head;
            while(current.next != null){
                if(compareTo((T)current.data, (T)current.next.data) > 0){
                    T nextVal = (T)current.next.data;
                    current.next.data = current.data;
                    current.data = nextVal;
                }
                current = current.next;
            }
        }
    }

    public SinglyLinkedList<T> slice(int start, int end){
        SinglyLinkedList<T> subList = new SinglyLinkedList<T>();

        for(int i = 0; i < end; i++){
            if(i >= start)
            subList.addNode(get(i));
        }
        return subList;
    }

    public void reverse(){
        Node orig = head;
        Node prev = null;
        Node current = null;

        while(orig != null) {
            current = orig;
            orig = orig.next;

            current.next = prev;
            prev = current;
            head = current;
            //this.display();
        }
    }

    public int compareTo(T o, T o2) {
        return o.compareTo(o2);
    }
}
