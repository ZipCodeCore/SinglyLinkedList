package com.patselasgreg;

public class LinkedList{

    private Node head;
    public static int size;

    public LinkedList(){
        this.head = new Node();
        this.size = 0;
    }

    public class Node{
        private int index;
        private int value;
        private Node next;

        public Node(){
            this.index = 0;
            this.next = null;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }
    }

    public Node getHead() {
        return head;
    }


    public void add(){

    }

    public void remove(){

    }

    public boolean contains(Node node){
        return false;
    }

    public int find(Node node){
        return -1;
    }

    public int size(){
        return 0;
    }

    public Node get(int index){
        return null;
    }

    public LinkedList copy(){
        return null;
    }

    public void sort(){

    }

}
