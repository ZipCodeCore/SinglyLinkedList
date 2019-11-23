package com.zipcodewilmington.singlylinkedlist;

public class Node<C> {

    C data;
    Node next;

    public Node(C data) {

        this.data = data;
        this.next = null;
    }

    public C getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(C data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString(){
        return "Node {" + "data = " + data + ", next" + "}";
    }
}