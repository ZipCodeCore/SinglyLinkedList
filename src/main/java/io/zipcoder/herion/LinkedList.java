package io.zipcoder.herion;

import java.util.NoSuchElementException;


// This is a solution to a lab given early on in the Zip Code Course in which the requirement was to create a singly-linked
//list functionality (with certain prescribed methods) from scratch

public class LinkedList<E extends Comparable<E>> {


    int listSize;
    Node head;
    Node tail;


    public LinkedList() {

        this.listSize = 0;
        this.head = null;
        this.tail = null;

    }

    public Node<E> add(E val) {

        Node newNode = new Node(null, val);

        //if no head already exists set newNode to be head & tail being that it is the only element in the list\
        //otherwise make a new node and set it to the head
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.setNextNode(head);
            head = newNode;
        }
        listSize++;
        return newNode;
    }

    //this overloaded add method - which takes a Node instead of val - is solely for use with the...
    //copy method further below
    public Node<E> add(Node<E> nodeToAdd) {

        if (head == null) {
            head = nodeToAdd;
            tail = head;
        } else {
            nodeToAdd.setNextNode(head);
            head = nodeToAdd;
        }
        listSize++;
        return nodeToAdd;
    }

    public void remove(int index) {

        //if no node exists or index entered is invalid respective to linked list size throw appropriate exceptions
        if (head == null)
            throw new NoSuchElementException("There are no elements to remove from this linked list");
        if (index < 0 || index > listSize)
            throw new IndexOutOfBoundsException("Supplied invalid index");

        Node removeNode = head;
        //start at head and loop through until index input is reached, with each iteration move to next node...
        for (int i = 1; i < index - 1; i++) {
            removeNode = removeNode.nextNode;

        }
        //With this linked list's implementation each nodes' data only 'lives' b/c of it's reference to the previous node...
        //therefore, we point the node to be removed to reference of next, next node for two reasons: 1) it will
        //cause the node that we want to remove to no longer have a reference (garbage collected/removed), 2)...
        //retains the reference from previous node to new next node after removal so as not to break the linked list
        removeNode.setNextNode(removeNode.nextNode.nextNode);
        listSize--;
    }

    public int find(E val) {

        Node nodeToFind = head;
        int returnIndex = -1;

        if (head == null)
            throw new NoSuchElementException("There are no elements to find in this linked list");
        //loop through list, with each iteration jump to next node, it getVal retrieves val passed in then return it
        //and break loop, otherwise return -1 (to be used in contains method)
        for (int i = 1; i <= listSize; i++) {
            if (nodeToFind.getVal() == val) {
                returnIndex = i;
                break;
            }
            nodeToFind = nodeToFind.nextNode;
        }
        return returnIndex;
    }

    public boolean contains(E val) {

        if (head == null)
            throw new NoSuchElementException("The linked list has no contents");
        //use find method above to look up val, returnIndex of find() (intentionally initialized at -1 for this method)
        //returns -1 then val not found, ergo linked list also does not contain it... otherwise it does.
        if (this.find(val) != -1) {
            return true;
        } else
            return false;
    }


    public int size() {

        listSize = 0;

        while (head != null) {
            head = head.nextNode;
            listSize++;

        }
        return listSize;
    }

    public Node<E> get(int index) {

        Node nodeToGet = head;

        if (head == null)
            throw new NoSuchElementException("There are no elements to retrieve from this linked list");
        if (index < 0 || index > listSize)
            throw new IndexOutOfBoundsException("Supplied invalid index");
        for (int i = 1; i < index; i++) {
            nodeToGet = nodeToGet.nextNode;
        }
        return nodeToGet;
    }


    public LinkedList copy() {

        LinkedList linkListCopy = new LinkedList();
        //set head and tail of list original linked list to linked list to be copied to establish copy's start and end
        linkListCopy.head = this.head;
        linkListCopy.tail = this.tail;

        if (head == null)
            throw new NoSuchElementException("There are no elements in this linked list to copy");
        //loop backwards through list (necessary to get proper copy order because positions in this linked list are
        //in descending order... then call get method on origin node and pass the node of current iteration, set to
        //currentNode and add (with special overloaded add method) this node to the copy list with each iteration
        for (int i = listSize; i >= 1; i--) {
            Node currentNode = this.get(i);
            linkListCopy.add(currentNode);
        }
        return linkListCopy;
    }

    @Override
    public String toString() {
        String toPrint = "";
        for (int i = 0; i < this.listSize; i++) {
            toPrint += this.get(i).val;
        }
        return toPrint;
    }


    public LinkedList sort() {

        LinkedList listToSort = this.copy();

        if (head == null)
            throw new NoSuchElementException("No elements to be sorted within linked list");
        if (listSize == 1)
            throw new NoSuchElementException("The linked list only contains one element... cannot sort");
        int n = listToSort.listSize;
        E placeHolder;
        //modified 'bubble sort' algorithm utilizes nested loops to iterate through values of each position and...
        //compare one to the next, then switch references for next comparison while placeHolder
        // keeps previous reference intact... shuffle down the list in this manner to sort by value
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (listToSort.get(j - 1).val.toString().compareTo(listToSort.get(j).val.toString()) > 0) {
                    placeHolder = (E) listToSort.get(j - 1).val;
                    listToSort.get(j - 1).val = listToSort.get(j + 1).val;
                    listToSort.get(j).val = placeHolder;

                }
            }
        }
        return listToSort;
    }


    public class Node<E> extends LinkedList {

        private Node nextNode;
        private E val;


        public Node(Node nextNode, E val) {

            this.nextNode = nextNode;
            this.val = val;

        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }
    }
}


