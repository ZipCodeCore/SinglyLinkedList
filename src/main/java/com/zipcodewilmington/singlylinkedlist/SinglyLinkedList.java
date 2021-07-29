package com.zipcodewilmington.singlylinkedlist;


import sun.lwawt.macosx.CSystemTray;

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

    public void remove(Integer index) {  // REFACTOR TO RETURN TYPE VOID
        Node current = this.head;
        Node previous = null;

        if (index == 0 && current != null) { // [head] -> [current] -> [current.next] -> [tail]
            this.head = current.next;
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
        if(current == null) {
            System.out.println("not found");
        }
//        Node current = head;
//        Node nextPoint = head.next;
//        int tracker = 0;
//        if(index.equals(tracker)) {
//            head = current.next;
//            return;
//        }
//        tracker++;
//        while(true) {
//            tracker++;
//            current = nextPoint;
//            nextPoint = current.next;
//            if(index.equals(tracker)) {
//                current.next = nextPoint.next;
//                if(nextPoint.next == null) {
//                    current.next = null;
//                    tail = current;
//                }
//            }
//        }

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

    public Object find(Object data) {
        Node current = head;
        int index = 0;
            while (current != null) {
                if (current.data == data) {
                    return index;
                }
                index++;
                current = current.next;
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
        SinglyLinkedList newList = new SinglyLinkedList();
        Node current = head;
        while(current  != null) {
            newList.add(current.data);
            current = current.next;
        }
        return newList;
    }


    public void sort() {
        Node current = head;
        for(int i = 0; i < size(); i++) {
            while(current.next != null) {
                Node next = current.next;
                if((Integer) current.data > (Integer) next.data) {
                    Object temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                current = current.next;
            }
        }
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



