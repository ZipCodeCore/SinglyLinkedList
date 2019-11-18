package com.zipcodewilmington.singlylinkedlist;



/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    Node head = null;

    public class Node{
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

}
