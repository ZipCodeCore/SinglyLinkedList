package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>>  {


    class Node{
        T data;
        Node next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void add(T data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public int size() {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Integer find(T data) {
        Node temp = head;
        for(int i = 0; i < size(); i++) {
            if(!temp.data.equals(data)) {
                temp = temp.next;
            } else return i;
        }
        return -1;
    }

    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(Integer index) {
        Node current = head;
        Node last = head;
        for (int i = 0; i < size(); i++) {
             if(i != index) {
                 last = current;
                 current = current.next;
             } else {
                 while(i < size() - 1) {
                     last.next = current.next;
                }
             }
        }
    }

    public T get(Integer index) {
        Node temp = head;
        for(int i = 0; i < size(); i++) {
            if(i == index) {
                return temp.data;
            } else temp = temp.next;
        }
        return null;
    }


    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        Node temp = head;
        while(temp != null) {
            newList.add(temp.data);
            temp = temp.next;
        }
        return newList;
    }

    public void sort() {
        Node current = head;

        for(int i = 0; i < size(); i++) {
            current = head;
            while(current.next != null) {
                if(current.data.compareTo(current.next.data) > 0) {
                    T temp = current.next.data;
                    current.next.data = current.data;
                    current.data = temp;
                }
                current = current.next;
            }
        }
    }

    public void reverse() {
        Node original = head;
        Node previous = null;
        Node current = null;

        while(original != null) {
            current = original;
            original = original.next;

            current.next = previous;
            previous = current;
            head = current;
        }
    }

    public SinglyLinkedList<T> slice(Integer startIndex, Integer endIndex) {
        SinglyLinkedList<T> slicedList = new SinglyLinkedList<T>();

        for(int i = 0; i <= endIndex; i++) {
            if(i >= startIndex) {
                slicedList.add(get(i));
            }
        }
        return slicedList;
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
}
