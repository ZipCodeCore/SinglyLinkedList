public class SinglyLinkedList<T extends Comparable<T>> {

    class Node {
        private T nodeData;
        private Node nextNode;

        Node(T nodeData) {
            this.nodeData = nodeData;
            nextNode = null;
        }

        public T getNodeData() {
            return nodeData;
        }

        public void setNodeData(T nodeData) {
            this.nodeData = nodeData;
        }
    }

    private Node firstNode;
    private Node lastNode;
    private Integer size = 0;

    public Integer getSize() {
        return size;
    }

    public Node getNodeByIndex(Integer index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("The index you provided is out of range, either to large or too small.");
        }

        Node aNode = firstNode;
        while (index > 0) {
            aNode = aNode.nextNode;
            index--;
        }
        return aNode;
    }

    public void addNodeToEndOfLinkedList(T nodeInformation) {
        Node aNewNode = new Node(nodeInformation);

        if (this.firstNode == null) {
            this.firstNode = aNewNode;
            this.lastNode = this.firstNode;
        }
        else {
            lastNode.nextNode = aNewNode;
            lastNode = aNewNode;
        }
        size++;
    }

    public void removeNodeByIndex(int index) {

        if (getNodeByIndex(index) != null){
            if (size == 0) {
                throw new NullPointerException("List is empty.");
            }
            else if(index == 0) {
                firstNode = firstNode.nextNode;
                lastNode = firstNode;
            }
            else if (index == size) {
                Node previousNode = getNodeByIndex(index-1);
                lastNode = previousNode;
            }
            else {
                Node previousNode = getNodeByIndex(index-1);
                previousNode.nextNode = getNodeByIndex(index+1);
            }
            size--;
        }
        else {
            throw new NullPointerException("Index does not exist.");
        }
    }

    public boolean containsNode(T nodeInformation) {

        Node linkedList = firstNode;
        while (linkedList != null) {
            if (linkedList.getNodeData().equals(nodeInformation)) {
                return true;
            }
            linkedList = linkedList.nextNode;
        }
        return false;
    }

    public int findNodeIndex(T nodeInformation) {
        int count = 0;
        Node linkedList = firstNode;
        while (linkedList != null) {
            if (containsNode(nodeInformation)) {
                return count;
            }
            count++;
            linkedList = linkedList.nextNode;
        }
        return -1;
    }

    public SinglyLinkedList<T> copyLinkedList() {
        SinglyLinkedList<T> aCopy = new SinglyLinkedList<>();

        Node linkedList = firstNode;
        while (linkedList != null) {
            aCopy.addNodeToEndOfLinkedList(linkedList.getNodeData());
            linkedList = linkedList.nextNode;
        }

        return aCopy;
    }

    public void sort() {
        //If i had a previous this would be more efficient but I don't so it's
        //less efficient cause I don't have a previous to be able to move back two and compare.

        Node linkedList = firstNode;
        while (linkedList != null && linkedList.nextNode != null) {
            T currentNodeData = linkedList.getNodeData();
            T nextNodeData = linkedList.nextNode.getNodeData();

            if (currentNodeData.compareTo(nextNodeData) > 0){
                linkedList.setNodeData(nextNodeData);
                linkedList.nextNode.setNodeData(currentNodeData);
                linkedList = firstNode;
            }
            else if (currentNodeData.compareTo(nextNodeData) <= 0) {
                linkedList = linkedList.nextNode;
            }
        }
    }

    public SinglyLinkedList reverse() {
        SinglyLinkedList<T> reverseLinkedList = new SinglyLinkedList<>();

        for (int x = size-1; x >= 0; x--) {
            reverseLinkedList.addNodeToEndOfLinkedList(this.getNodeByIndex(x).getNodeData());
        }
        return reverseLinkedList;
    }

    public SinglyLinkedList slice(int startIndex, int endIndex) {
        SinglyLinkedList<T> aSlicedList = new SinglyLinkedList<>();

        for (int x = startIndex; x < endIndex; x++) {
            aSlicedList.addNodeToEndOfLinkedList(this.getNodeByIndex(x).getNodeData());
        }
        return aSlicedList;
    }


}
