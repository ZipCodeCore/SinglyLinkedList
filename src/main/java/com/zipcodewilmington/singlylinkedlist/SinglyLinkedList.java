package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    private Node head;
    private static int counter;

    public SinglyLinkedList()
    {
        head = new Node(null);
        counter = 0;
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        }

        Node temp = new Node(data);
        Node current = head;

        if (current != null) {
            while (current.getNext() != null) {
                current = current.getNext();
            }

            current.setNext(temp);
        }

        counter++;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size())
            return false;

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;

                current = current.getNext();
            }

            current.setNext(current.getNext().getNext());

            counter--;
            return true;
        }
        return false;
    }

    public boolean contains(Object element) {
        int index = find(element);

        if(index > 0)
            return true;

        return false;
    }

    public int find(Object find){
        Node current = head;

        if (head != null) {
            for (int i = 0; i < counter; i++) {
                if (current.getNext().getData() == find)
                    return i;

                current = current.getNext();
            }
        }

        return -1;
    }

    public int size() {
        return counter;
    }

    public Object get(int index) {

        if (index < 0)
            return null;

        Node current = null;

        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }
            return current.getData();
        }

        return current;
    }

    public SinglyLinkedList copy(){
        SinglyLinkedList copy = this;

        return copy;
    }

    public String toString() {
        String output = "";

        if (head != null) {
            Node current = head.getNext();
            while (current != null) {
                output += "[" + current.getData() + "]";
                current = current.getNext();
            }
        }

        return output;
    }
}
