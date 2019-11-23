package com.zipcodewilmington.singlylinkedlist;
import com.zipcodewilmington.singlylinkedlist.SinglyLinkedList;

public class Node<C> {


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


}