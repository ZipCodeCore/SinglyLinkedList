package com.zipcodewilmington.singlylinkedlist;

public class Node<E> {
    private E data;
    private Node next;
    private Node prev;

    public Node (E data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }

    public Node<E> getPrev() {
        return this.prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Boolean hasNext() {
        return (next != null);
    }
}
