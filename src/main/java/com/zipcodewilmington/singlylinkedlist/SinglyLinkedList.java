package com.zipcodewilmington.singlylinkedlist;



/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
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

    public void add(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;

        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public Object remove(Integer index) {  // REFACTOR TO RETURN TYPE VOID
        SinglyLinkedList list = new SinglyLinkedList();
        Node current = list.head;
        Node previous = null;
        if (index == 0 && current != null) {
            list.head = current.next;
            return list;
        }
        int counter = 0;
        while(current != null) {
            if(counter == index) {
                previous.next = current.next;
                break;
            } else {
                previous = current;
                current = current.next;
                counter++;
            }
        }
        if (current == null) {
            return -1;
        }
        return list;
    }


    public Boolean contains(Object data) {
        Node current = head;
        while (current != null) {
            if (current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Object find(Object data) {  // NOT WORKING
        Node current = head;
        int index = 1;
        boolean flag = false;
        if (head == null) {
            return -1;
        } else {
            while (current != null) {
                if (current.data == data) {
                    flag = true;
                }
                index++;
                current = current.next;
            }
        }
        if (flag) {
            return index;
        }
        return -1;
    }


    public Integer size() {
        Integer counter = 0;
        Node current = head;
        while (current != null) {
            counter++;
            current = current.next;
        }
        return counter;
    }

    public Object get(Integer index) {
        Node current = head;
        int counter = 0;
        while(current != null) {
            if (counter == index) {
                return current.data;
            }
            counter++;
            current = current.next;
        }
        return -1;
    }

    public SinglyLinkedList copy() {
        return null;
    }

    public void sort() {

    }

}


//<SomeType extends Comparable<SomeType>>{


//    class Node {
//        SomeType data;
//        Node next;
//
//        public Node(SomeType data) {
//            this.data = data;
//            this.next = null;
//        }
//    }
//
//    public Node head = null;
//    public Node tail = null;
//
//    public void add(SomeType data) {
//        Node newNode = new Node(data);
//        if(head == null) {
//            head = newNode;
//
//        } else {
//            tail.next = newNode;
//        }
//        tail = newNode;
//    }
//
//    public void remove(SomeType data) {
//        Node newNode = new Node(data);
//
//    }



