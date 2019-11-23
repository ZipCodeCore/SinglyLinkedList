package com.zipcodewilmington.singlylinkedlist;

public class Node<C> implements Comparable<C> {


    public int length;
    C data;
    Node<C> next;

    public Node(C data, Node<C> next) {

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

    public int compareTo(C node2) {
        return this.data.compareTo((C)node2.getData());
    }
}