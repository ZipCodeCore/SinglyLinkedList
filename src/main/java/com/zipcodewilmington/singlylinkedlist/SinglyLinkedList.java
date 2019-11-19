package com.zipcodewilmington.singlylinkedlist;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    Node head = null;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    public void add(int data) {
        Node nh = head;
        if (nh == null) {
            head = new Node(data);
        } else {
            while (nh.next != null) {
                nh = nh.next;
            }
            nh.next = new Node(data);
        }
    }

    public void remove(int data) {
        Node nh = head;
        if (nh.data == data) {
            head = head.next;
        }
        while (nh.next != null) {
            if (nh.next.data == data) {
                nh.next = nh.next.next;
                return;
            }
            nh = nh.next;
        }
    }

    public Boolean contains(int data) {
        Node nh = head;
        while(nh != null) {
            if(nh.data == data) {
                return true;
            }
            nh = nh.next;
        }
        return false;
    }

    public int find(int data){
        Node nh = head;
        int currIndex = 1;
        while(nh != null){
            if(nh.data == data){
                return currIndex;
            }
            currIndex++;
            nh = nh.next;
        }
        return currIndex;
    }

    public int size(){
        Node nh = head;
        int sizeOfNode = 0;
        while (nh != null){
            sizeOfNode++;
            nh = nh.next;
        }
        return sizeOfNode;
    }

    public int get(int index){
        Node nh = head;
        int currIndex = 1;
        while (nh != null){
            if(currIndex == index){
                return nh.data;
            }
            currIndex++;
            nh = nh.next;
        }
        return currIndex;
    }

    public SinglyLinkedList copy(){
        SinglyLinkedList sllCopy = new SinglyLinkedList();
        Node nh = head;
        while(nh != null){
            sllCopy.add(nh.data);
            nh = nh.next;
        }
        return sllCopy;
    }

    public void sort() {
        Node nh = head, index;
        int temp;
        while(nh != null){
            index = nh.next;
            while(index != null){
                if (nh.data > index.data){
                    temp = nh.data;
                    nh.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            nh = nh.next;
        }
    }
    // https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/ structure of nodes
//https://stackoverflow.com/questions/16033800/bubble-sort-implementation-on-linked-lists bubble sort
}
