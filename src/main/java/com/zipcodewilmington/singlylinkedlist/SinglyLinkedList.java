package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> {


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
            if(!temp.equals(data)) {
                temp = temp.next;
            } else return i;
        }
        return null;
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
        //iterate by index through list
        //if the index equals the value we're looking for, assign each value after that to the next
        Node current = head;
        Node last = head;
        for (int i = 0; i < size(); i++) {
             if(i != index) {
                 last = current;
                 current = current.next;
             } else {
                if(i == index) {
                    while(i < size() - 1) {
                        last.next = current.next;
                    }
                }
             }
        }
    }
}
