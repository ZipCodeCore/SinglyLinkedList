package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList< T extends Comparable<T>> {

    class Node<T> {
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;


    public void addNode(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head =  newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public Integer size(){
        Integer count = 0;
        Node current = this.head;

        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Integer find(T valueToFind) {
        Node current =  this.head;
        Integer index = 0;

        if(current == null)
            return -1;

        while (current != null) {
            if (current.data.equals(valueToFind))
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public Boolean contains(T valueToFind) {
        return this.find(valueToFind) >= 0; //if value is not -1 then the list contains the value
    }

    public void remove(T valueToFind){
        Node current = head;
        Node last = head;

        while(current != null){
            if(current.data.equals(valueToFind)) {
                if (current.next == null) {
                    last.next = null;
                } else if (current == last) {
                    head = current.next;
                } else
                    last.next = current.next;
            }
            last = current;
            current = current.next;
        }
    }

    public T get(Integer index) {
        Node current = head;

        if(index >= size() || index < 0)
            return null;

        if (index == size() -1)
            return (T)tail.data;

        for (int i = 0; i < index; i++) {
             current = current.next;
        }
        return (T)current.data;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> copiedList = new SinglyLinkedList<T>();
        Node current = head;

        while(current != null) {
            copiedList.addNode((T)current.data);
            current = current.next;
        }
        return copiedList;
    }
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

    public int compareTo(T o, T o2) {
        return o.compareTo(o2);
    }
    }

