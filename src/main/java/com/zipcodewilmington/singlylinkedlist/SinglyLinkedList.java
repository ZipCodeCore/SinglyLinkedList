package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> implements Comparator<T> {
    private Node<T> head = null;
    private Node<T> tail;
    private Integer size;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public SinglyLinkedList(T data) {
        this.head = new Node<T>(data);
        this.size = 0;
    }

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void add(T data) {
        if (head != null) {
            Node current = head;

            while (current != null) {
                if (current.getNext() == null) {
                    current.setNext(new Node<T>(data));
                    size++;
                }
                current = current.getNext();
            }
        } else {
            this.head = new Node<T>(data);
            size++;
        }


    }

    public Boolean remove(Integer index) {
        Node current = this.head;
        Integer count = 0;
        Node prev = null;


        if (index == 0) {
            current = current.next;
            size--;
            return true;
        } else if (index > 0) {
            while (current.getNext() != null) {
                if (count == index - 1) {
                    current.setNext(current.getNext().getNext());
                    size--;

                }
                current = current.next;
                count++;

            }
            return true;
        } else
            return false;
    }

    public Boolean contains(T data) {
        Node current = this.head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public Integer find(T data) {
        Node current = this.head;
        Integer count = 0;
        while (current != null) {
            if (current.getData().equals(data)) {
                return count;

            }
            current = current.getNext();
            count++;
        }
        return -1;
    }

    public Integer size() {
        return this.size;
    }

    public T get(Integer index) {
        Integer count = 0;
        Node<T>current = this.head;
        while (current != null) {
            if (count.equals(index)) {
                return current.data;
            }
            current = current.next;
            count++;

        }
        return null;
    }

    public SinglyLinkedList<T> copy() {

        SinglyLinkedList<T> newList = new SinglyLinkedList<>();
        Node<T> current = this.head;
        while (current.getNext() != null) {
            newList.add(current.getData());
            current = current.next;
        }

        return newList;
    }




  /*      Node current = head, nextNode = null;
        int temp;

        while(current != null){
            nextNode = current.next;
            while (nextNode != null){
                if(current.data > nextNode.data){
                    temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            current = current.next;
        }
        return this;
    }*/


    public void sort() {
        GenCompare<T> gen = new GenCompare<>();
        Boolean wasChanged;

        do {
            Node<T> current = head;
            Node<T> previous = null;
            Node<T> next = head.next;
            wasChanged = false;

            while (next != null) {
                if (gen.compare(current.data, next.data) > 0) {
                    wasChanged = true;
                    if (previous != null) {
                        Node temp = next.next;
                        previous.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        Node temp = next.next;
                        head = next;
                        next.next = current;
                        current.next = temp;
                    }
                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }

            }

        } while (wasChanged);
    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }

    public class GenCompare<T extends Comparable<T>> implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }
}


