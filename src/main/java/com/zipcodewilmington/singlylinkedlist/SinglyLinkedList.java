package com.zipcodewilmington.singlylinkedlist;

import java.lang.annotation.Target;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {
    //Integer something;

    //public SinglyLinkedList(T object){this.object=object;}
    class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    //node head/tail=last and first element


    public void addNode(Object data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
    }

    public Integer nodeSize() {
        Integer count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Object find(Object data) {
        Integer index = 0;
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public Boolean contains(Object data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public SinglyLinkedList remove(Integer index) {
        SinglyLinkedList singlyLinkedList= new SinglyLinkedList();
        Integer indexOfNode=0;
        Node current = head;
        while(current!=null){
            if(index!=indexOfNode){
            singlyLinkedList.addNode(current.data);
            }
            indexOfNode++;
            current = current.next;
        }
        return singlyLinkedList;
    }


    public SinglyLinkedList copy() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Node current = head;
        while (current!=null) {
            singlyLinkedList.addNode(current.data);
            current = current.next;
        }
        return singlyLinkedList;
    }

    public  void sort(){
        Node current=head;
        for(int i=0;i<nodeSize();i++){
            current=head;
            while(current.next!=null){
                Node next= current.next;
                if((Integer)current.data > (Integer)next.data){
                    Object temp=current.data;
                    current.data=next.data;
                    next.data=temp;
                }
                current=current.next;
            }
        }
    }
}


