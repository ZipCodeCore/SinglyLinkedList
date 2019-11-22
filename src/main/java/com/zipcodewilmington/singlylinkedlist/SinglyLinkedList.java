package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    public Node head = null;    //SinglyLinkedList instance variables
    public Node tail = null;
    Integer listcount = 0;


    public class Node {         //Inner class that represents a node
        int data;
        Node next;
        Node previous;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    public void addNode(int data) {         //Adds a new node by creating one
        Node newNode = new Node(data);

        if (head == null) {       //basically says if there's only one node it's both the head and the tail
            head = newNode;
            tail = newNode;
            listcount = 1;
        } else {
            tail.next = newNode;        // the new node is now the tail if one already exists and the other tail variable
            tail = newNode;             //with the . is also now the end.
            listcount++;
        }
    }

    public Integer size () {
        return listcount;
    }

    public void removeNode (int index) {
        Node current = head;
        if(current == null){
            return;
        }
        else if (index == 0){
            current = current.next;
            listcount--;
        }
//        else if (index == this.size() - 1){
//            tail;
//        }
        int counter = 0;
            while (current != null){
                if(counter == index-1) {
                       current.setNext(current.getNext().getNext());
                    listcount--;
                    break;
                }
//                else if (counter == this.size() - 1) {
//                    current.setNext(null);
//                }

                current = current.next;
                counter++;

            }
        }

        public boolean contains (int data) {
        Node current = head;
        while(current != null){
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
        }

        public int find (int data) {
            Node current = head;
            int counter =0;
            while (current != null) {
                if (current.data == data ){
                    return counter;
                }
                current = current.next;
                counter++;
            }
            return -1;
        }

        public int get(int index) {
            Node current = head;
            int counter = 0;
            if (current == null) {
                return -1;
            }
            while (current != null) {
                if (counter == index) {
                    return current.data;
                }
                current = current.next;
                counter++;
            }
            return -1;
        }

    public SinglyLinkedList copy () {
        SinglyLinkedList myCopy = new SinglyLinkedList();
        Node current = this.head;
        while (current != null) {
            myCopy.addNode(current.data);
            current = current.next;
        }
        return myCopy;
    }

    public SinglyLinkedList sort () {
        Node current = head, nextNode = null;
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
        }

}



