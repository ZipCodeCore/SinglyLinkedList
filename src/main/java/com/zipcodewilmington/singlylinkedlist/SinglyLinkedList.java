package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    //Integer something;

    //public SinglyLinkedList(T object){this.object=object;}
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    //node head/tail=last and first element


    public void addNode(Object data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    public Integer nodeSize() {
        Integer count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Object find(Object data) {
        Integer index = 0;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public Boolean contains(Object data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void remove(Integer index, Object data) {
        index=nodeSize()-1;
        Node current = head;
        for (int i = 0; i < nodeSize(); i++) {
            while (i == index) {
                if (i != index) {
                    current = current.next;
                } else {

                }
                index++;
                current = current.next;
            }
        }
    }
}


