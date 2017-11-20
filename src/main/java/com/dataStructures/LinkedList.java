package com.dataStructures;

import java.util.Iterator;

public class LinkedList<X extends Comparable<X>>{
    private Node head;
    int listSize = 0;

    /******** Add at the end of the list ******/
    public void addAtTheEnd(X n){
        Node newNode = new Node(n);
        Node current = head;

        if(head == null){
            head = newNode;
            listSize++;
        }
        else {
            Node currentNode = head;
            while (currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
            listSize++;
        }
    }
    /******* ADD AT THE FRONT OF THE LIST ***********/
    public void  addAtTheFront(X n){
        Node newNode = new Node(n);
        if(head == null){
            head = newNode;
            listSize++;
        }
        else {
            newNode.setNext(head);
            head = newNode;
            listSize++;
        }
    }
    /******** ADD NODE AT THE GIVEN INDEX ******/
    public void insertIntoIndex(X n,int position){
        if (position>listSize){
            throw new IllegalStateException("List size is smaller than the index");
        }
        Node currentNode = head;
        int count = 1;
        while (count < position ){
            currentNode = currentNode.getNext();
            count++;
        }
        Node newNode = new Node(n);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
        listSize++;
    }
    /******* TO PRINT THE SIZE AND NODES OF THE LIST ******/
    public int size(){
        if(head == null)
            throw new NullPointerException("Empty list");
        int count = 1;
        Node currentNode = head;
        while (currentNode.getNext() != null){
            System.out.println(currentNode.data);
            currentNode = currentNode.getNext();
            count++;
        }
        System.out.println(currentNode.data);
        System.out.println("List count = "+listSize);
        return count;
    }

    /********** REMOVE THE NODE FROM THE GIVEN INDEX *******/

    public Node removeFromIndex(int position){
        Node nodeToDelete = null;
        if(position>listSize){
            throw new IllegalStateException("List size is smaller than the given position");
        }
        else {
            Node currentNode = head;
            int count = 1;
            while (count < position){
                currentNode = currentNode.getNext();
                count++;
            }
            nodeToDelete = currentNode.getNext();
            currentNode.setNext(nodeToDelete.getNext());
            listSize--;
        }
    return nodeToDelete;
    }
    /************* TO CHECK WHETHER THE ELEMENT IS PRESENT IN THE LIST RETURN TRUE IF YES ELSE FALSE ***********/

    public boolean contains(X data){
        if(listSize == 0)
            return false;
        else {
            Node currentNode = head;
            while(currentNode.data != null){
                if(currentNode.data == data)
                    return true;
                else
                    currentNode = currentNode.getNext();
            }
        }
        return false;
    }
    /************* TO CHECK WHETHER THE ELEMENT IS PRESENT IN THE LIST IF YES RETURN INDEX ELSE RETURN -1 ***********/
    public int find(X data){
        int count = 0;
        if(listSize == 0)
            return -1;
        else {
            Node currentNode = head;
            while(currentNode.data != null){
                if(currentNode.data == data)
                    return count;
                else {
                    currentNode = currentNode.getNext();
                    count++;
                }
            }
        }
        return -1;
    }
    /******** RETURNS THE ELEMENT FROM THE SPECIFIED INDEX  **********/
    public X get(int position){
        int count = 0;
        if(listSize == 0)
            throw new IllegalStateException("Empty List");
        else {
            Node currentNode = head;
            while(currentNode.data != null){
                if(count == position)
                    return currentNode.data;
                else
                    currentNode = currentNode.getNext();
                count++;
            }
        }
        return null;
    }
    /******** COPY OF THE LIST  **********/
    public LinkedList<X> copy(){
        LinkedList<X> copyList = new LinkedList<X>();
        Node current = head;
        while (current.next != null){
            copyList.addAtTheEnd(current.getData());
            current = current.getNext();
        }
        copyList.addAtTheEnd(current.getData());
        return copyList;
    }
    /******** SORT THE LIST  **********/
    public void sort(){
        Node currentNode = head;
        Node nextNode = currentNode.getNext();
        X temp;
        while(currentNode.getNext() != null){
            while ((nextNode != null)){
                if(currentNode.getData().compareTo(nextNode.getData()) > 0){
                    temp = nextNode.getData();
                    nextNode.setData(currentNode.getData());
                    currentNode.setData(temp);
                }
                nextNode = nextNode.getNext();
            }
            currentNode = currentNode.getNext();
            nextNode = currentNode.getNext();
        }

    }
    public String toString() {
        String result = "";
        Node currentNode = head;
        while(currentNode.getNext() != null){
            result += currentNode.data + ", ";
            currentNode = currentNode.getNext();
        }
        result+=currentNode.getData();
        return "List: " + result;
    }


    /******** INNER CLASS TO CREATE NEW NODE  **********/
    public class Node {
        private X data;
        private Node next;

        public Node(X data) {
            this.data = data;
            this.next = null;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public X getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(X data) {
            this.data = data;
        }


    }

}
