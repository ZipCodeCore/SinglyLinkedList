package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    class Node{
        Integer data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
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
        if (head == null) {
            System.out.println("The list is empty");
        }
        System.out.println("Nodes of singly linked list:");
        while(current != null) {
            System.out.println(current.data + "");
            current = current.next;
        }
    }

    // My remove method can set the value to null (practically removing it lol)
    public void remove(int data) {
        Node current = head;
        if(head == null) {
            throw new UnsupportedOperationException("There's no list, dummy");
        }
        while(current != null) {
            if(current.data == data) {
                current.data = null;
            }
            current = current.next;
        }
    }

    public Boolean contains(int data) {
        Node current = head;
        if (head == null) {
            throw new UnsupportedOperationException("This list empty, doood");
        }
        while(current != null) {
            if(current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int find(int data) {
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

    public Integer get(double index) {
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
        if (head == null) {
            throw new UnsupportedOperationException("List don't be there, my guy");
        }
        while (current != null) {
            newList.addNode(current.data);
            current = current.next;
        }
        return newList;
    }

    public void sortLeastToGreatest() {
        // my code only swaps the first and second value given that they meet requiements
        Node current = head;
        Node next = current.next;
        if (head == null) {
            throw new UnsupportedOperationException("Where's the car fax?");
        }
        int i = 0;
        while(i < size() * size()) {
            if (current == null) {
                current = head;
            } else if (current.data > next.data) {
                Integer temp = current.data;
                current.data = next.data;
                next.data = temp;
            }
            i++;
            current = current.next;
        }
    }
    public SinglyLinkedList reverse () {
        SinglyLinkedList resultList = new SinglyLinkedList();
        Integer i = size() - 1;
        if (head == null) {
            throw new UnsupportedOperationException("You ain't got one of them lists, buckaroo");
        }
        while(i >= 0) {
            resultList.addNode(get(i));
            i--;
        }
        return resultList;
    }
}
