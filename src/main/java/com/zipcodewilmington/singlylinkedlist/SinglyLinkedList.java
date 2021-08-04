package com.zipcodewilmington.singlylinkedlist;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    static class Node {

        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void add(Object data) {

        // Creating a node with given data
        Node newNode = new Node(data);

        // If list is empty then make new node as head
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public void remove(int index) {
        Node current = this.head;
        Node previous = null;

        if (current == null) {
            throw new UnsupportedOperationException("Ain't nothing in the list!");
        }
        int trackIndex = 0;
        while (current != null) {
            if (trackIndex == index) {
                previous.next = current.next;
                break;
            } else {
                previous = current;
                current = current.next;
                trackIndex++;
            }
        }
    }

    public Boolean contains(Object key) {
        Node current = this.head;
        while (current != null) {
            if(current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Integer find(Object data) {
        Node current = this.head;
        int index = 0;
        while(current != null) {
            if (current.data.equals(data)){
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public int size() {
        int length = 0;
        Node current = this.head;

        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public Object get(int index) {
    Node current = this.head;
    int search = 0;
    while (current != null) {
        if (search == index) {
            return current.data;
        }
        search++;
        current = current.next;
    }
        return -1;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node current = this.head;
        while (current != null) {
            singlyLinkedList.add(current.data);
            current = current.next;
        }
        return singlyLinkedList;
    }

    public void sort() {
        Node current = this.head;
        for (int i = 0; i < size(); i++) {
            while (current.next != null) {
                Node next = current.next;
                if((Integer)current.data > (Integer)next.data) {
                    Object temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                current = current.next;
            }
        }
    }
}
