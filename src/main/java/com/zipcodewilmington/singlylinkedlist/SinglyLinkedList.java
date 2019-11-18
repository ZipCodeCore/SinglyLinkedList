package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail;
    private Integer count;

    public SinglyLinkedList() {
        this.count = 0;
    }

    public SinglyLinkedList(E data) {
        this.head = new Node<E>(data);
        this.count = 1;
    }

    public Node<E> linkNext(Node<E> current, Node<E> next) throws NullPointerException {
        current.setNext(next);
        current.getNext().setPrev(current);
        return current;
    }

    public Node<E> linkPrev(Node<E> current, Node<E> prev) {
        current.setPrev(prev).setNext(current);
        return current;
    }

    public Node<E> getLast() {
        Node<E> node = head;
        while (node.hasNext()) {
            node = node.getNext();
        }
        if (!node.equals(head)) this.tail = node;
        return node;
    }

    public Node<E> getFirst() {
        Node<E> node = tail;
        while (node.hasPrev()) {
            node = node.getPrev();
        }
        return node;
    }

    public void add(E data) {
        if (head != null) this.tail = linkPrev(new Node<E>(data), this.getLast());
        else head = new Node<E>(data);
        count++;
    }

    public void connectAroundNodes(Node<E> node) {
        if (node.hasPrev()) node.getPrev().setNext(node.getNext());
        else head = node.getNext();

        if (node.hasNext()) node.getNext().setPrev(node.getPrev());
        else tail = node.getPrev();
        count -= 1;
    }

    public void remove(E data) {
        for (Node<E> node = this.head; node != null; node = node.getNext()) {
            if (node.getData().equals(data)) {
                connectAroundNodes(node);
                break;
            }
        }
    }

    public Boolean contains(E data) {
        Boolean exists = false;
        for (Node<E> node = this.head; node != null; node = node.getNext()) {
            if (node.getData().equals(data)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Integer find(E data) {
        Integer index = 0;
        for (Node<E> node = head; node != null; node = node.getNext()) {
            if (node.getData().equals(data)) break;
            index += 1;
        }
        return (index < this.size()) ? index : -1;
    }

    public Integer size() {
        return this.count;
    }

    public E get(Integer index) {
        E data = null;
        int count = 0;
        for (Node<E> node = this.head; node != null; node = node.getNext()) {
            if (count == index) {
                data = node.getData();
                break;
            }
            count += 1;
        }
        return data;
    }

    public SinglyLinkedList<E> copy() {
        return this;
    }

    public SinglyLinkedList<E> sort() {
        Boolean sorted = false;
        while (!sorted) {
            sorted = true;

            for (Node<E> node = this.head; node.hasNext(); node = node.getNext()) {
                if (node.compareTo(node.getNext())) {
                    node.swapNext();
                    sorted = false;
                }
            }
        }
        return this;
    }

    public SinglyLinkedList<E> reverse() {
        SinglyLinkedList<E> list = new SinglyLinkedList<E>();
        for (Node<E> node = this.tail; node != null; node = node.getPrev()) {
            list.add(node.getData());
        }
        return list;
    }

    public SinglyLinkedList<E> slice(Integer startIndex, Integer upToIndex) {
        SinglyLinkedList<E> list = new SinglyLinkedList<E>();
        for (int i = startIndex; i < upToIndex; i++) {
            list.add(this.get(i));
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        int count = 0;
        for (Node<E> node = this.head; node != null; node = node.getNext()) {
            output.append(String.format("%s %s\n", count, node.getData()));
            count += 1;
        }
        return output.toString();
    }
}
