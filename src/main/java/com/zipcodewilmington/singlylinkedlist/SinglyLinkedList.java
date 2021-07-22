package com.zipcodewilmington.singlylinkedlist;

import javax.xml.soap.Node;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int size() {
        int count = 0;
        Node current = head;

        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("The list is empty");
        }
        System.out.println("Nodes of singly linked list:");
        while(current != null) {
            System.out.println(current.data + "");
            current = current.next;
        }
    }

    // My remove method can set the value to 0 (practically removing it lol)
    public void remove(int data) {
        Node current = head;
        if(head == null) {
            System.out.println("There's no list");
        }
        while(current != null) {
            if(current.data == data) {
                current.data = 0;
            }
            current = current.next;
        }
    }

    public Boolean contains(int data) {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
        }
        while(current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int find(int data) {
        Node current = head;
        int theIndex = 0;
        if (head == null) {
            System.out.println("List is empty");
        }
        while(current != null) {
            if(current.data == data) {
                return theIndex;
            }
            theIndex++;
            current = current.next;
        }
        return -1;
    }

    public int get(int index) {
        Node current = head;
        int theIndex = 0;
        if (head == null) {
            System.out.println("List is empty");
        } else if (index > size()) {
            System.out.println("List aint big enough");
        } else if (index < 0) {
            System.out.println("That doesn't exist");
        }
        while(current != null) {
            if (theIndex == index) {
                return current.data;
            }
            theIndex++;
            current = current.next;
        }
        return -1;
    }
}
