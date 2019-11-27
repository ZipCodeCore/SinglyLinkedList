package com.zipcodewilmington.singlylinkedlist;

public class Node {

    Node next;
    Object data;

    // Node constructor
    public Node(Object dataValue) {
        this.next = null;
        this.data = dataValue;
    }

    public Object getData() {
        return this.data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        this.next = nextValue;
    }
}
