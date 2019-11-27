package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    private Node head;
    private static int counter;
    private Node temp;

    public SinglyLinkedList() {
        head = new Node(null);
        counter = 0;
    }

    public void add(Object element) {

        if (head.getData() == null)
            head = new Node(element);

        else {
            temp = new Node(element);
            Node current = head;

            if (current.getData() != null) {
                while (current.getNext() != null)
                    current = current.getNext();

                current.setNext(temp);
            }
        }

        counter++;
    }

    public boolean remove(int index) {

        if (index < 0 || index > size() || head.getData() == null)
            return false;


        if (index == 0)
            head = head.getNext();

        else if (index == size() - 1)
            get(index - 1).setNext(null);

        else {
            Node current = get(index - 1);
            current.setNext(current.getNext().getNext());
        }

        counter--;
        return true;
    }

    public boolean contains(Object element) {
        int index = find(element);

        if(index != -1)
            return true;

        return false;
    }

    public int find(Object find){
        Node current = head;

        if (current.getData() != null) {
            for (int i = 0; i < counter; i++) {
                if (current.getData() == find)
                    return i;

                current = current.getNext();
            }
        }

        return -1;
    }

    public int size() {
        return counter;
    }

    public Node get(int index) {

        if (index < 0)
            return null;

        Node current = head;

        if (current.getData() != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return null;

                current = current.getNext();
            }

            return current;
        }

        return null;
    }

    public SinglyLinkedList copy(){
        SinglyLinkedList copy = this;

        return copy;
    }

    public String toString() {
        String output = "";
        Node current = head;

        if (current.getData() != null) {
            while (current != null) {
                output += "[" + current + "]\n";
                current = current.getNext();
            }
        }

        return output;
    }

    public void print() {
        Node current = head;
        if (current.getData() != null) {
            for (int i = 0; i < size()-3; i++) {
                System.out.println(current.getNext().getNext().getNext().getData());

                current = current.getNext();

            }
        }
    }
}
