public class LinkedListBuilder<T extends Comparable<T>> {

    Node head = null;
    Node tail = null;
    int nodeCount = 0;

    public void add(T value){
        Node node = new Node(value);
        add(node);
    }

    public void add(Node node){

        if (head == null){
            head = node;
            tail = head;
            node.nextNode = null;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        nodeCount++;
    }

    public int size(){
        return nodeCount;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

   public void remove(int position){
        Node currentNode = head;
        int index = 1;
        while (currentNode != null && index != (position - 1)){
            currentNode = currentNode.nextNode;
            index ++;
        }
        Node nodeToRemove = currentNode.nextNode;
        currentNode.nextNode = nodeToRemove.nextNode;
        nodeCount--;
   }

   public Node get(int position){
       Node currentNode = head;
       int index = 1;
       while (currentNode != null && index != position){
           currentNode = currentNode.nextNode;
           index++;
       }
       return currentNode;
   }

   public boolean contains(T value){
       Node currentNode = head;
       boolean isInList = false;
       for (int index = 1; index <= size(); index++){
           if (currentNode.getValue().equals(value)){
               isInList = true;
           }
           currentNode = currentNode.nextNode;
       }
       return isInList;
   }

   public int find(T value){
       Node currentNode = head;
       int valuesIndex = -1;
       for (int index = 1; index <= size(); index++){
           if (currentNode.getValue().equals(value)){
               valuesIndex = index;
           }
           currentNode = currentNode.nextNode;
       }
       return valuesIndex;
   }

   public void sort(){
       Node currentNode = head;
       Node nextNode = currentNode.getNextNode();
       T tempValue;
       while(nextNode != null){
           while ((nextNode != null)){
               if(currentNode.getValue().compareTo(nextNode.getValue()) > 0){
                   tempValue = nextNode.getValue();
                   nextNode.setValue(currentNode.getValue());
                   currentNode.setValue(tempValue);
               }
               nextNode = nextNode.getNextNode();
           }
           currentNode = currentNode.getNextNode();
           nextNode = currentNode.getNextNode();
       }

   }

   public LinkedListBuilder<T> copy(){
       LinkedListBuilder<T> copiedList = new LinkedListBuilder<>();
       for (int index = 1; index <= size(); index++){
           copiedList.add(this.get(index).getValue());
       }
       return copiedList;
   }

    @Override
    public String toString() {
        String output = "";
        Node currentNode = head;
        for (int index = 1; index <= size(); index++){
            output += "index: " + index + " || value: " + currentNode.getValue() + "\n";
            currentNode = currentNode.nextNode;
        }
        output = output.trim();
        return output;
    }

    public class Node{

        private Node nextNode;
        private T value;

        public Node(T value){
            this.value = value;
        }

        public Node getNextNode(){
            return nextNode;
        }

        public T getValue(){
            return value;
        }

        public void setValue(T value){
            this.value = value;
        }

    }

}
