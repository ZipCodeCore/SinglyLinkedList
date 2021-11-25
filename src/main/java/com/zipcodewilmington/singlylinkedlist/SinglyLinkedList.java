package com.zipcodewilmington.singlylinkedlist;


import jdk.nashorn.internal.ir.WhileNode;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T>> {

    public SinglyLinkedList() {
    }

    class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;


    public void add(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }


    public Integer size() {
        Node current = head;
        Integer counter = 0;
        while (current != null) {
            counter++;
            current = current.next;

        }
        return counter;
    }

    public Integer find(T data) {
        Node current = head;
        Integer index = 0;

        while (current != null) {
            if (current.data == data) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public Boolean contains(T data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


}
