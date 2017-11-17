package com.patselasgreg;

public class LinkedList{

    public Node head = null;
    public Node tail = null;

    public LinkedList(){
    }

    public void add(int value) {
        Node add = new Node(value);
        if(head == null){
            head = add;
            tail = add;
        } else{
            tail.next = add;
            tail = add;
        }
    }

    public Node getHead() {
        return head;
    }

    public void remove(int value){
        Node helper;
        helper = head;
        while(helper.next != null){
            if(helper.next.getValue() == value ){
                helper.next = helper.next.next;
            }else{
                helper = helper.next;
            }
        }


    }

    public boolean contains(Node node){
        Node helper;
        helper = head;
        while(helper.next !=null){
            if(helper.next== node){
                return true;
            }
        }
        return false;
    }

    public int find(Node node){
        return -1;
    }

    public int size(){
        Node helper;
        helper = head;
        int size=1;
        while (helper.next != null){
            helper = helper.next;
            size++;

        }
        return size;
    }

    public Node get(int value) {
        Node helper;
        helper = head;
        while (helper.next != null) {
            if (helper.next.getValue() == value) {
                return helper.getNext();
            } else {
                helper = helper.next;
            }

        }return null;
    }

    public LinkedList copy(){
        return null;
    }

    public void sort(){

    }

    public class Node{
        private int value;
        private Node next;

        public Node(){
            this.value =0;
            this.next = null;
        }
        public Node(int value){
           this.value = value;
           this.next = null;
        }



        public void setNext(Node node){
            this.next = next;
        }

        public int getValue() {
            return value;
        }


        public Node getNext() {
            return next;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}


