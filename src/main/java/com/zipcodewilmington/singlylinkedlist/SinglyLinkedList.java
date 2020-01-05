package com.zipcodewilmington.singlylinkedlist;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T> implements Cloneable, Comparable {
    public int compareTo(Object o) {
        return 0;
    }

    //represents a node of the singly linked list
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node<T> getNext() {
            return next;
        }


        public void setNext(Node<T> node) {
            this.next = node;
        }

        @Override
        public String toString() {
            return "Node{" + "data = " + data + ", next = " + next + "}";
        }
    }


    public Node<T> head = null;
    public Node<T> tail = null;
    Integer size = 0;

    public SinglyLinkedList() {
        this.head = head;
    }


    public void add(T data) {
        Node<T> current = head;

        if (current == null) {
            this.head = new Node<T>(data);
            size++;
        } else {
            while (current != null) {
                if (current.getNext() == null) {
                    current.setNext(new Node<T>(data));
                    size++;
                    break;
                }
                current = current.getNext();
            }

        }

    }


    public void remove(T data) {
        Node<T> current = head;
        if (current.getData() == data && current.getNext() == null) {
            head = null;
            size--;
        } else {
            while (current != null) {
                if (current.getNext().getData() == data) {
                    current.setNext(current.getNext().getNext());
                    size--;
                    break;
                }
                current = current.getNext();
            }
        }
    }

    public boolean contains(T data) {
        Node<T> current = head;


        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            } else {
                current = current.getNext();
//                System.out.println("my current is " + current);
            }
        }
        return false;
    }

    public Integer find(T data) {
        int counter = 0;
        Node<T> current = head;

        while (current != null) {
            if (current.getData().equals(data)) {
                return counter;
            } else {
                counter++;
                current = current.getNext();
                //System.out.println("my current is "+current);
            }
        }
        return -1;

    }

    public Integer size() {
        int counter = 0;
        Node<T> current = head;
        while (current != null) {
            counter++;
            current = current.getNext();


        }
        return counter;
    }

    public T findByIndex(Integer index) {
        Node<T> current = head;
        Integer currentIndex = 0;

        while (current != null) {
            if (currentIndex.equals(index))
                return current.getData();
            else {
                current = current.getNext();
                currentIndex++;
            }

        }
        return null;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        Node current = this.head;

        while (current != null) {
            if (current.getNext() == null) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Node<T> reverse(Node<T> node) {
        Node previous = null;
        Node current = this.head;
        Node next = current;

        while (current != null) {
            next = next.getNext();
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }


    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

}

