package io.zipcoder.maiale;

public class LinkedBuilder<R extends Comparable> {

    private Node head;
    private Node tail;
    private int nodeCounter;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void add(R nodeToBeAdded){
        Node createdNode = new Node(nodeToBeAdded);
        if (head == null){
            head = createdNode;
            tail = createdNode;
        }else {
            tail.setNextNode(createdNode);
            tail = createdNode;

        }
        nodeCounter++;

    }

    public R remove(int nodeToBeRemovedbyIndex){
        return null;
    }

    public boolean contains(R nodeToBeChecked){
        return true;
    }

    public int find(R nodeToFind){
        return -1;
    }

    public int sizeOfList(){
        return nodeCounter;

    }

    public R get(int index){
        for (int i = 0; i < index; i++){

        }
        return null;
    }

    public LinkedBuilder copy(LinkedBuilder listToCopy){
        return null;
    }

    public void sort(LinkedBuilder listToSort){

    }

    public class Node {

        private Node nextNode;
        //private Node<R> previousNode;
        private R data;

        public Node(R data){
            this.nextNode = null;
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public R getData() {
            return data;
        }

        public void setData(R data) {
            this.data = data;
        }


    }


}
