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
        if (!node.equals(head)) this.tail = node;
        return node;
    }

    public Node<E> getFirst() {
        Node<E> node = tail;
        while(node.hasPrev()) {
            node = node.getPrev();
        }
        return node;
    }

    public void add(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head != null) {
            newNode = linkPrev(newNode, this.getLast());
        }
        else head = newNode;
        count++;
    }

    // TODO refactor remove method
    public void remove(E data) {
        Node<E> current = this.head;
        Boolean keepLooking;
        do {
            keepLooking = false;
            if (current.getData().equals(data)) {
                if (current.hasPrev() && current.hasNext()) {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                }
                else if (current.hasPrev() && !current.hasNext()) {
                    current.getPrev().setNext(null);
                    this.tail = current.getPrev();
                }
                else if (!current.hasPrev() && current.hasNext()) {
                    current.getNext().setPrev(null);
                    this.head = current.getNext();
                }
                count -= 1;
                break;
            }
            if (current.hasNext()) {
                current = current.getNext();
                keepLooking = true;
            }
        } while (keepLooking);
    }

    public Boolean contains(E data) {
        Node<E> current = this.head;
        Boolean exists = false;
        Boolean keepLooking;
       do {
           keepLooking = false;
            if (current.getData().equals(data)) {
                exists = true;
                break;
            }
           if (current.hasNext()) {
               current = current.getNext();
               keepLooking = true;
           }
       } while (keepLooking);
       return exists;
    }

    public Integer find(E data) {
        Integer index;
        Node<E> node = head;
        if (!this.contains(data)) index = -1;
        else {
            index = 0;
            do {
                if (node.getData().equals(data)) break;
                index += 1;
                node = node.getNext();
            } while (node != null);//.hasNext());
        }
        return index;
    }

    public Integer size() {
        return this.count;
    }

    public E get(Integer index) {
        Node<E> node = head;
        E data = null;
        int count = 0;
        if (index <= size()) {
            while (node != null) {
                if (count == index) {
                    data = node.getData();
                    break;
                }
                node = node.getNext();
                count += 1;
            }
        }
        return data;
    }

    public SinglyLinkedList<E> copy() {
        return this;
    }

    public SinglyLinkedList<E> sort() {
        SinglyLinkedList<E> list = this.copy();

        Boolean sorted;
        do {
            Node<E> node = list.head;
            sorted = true;

            for (int i = 0; i < list.size(); i++) {
                E currentData = list.get(i);
                E nextData = list.get(i+1);

                if (node.hasNext() && currentData.toString().compareToIgnoreCase(nextData.toString()) > 0) {
                    node.setData(nextData);
                    node.getNext().setData(currentData);
                    sorted = false;
                }
                node = node.getNext();
            }

        } while (!sorted);
        return list;
    }

    public SinglyLinkedList<E> reverse() {
        return null;
    }

    public SinglyLinkedList<E> slice(Integer startIndex, Integer upToIndex) {
        return null;
    }

    @Override
    public String toString() {
        Node<E> node = head;
        StringBuilder output = new StringBuilder();
        int count = 0;
        output.append(String.format("%s %s", count, node.getData()));
        while(node.hasNext()) {
            node = node.getNext();
            count += 1;
            output.append(String.format("\n%s %s", count, node.getData()));
        }
        return output.toString();
    }
}