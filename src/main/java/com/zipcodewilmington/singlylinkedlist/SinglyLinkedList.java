package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList <T>{

    private MyNode head;
    private MyNode nextNode;
    private int size;
    private int index = 0;


    public SinglyLinkedList() {
        this.size = 0;
    }


    public void addItem(T value) {
        MyNode newNode;
        if (this.size ==0){
             newNode = new MyNode(this.head, value);
            this.head = newNode;
        } else {
            newNode = new MyNode(null,value);
            setNextNodeForPreviousNode(newNode);
        }
        this.nextNode = null;
        this.size++;
    }

    public T getValue(int index){
        if (index > this.size){
            throw new IndexOutOfBoundsException();
        }

        MyNode currentNode = this.head;
        int i = 0;
        while (currentNode != null){
            if (i == index) return (T) currentNode.getNodeValue();
            currentNode = currentNode.getNextNode();
            i++;
        }

        return null;
    }

    public Integer getSize(){
        return this.size;
    }

    public Boolean contains (T value){

        int i = 0;
        index = 0;

        MyNode currentNode = this.head;
        while (currentNode != null){
            if (currentNode.getNodeValue().equals(value)){
                index = i;
                break;
            }

            currentNode = currentNode.getNextNode();
            i++;
        }

        return index > 0;
    }

    public Integer find (T value){

        if (contains(value)) return index;
        return -1;
    }

    private void setNextNodeForPreviousNode(MyNode node){
        MyNode currentNode = this.head;
        int i = 0;

        while (currentNode != null){
            if (i == this.size - 1 && this.size != 0) {
                currentNode.setNextNode(node);
                break;
            }
            currentNode = currentNode.getNextNode();
            i++;
        }
    }

}
