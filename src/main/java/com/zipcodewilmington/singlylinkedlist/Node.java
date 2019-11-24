package com.zipcodewilmington.singlylinkedlist;

public class Node {

    Node next;
    Object data;

    // Node constructor
    public Node(Object dataValue) {
        next = null;
        data = dataValue;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextValue) {
        next = nextValue;
    }
}
