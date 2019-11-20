package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    public Node head = null;    //SinglyLinkedList instance variables
    public Node tail = null;
    Integer listcount = 0;


    public class Node {         //Inner class that represents a node
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data) {         //Adds a new node by creating one
        Node newNode = new Node(data);

        if (head == null) {       //basically says if there's only one node it's both the head and the tail
            head = newNode;
            tail = newNode;
            listcount = 1;
        } else {
            tail.next = newNode;        // the new node is now the tail if one already exists and the other tail variable
            tail = newNode;             //with the . is also now the end.
            listcount++;
        }
    }

    public Integer size () {
        return listcount;
    }

    public void removeNode (int index) {
        Node current = head;
        int counter = 0;
//        if (index == 0) {
//            head = head.next;   //if the index is at 0 we skip that first element and then the next one after the head is the next
//        } else {
//            for (int i = 0; i < index - 1; i++) {   //go to index - 1 because we have to skip one to continue on
//                current = current.next;
//            }
//            current.next = current.next.next;
//        }

            while (current != null){
                if(counter == index-1) {
                    current = current.next;
                    listcount--;

                }
                current = current.next;
                counter++;

            }
        }

        public boolean contains (int data) {
        Node current = head;
        while(current != null){
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
        }

        public int find (int data) {
            Node current = head;
            int counter =0;
            while (current != null) {
                if (current.data == data ){
                    return counter;
                }
                current = current.next;
                counter++;
            }
            return -1;
        }

        public int get(int index) {
            Node current = head;
            int counter = 0;
            if (current == null) {
                return -1;
            }
            while (current != null) {
                if (counter == index) {
                    return current.data;
                }
                current = current.next;
                counter++;
            }
            return -1;
        }

    public SinglyLinkedList copy (){
        SinglyLinkedList myCopy = new SinglyLinkedList();
        Node current = head;
        while(current != null){
            myCopy.addNode(current.data);
            current = current.next;
        }
        return myCopy;
    }



//            if (current == null) {
//                for (current; x != null; x = x.next) {
//                    if (x.item == null)
//                        return index;
//                    index++;
//                }
//            } else {
//                for (LinkedList.Node<E> x = first; x != null; x = x.next) {
//                    if (o.equals(x.item))
//                        return index;
//                    index++;
//                }
//            }
//            return -1;


//            while (current != null){
//               // if (find(data) ){
//
//                }
//            return -1;
//            }




    public void display (){  //displays all the nodes that are present in the list
        Node current = head;

       while (current != null){
           System.out.println();
        }
    }

}



