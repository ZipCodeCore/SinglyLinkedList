package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<AnyType> implements Cloneable {
    public class Node<AnyType> {


        AnyType data;
        Node<AnyType> next;

        public Node(AnyType data) {
            this.data = data;
            this.next = null;
        }

        public AnyType getData() {
            return data;
        }

        public Node<AnyType> getNext() {
            return next;
        }


        public void setNext(Node<AnyType> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "data = " + data + ", next = " + next + "}";
        }

    }
    private Node<AnyType> head=null;
    private Node<AnyType> tail;
    private Integer size;

    public SinglyLinkedList(AnyType data) {
        this.head = new Node<AnyType>(data);

        this.size = 0;
    }
    public SinglyLinkedList(){
        this.size =0;
    }
    public void add(AnyType data){


        if(head != null){
            Node current = head;

            while(current != null){
                if(current.getNext() == null){
                    current.setNext(new Node<AnyType>(data));
                    size++;
                    break;
                }
                current =current.getNext();

            }

        }
        else
        {
            this.head = new Node<AnyType>(data);
            size++;
        }
    }

    public Boolean remove(Integer index){
        Node current = this.head;
        Node previous = null;
        Integer counter = 0;

        while(current != null){
            if(index.equals(0)){
                this.head = current.getNext();
                size--;
                return true;
            }
            else if(counter == index - 1){

                previous.setNext(current.getNext());
                size--;
                return true;
            }
            counter++;
            previous = current;
            current = current.getNext();
        }
        return false;
    }
    public Boolean contains(AnyType data){
        Node current = this.head;

        while(current != null){
            if(current.getData() == data|| current.getNext() == data){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public Integer find(AnyType data){
        Node current = this.head;
        Integer index = 1;

        while(current != null){
            if(current.getData() == data){
                return index;
            }
            index++;
            current = current.getNext();
        }

        return -1;
    }

    public Object getByIndex(Integer index) {

        Node current = this.head;
        Integer currentIndex = 1;

        while(current != null){
            if(currentIndex.equals(index))
                return current.getData();

            current = current.getNext();
            currentIndex++;
        }

        return null;
    }

    public Node reverse(Node node){
        Node previous = null;
        Node current = this.head;
        Node next = current;

        while(current != null){
            next = next.getNext();
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Node getTail(){
        Node current = this.head;

        while(current != null){
            if(current.getNext() == null){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Node sort(){
        return null;
    }



    public Node<AnyType> getHead() {
        return head;
    }

    public void setHead(Node<AnyType> head) {
        this.head = head;
    }

    public Integer getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

}

