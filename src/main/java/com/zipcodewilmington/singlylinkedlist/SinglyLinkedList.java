package com.zipcodewilmington.singlylinkedlist;


import sun.jvm.hotspot.StackTrace;

/**
 * Created by leon on 1/10/18.
 */

public class SinglyLinkedList {

    class Node{
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(Object data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public int size() {
        int count = 0;
        Node current = head;

        while(current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void display() {
        Node current = head;
        checkListEmpty("There's no list, idiot.");
        System.out.println("Nodes of singly linked list:");
        while(current != null) {
            System.out.println(current.data + "");
            current = current.next;
        }
    }

    // returning new SinglyLinkedList - there is a way to stitch two nodes together
    public SinglyLinkedList remove(Object data) {
        SinglyLinkedList result = new SinglyLinkedList();
        Node current = head;
        checkListEmpty("There's no list, dummy");
        while(current != null) {
            if(current.data != data) {
                result.addNode(current.data);
            }
            current = current.next;
        }
        return result;
    }

    private void checkListEmpty(String s) {
        if (head == null) {
            throw new UnsupportedOperationException(s);
        }
    }

    public Boolean contains(Object data) {
        Node current = head;
        checkListEmpty("This list empty, doood");
        while(current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }
//        if(find(data).equals(data)) {
//            return true;
//        }
        return false;
    }

    public int find(Object data) {
        Node current = head;
        int theIndex = 0;
        if (head == null) {
            System.out.println("List is empty");
        }
        while(current != null) {
            if(current.data == data) {
                return theIndex;
            }
            theIndex++;
            current = current.next;
        }
        return -1;
    }

    public Object get(double index) {
        Node current = head;
        int theIndex = 0;
        if (head == null || index > size() || index < 0) {
            throw new UnsupportedOperationException("You doin' something wrong, buckaroo");
        }
        while(current != null) {
            if (theIndex == index) {
                return current.data;
            }
            theIndex++;
            current = current.next;
        }
        return -1;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList newList = new SinglyLinkedList();

        Node current = head;
        checkListEmpty("List don't be there, my guy");
        while (current != null) {
            newList.addNode(current.data);
            current = current.next;
        }
        return newList;
    }


    public void sortLeastToGreatest() {
        Node current = head;
        checkListEmpty("Where's the car fax?");
        for (int i = 0; i < size(); i++) {
            current = head;
            while (current.next != null) {
                Node next = current.next;
                if ((Integer) current.data > (Integer) next.data) {
                    Object temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                current = current.next;
            }
        }
    }
    public SinglyLinkedList reverse () {
        SinglyLinkedList resultList = new SinglyLinkedList();
        Integer i = size() - 1;
        checkListEmpty("You ain't got one of them lists, buckaroo");
        while(i >= 0) {
            resultList.addNode(get(i));
            i--;
        }
        return resultList;
    }

    public SinglyLinkedList splice (Integer beginningIndex, Integer endingIndex) {
        Node current = head;
        Integer index = 0;
        SinglyLinkedList result = new SinglyLinkedList();
        checkListEmpty("Where's the car fax?");
        while(current != null) {
            if (index >= beginningIndex && index <= endingIndex) {
                result.addNode(current.data);
            }
            index++;
            current = current.next;
        }
        return result;
    }

    public void sortGreatestToLeast () {
        sortLeastToGreatest();
        reverse().display();
    }
}
