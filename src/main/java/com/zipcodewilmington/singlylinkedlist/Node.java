package com.zipcodewilmington.singlylinkedlist;

public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;

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

    public Boolean hasPrev() {
        return (prev != null);
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

    public Boolean compareTo(Node<E> next) {
        E currentData = this.getData();
        E nextData = next.getData();
        return (currentData.toString().compareToIgnoreCase(nextData.toString()) < 0);

    }
}
