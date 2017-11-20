package io.zipcoder.zhang;

import javax.xml.soap.Node;

public class LinkedList<X extends Comparable<X>> {
    private Node head;
    private Node tail;
    private int nodeCount;
    public LinkedList(){
        head=null;
        tail=null;
        nodeCount=0;
    }
    public void add(X item){
        //adding node for the first time
        if(head==null){
            head=new Node(item);
            tail=head;
        } //otherwise, link it to the current last node and update it
        else{
            Node lastNode = new Node(item);
            tail.setNext(lastNode);
            tail=lastNode;
        }
        nodeCount++;
    }
//    public void insert(X item, int pos){
//        if(size()<pos){
//            throw new IllegalStateException("This LinkedList is smaller than the position you want to the insert the item.");
//        }
//        Node currentNode = head;
//        for(int i=1; i<pos && currentNode!=null; i++){
//            currentNode = currentNode.getNext();
//        }
//        Node newNode = new Node(item);
//        Node nextNode = currentNode.getNext();
//        currentNode.setNext(newNode);
//        newNode.setNext(nextNode);
//        nodeCount++;
//
//    }
//    public X remove(){
//        if(head ==null){
//            throw new IllegalStateException("The LinkedList is empty and there is no item to remove.");
//        }
//        //first we get the first node and update the head to point to the next node and throw away the old first node
//            X data = head.getData();
//            head=head.getNext();
//            nodeCount--;
//            return data;
//    }
    public X removeAt(int pos){
        if(head == null){
           throw new IllegalStateException("The LinkedList is empty and there is no item to remove.");
        }
        Node currentNode = head;
        Node prevNode= head;
        for(int i=1;i<pos && currentNode!=null;i++){
            prevNode=currentNode;
            currentNode = currentNode.getNext();
        }
        X data = currentNode.getData();
        prevNode.setNext(currentNode.getNext());
        nodeCount--;
        return data;
    }
    public boolean contains(X item){
        return find(item)>-1;
    }
    public int find(X item){
        if(head == null){
            throw new IllegalStateException("The LinkedList is empty and there is no item to return.");
        }
        Node currentNode = head;
        for(int i=1; i<size() && currentNode!=null; i++){
            if(currentNode.getData().equals(item))
                return i;
            currentNode=currentNode.getNext();
        }
        return -1;
    }
    public int size(){
        return nodeCount;
    }
    public  X get(int pos){
        if(head == null){
            throw new IllegalStateException("The LinkedList is empty and there is no item to return.");
        }
        Node currentNode = head;
        for(int i=1; i<size() && currentNode!=null; i++){
            if(i==pos)
                return currentNode.getData();
            currentNode = currentNode.getNext();
        }
        return null;
    }
    public LinkedList<X> copy(){
        LinkedList<X> newList = new LinkedList<X>();
        Node current = head;
        for(int i=0;i<size();i++){
            newList.add(current.getData());
            current=current.getNext();
        }
        return newList;
    }
    public void sort(){
        Node current = head;
        Node nextNode = current.getNext();
        X temp;
        for(int i=0; i<size()-1;i++){
            for(int j=i+1; j<size() && nextNode!= null;j++) {
                if (current.getData().compareTo(nextNode.getData()) > 0) {
                    temp = nextNode.getData();
                    nextNode.setData(current.getData());
                    current.setData(temp);
                }
            }
            current=current.getNext();
            nextNode=current.getNext();
        }
    }
    public String toString(){
        StringBuffer contents = new StringBuffer();
        Node currentNode = head;
        while(currentNode!=null){
            contents.append(currentNode.getData());
            currentNode= currentNode.getNext();
            if(currentNode!=null){
                contents.append(",");
            }
        }
        return contents.toString();
    }


    private class Node{
        private X data;
        private  Node next;
        Node(X d){
            this.data = d;
            next = null;
        }
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public X getData() {
            return data;
        }

        public void setData(X data) {
            this.data = data;
        }
    }
}
