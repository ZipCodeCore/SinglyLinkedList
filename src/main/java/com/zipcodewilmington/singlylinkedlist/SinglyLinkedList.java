package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node head = null;
    public Node tail = null;

    public void add(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;

        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void remove(Object data) {
        if (head == data || head.next == data) {
            head = null;
        } else if (tail == data) {
            tail = null;
        }
    }

    public boolean contains(Object data) {
        if(head == data || head.next == data || tail == data) {
            return true;
        } else {
            return false;
        }
    }

    public Integer find(Object data) {

        return null;
    }

}




//<SomeType extends Comparable<SomeType>>{


//    class Node {
//        SomeType data;
//        Node next;
//
//        public Node(SomeType data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    public Node head = null;
//    public Node tail = null;
//
//    public void add(SomeType data) {
//        Node newNode = new Node(data);
//        if(head == null) {
//            head = newNode;
//
//        } else {
//            tail.next = newNode;
//        }
//        tail = newNode;
//    }
//
//    public void remove(SomeType data) {
//        Node newNode = new Node(data);
//
//    }



