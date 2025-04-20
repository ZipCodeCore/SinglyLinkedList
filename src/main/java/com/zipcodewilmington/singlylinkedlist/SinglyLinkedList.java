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

    public Node<T> get(Integer index){

        Node current = head;
        Integer currentIndex = 0;

        while(currentIndex != index){
            current = current.next;
            currentIndex++;
        }
        return current;
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



    public void remove(Integer index) {
        Node current = this.head;
        Node previous = null;

        if (index == 0 && current != null) {
            this.head = current.next;
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
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        Node current = head;

        while(current != null) {
            newList.add((T) current.data);
            current = current.next;
        }
        return newList;
    }






    public void display() {

        Node current = head;
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        while(current != null) {

            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


}
