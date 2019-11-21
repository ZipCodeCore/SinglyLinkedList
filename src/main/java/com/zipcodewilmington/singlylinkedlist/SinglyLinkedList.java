package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    //represents a node of the singly linked list
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    //addNode will add node to a list
    public void addNode(int data) {
        //create a new node
        Node newNode = new Node(data);

        //checks if the list is empty
        if (head == null) {
            //if the list is empty both head and tail will point to the same node
            head = newNode;
            tail = newNode;
        } else {
            //new node will be added after a tail such that tail's next will be point to newNode
            tail.next = newNode;
            //new node will become a new tail of the list
            tail = newNode;
        }

    }
LinkedList list=new LinkedList();
    public void add(Node node){
        list.add(node);

    }
    public void remove(Node node){
        list.remove(node);
    }


}

