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
    public int numOfElements;

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

    }
//        Node current = head;
//
//        if (index == 0) {
//            head = current.next;
//            return;
//        }
//        int tracker = 0;
//        Node previousNode = head;
//        current = head.next;
//        while (current != null) {
//            if(tracker == index) {
//                previousNode.next = current.next;
//                return;
//            }
//            tracker++;
//            previousNode = current;
//            current = current.next;
//        }
//    }
//        SinglyLinkedList list = new SinglyLinkedList();
//        Node current = list.head;
//        Node previous = null;
//        if (index == 0 && current != null) {
//            list.head = current.next;
//            return (Integer) list.get(index);
//        }
//        int counter = 0;
//        while(current != null) {
//            if(counter == index) {
//                previous.next = current.next;
//                break;
//            } else {
//                previous = current;
//                current = current.next;
//                counter++;
//            }
//        }
//        if (current == null) {
//            return null;
//        }
//        return (Integer) list.get(index);
//    }


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
        int index = 1;
            while (current != null) {
                if (current.data == data) {
                    return index - 1;
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



