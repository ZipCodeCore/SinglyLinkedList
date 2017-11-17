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

    public boolean contains(int value) {
        Node helper;
        helper = head;
        while (helper.next != null) {
            if(helper.next.getValue() ==value){
                return true;
            }
            helper = helper.next;
        }return false;
    }


    public int find(int value){
        Node helper;
        helper = head;
        int index =1;
        if(head.getValue() == value){
            return 0;
        }
        while(helper.next !=null){
            if(helper.next.getValue() == value){
                return index;
            }
            helper = helper.next;
            index++;
        }
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

    public Node get(int index) {
        Node helper;
        helper = head;
        int currentIndex = 0;
        while (helper.next != null) {
            if (currentIndex == index) {
                return helper;
            } else {
                helper = helper.next;
                currentIndex++;
            }


        }
        if(currentIndex == index){
            return helper;
        }
        return null;
    }

    public LinkedList copy(){
        Node helper;
        helper = head;

        LinkedList copy = new LinkedList();

        while(helper.next != null){

            copy.add(helper.getValue());

            helper = helper.next;
        }

        return copy;

    }

    public void sort(){
        Node helper;
        Node helper2;
        helper = head;
        helper2 = head;
        int swap;
        int currentValue;
        int nextValue;

        while(helper2.next != null) {

            while (helper.next != null) {
                currentValue = helper.getValue();
                nextValue = helper.next.getValue();

                if (nextValue < currentValue) {
                    swap = currentValue;
                    helper.setValue(nextValue);
                    helper.next.setValue(swap);
                }
                helper = helper.next;


            }
            helper = head;
            helper2 = helper2.next;
        }
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


