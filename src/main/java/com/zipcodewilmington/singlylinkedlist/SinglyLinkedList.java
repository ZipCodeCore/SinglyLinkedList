package com.zipcodewilmington.singlylinkedlist;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    class Node {
        Object data;
        Node next;

        public Node(Object data){
            this.data = data;
            next = null;
        }
    }

    public Node head;
    public Node tail;

    public void add(Object data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void remove(int index){
        Node current = this.head;
        Node previous = null;

        if (index == 0 && current != null){
            this.head = current.next;
        }
        int counter = 0;
        while (current != null) {
            if(counter == index){
                previous.next = current.next; //[previous] -> [current.next]
                break;
            } else {
                previous = current;
                current = current.next;
                counter++;
            }
        }
        if (current == null){
            System.out.println("not found");
        }
    }

    public Boolean contains(Object key){
        Node current = this.head;
        while (current != null) {
            if (current.data == key){
                return true;
            }
            current = current.next;
        }
        return  false;
    }

    public int size(){
        int counter = 0;
        Node current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    public Integer find(int data){
        Node current = this.head;
        int index = 0;
        while(current != null){
            if(current.data.equals(data)){
                return  index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public Object get(int index){
        Node current = this.head;
        int seek = 0;
        while(current != null){
            if(seek == index){
                return current.data;
            }
            seek++;
            current = current.next;
        }
        return -1;
    }

    public SinglyLinkedList copy(){
        SinglyLinkedList copiedList = new SinglyLinkedList();
        Node current = this.head;
        while(current != null){
            copiedList.add(current.data);
            current = current.next;
        }
        return  copiedList;
    }

    public void sort(){
        Node current = this.head;
        for(int i =0; i < size(); i++){
            while(current.next != null){
                Node next = current.next;
                if((Integer)current.data > (Integer) next.data){ // [head] -> [current] -> current.next] -> [tail] -> [null]
                    Object temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                current = current.next;
            }
        }
    }
}
