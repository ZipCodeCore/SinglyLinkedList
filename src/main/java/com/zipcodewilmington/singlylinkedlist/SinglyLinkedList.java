package com.zipcodewilmington.singlylinkedlist;

import javax.xml.soap.Node;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public SinglyLinkedList add(int data) {
        SinglyLinkedList list = new SinglyLinkedList();
        Node newNode = new Node(data);
        newNode.next = null;
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static SinglyLinkedList remove(int index) {
        SinglyLinkedList list = new SinglyLinkedList();
        Node current = list.head;
        Node previous = null;

        if (index == 0 && current != null) {
            list.head = current.next;

            return list;
        }

        int counter = 0;
        while (current != null) {
            if (counter == index) {
                previous.next = current.next;

                break;
            } else {
                previous = current;
                current = current.next;
                counter++;
            }
        }
        if (current == null) {
            System.out.println("not found");
        }
        return list;
    }

    public static Boolean contains(int key){
        SinglyLinkedList list = new SinglyLinkedList();
        Node current = list.head;
        while(current != null && current.next != null){
            if(current.data == key){
                return true;

            }
        }


return false;
    }
    public static int find(int index){

        return -1;
    }
}
