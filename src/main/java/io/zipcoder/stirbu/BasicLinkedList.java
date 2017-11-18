package io.zipcoder.stirbu;

public class BasicLinkedList<E> {

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        int length = 0;
        Node current = first;
        while (current != null){
            length++;
            current = current.getNextNode();
        }
        return length;
    }

    public void printAll() {
        Node printNode = this.first;
        int count = 0;
        while(count < size()){
            System.out.println(printNode.value);
            printNode = printNode.getNextNode();
            count++;
        }
    }

    public class Node {
        private Node nextNode;
        private E value;

        public Node(E value) {
            this.value = value;
        }

        public Node getNextNode() {
            return this.nextNode;
        }

    }

    private Node getNodeAtIndex(int i) {
        Node currentNode = first;
        while (i > 0 ){
            currentNode = currentNode.getNextNode();
            i--;
        }
        return currentNode;
    }

    Node first;
    Node last;
    int nodeCount = 0;

    public BasicLinkedList(){
        first = null;
        last = null;
    }

    Node currentNode = first;

    public void add(E item){
        if (first == null){
            first = new Node(item);
            last = first;
            nodeCount++;
        }
        else{
            last.nextNode = new Node(item);
            last = getNodeAtIndex(nodeCount++);
        }
    }

    public void remove(int index){
        Node aLeft = getNodeAtIndex(index - 1);
        aLeft.nextNode = aLeft.nextNode.nextNode;
    }

    public boolean contains(E item){
        int count = 0;
        Node currentNode = first;
        while (count < nodeCount){
            if(currentNode.value.equals(item)){
                    return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    public int find(E index){

        for(int i = 0; i < size() && currentNode != null; i++){
            if (index.equals(currentNode.getNextNode())){
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }

    public BasicLinkedList<E> copy(){
        BasicLinkedList basicLinkedListCopy = new BasicLinkedList();
        while (currentNode != null){
            basicLinkedListCopy.add(currentNode.getNextNode());
            currentNode = currentNode.nextNode;
        }
        return basicLinkedListCopy;
    }

    public void sort(){
        currentNode
    }
}
