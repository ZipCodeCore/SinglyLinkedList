import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataStructures<P extends Comparable> {
    private Node<P> Head;
    private Node<P> lastNode;
    private int size = 0;

    //  For testing
    public void clear(){this.Head = null;}
    //  For testing
    public Node<P> getHead(){return Head;}
    //  For testing
    public Node<P> getLastNode(){return lastNode;}

    public class Node<P> {
        private P info;
        private Node<P> nextNode = null;
        private Node<P> previousNode;
        Node(P info, Node<P> previousNode){
            this.info = info;
            this.previousNode = previousNode;
        }
        P getInfo(){
            return this.info;
        }
        void setNextNode(Node<P> nextNode){
            this.nextNode = nextNode;
        }
        void setPreviousNode(Node<P> previousNode) {
            this.previousNode = previousNode;
        }
        @Override
        public String toString(){
            return info.toString();
        }
    }

    @Override
    public String toString(){
        Node<P> checkNode = Head;
        String output = "";
        while(checkNode != null){
            output+= checkNode.toString()+" ";
            checkNode = checkNode.nextNode;
        }
        return output;
    }

    public void add(P info){
        if(Head == null){
            Node<P> nextNode = new Node<>(info,null);
            this.Head = nextNode;
        }else if(lastNode == null){
            Node<P> nextNode = new Node<>(info,Head);
            Head.setNextNode(nextNode);
            lastNode = nextNode;
        }else{
            Node<P> nextNode = new Node<>(info,lastNode);
            lastNode.setNextNode(nextNode);
            lastNode = nextNode;
        }
        size++;
    }

    public void remove(int index){
        Node<P> indexNode = get(index);
        if(indexNode != null) {
            indexNode.previousNode.setNextNode(indexNode.nextNode);
            indexNode.nextNode.setPreviousNode(indexNode.previousNode);
            size--;
        }
    }

    public boolean contains(P info){
        return find(info) >= 0;
    }

    public int find(P info){
        Node<P> checkNode = Head;
        int count = 0;
        while(checkNode != null){
            if(info.equals(checkNode.getInfo())){
                return count;
            }
            checkNode = checkNode.nextNode;
            count++;
        }
        return -1;
    }

    public int size(){
        int count = 0;
        Node<P> checkNode = Head;
        while(checkNode != null){
            count++;
            checkNode = checkNode.nextNode;
        }
        return count;
    }

    public Node<P> get(int index){
        Node<P> checkNode = Head;
        int count = 0;
        while(checkNode != null){
            if(count == index){
                return checkNode;
            }
            checkNode = checkNode.nextNode;
            count ++;
        }
        return null;
    }

    public MyDataStructures<P> copy(){
        MyDataStructures<P> copy = new MyDataStructures<>();
        Node<P> indexNode = Head;
        while(indexNode != null){
            copy.add(indexNode.getInfo());
            indexNode = indexNode.nextNode;
        }
        return copy;
    }

    private void swap(Node<P> first,Node<P> second){
        if(first.previousNode != null) {
            first.previousNode.setNextNode(second);
        }else{
            Head = second;
        }
        if(second.nextNode != null) {
            second.nextNode.setPreviousNode(first);
        }
        first.setNextNode(second.nextNode);
        second.setPreviousNode(first.previousNode);
        second.setNextNode(first);
        first.setPreviousNode(second);

    }

    public void sort(){
        int finalIndex = size-1;

        while(0<finalIndex){
            int currentIndex = 0;
            while(currentIndex<finalIndex){
                Node<P> indexNode = get(currentIndex);
                Node<P> nextIndex = get(currentIndex+1);
                if(indexNode.getInfo().compareTo(nextIndex.getInfo()) > 0){
                    swap(indexNode,nextIndex);
                }
                currentIndex++;
            }
            finalIndex--;
        }
    }

    public void reverse(){
        MyDataStructures<P> reverse = new MyDataStructures<>();

        Node<P> currentNode = lastNode;
        while(currentNode != null){
            reverse.add(currentNode.getInfo());
            currentNode = currentNode.previousNode;
        }

        Head = reverse.getHead();
    }

    public MyDataStructures<P> slice(P first,P last){
        MyDataStructures<P> slice = copy();
        slice.Head = slice.get(slice.find(first));
        slice.get(slice.find(last)).previousNode.setNextNode(null);
        return slice;
    }

}
