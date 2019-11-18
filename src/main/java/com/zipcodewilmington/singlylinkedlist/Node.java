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

    public Node<E> setPrev(Node<E> prev) {
        this.prev = prev;
        return this.prev;
    }

    public Boolean hasPrev() {
        return (prev != null);
    }

    public E getData() {
        return this.data;
    }

    public Node<E> setData(E data) {
        this.data = data;
        return this;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public Node<E> setNext(Node<E> next) {
        this.next = next;
        return this.next;
    }

    public Boolean hasNext() {
        return (next != null);
    }

    public Boolean compareTo(Node<E> next) {
        return (this.getData().toString().compareToIgnoreCase(next.getData().toString()) > 0);
    }

    public void swapNext() {
        E data = this.getData();
        this.setData(next.getData()).getNext().setData(data);
    }
}