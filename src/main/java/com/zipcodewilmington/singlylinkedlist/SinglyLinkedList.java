package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private Integer count;

    public SinglyLinkedList() {
        this.count = 0;
    }
    public SinglyLinkedList(E data) {
        this.head = new Node<E>(data);
        this.count = 1;
    }

    public Node<E> linkNext(Node<E> current, Node<E> next) {
        current.setNext(next);
        current.getNext().setPrev(current);
        return current;
    }

    public Node<E> linkPrev(Node<E> current, Node<E> prev) {
        current.setPrev(prev);
        current.getPrev().setNext(current);
        return current;
    }

    public Node<E> getLast() {
        Node<E> node = head;
        while(node.hasNext()) {
            node = node.getNext();
        }
        return node;
    }

    public void add(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head != null) {
            newNode = linkPrev(newNode, this.getLast());
//            if (this.getLast() == newNode) tail = newNode;
        }
        else head = newNode;
        count++;
    }

    public void remove(E data) {

    }

    public Boolean contains(E data) {
        Node<E> current = this.head;
        Boolean exists = false;
        while (current.hasNext()) {
            if (current.getData().equals(data)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Integer find(E data) {
        return -1;
    }

    public Integer size() {
        return this.count;
    }

    public E get(Integer index) {
        return null;
    }

    public SinglyLinkedList<E> copy() {
        return null;
    }

    public SinglyLinkedList<E> sort() {
        return null;
    }

    public SinglyLinkedList<E> reverse() {
        return null;
    }

    public SinglyLinkedList<E> slice(Integer startIndex, Integer upToIndex) {
        return null;
    }
}