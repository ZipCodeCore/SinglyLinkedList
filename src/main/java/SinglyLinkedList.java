import java.util.logging.Logger;

public class SinglyLinkedList<T extends Comparable<T>> {

    private static final Logger logger = Logger.getGlobal();

    private Node <T> head;
    private Node <T> tail;
    private int size;


    public void add(T info) {
        Node <T> newNode = new Node <>(info);
        logger.info("Adding: " + info);

        if (head == null) {
            //one element,both head and tail point to same obj
            size = 1;
            head = newNode;
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
            size++;
        }
    }

    public Node <T> get(int index) {
        Node <T> checkNode = head;
        //logger.info("Indexing");
        int count = 0;
        while (checkNode != null) {
            if (count == index) {
                return checkNode;
            }
            checkNode = checkNode.nextNode;
            count++;
        }
        return null;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.nextNode;
        } else {
            logger.info("Removing " + get(index).info);
            get(index - 1).setNextNode(get(index + 1));
        }

    }
    public boolean contains(T info){
        return find(info) >= 0;
    }

    public int find(T info){
        Node<T> temp = head;
        int count = 0;
        while (temp != null){
            if(temp.info.equals(info)){
                return count;
            }
            temp = temp.getNextNode();
            count++;
        }
        return -1;
    }

    public void print(){
        logger.info("Printing List: ");
        //String output = "";
        Node<T> temp = head;
        while(true){
            if(temp == null)
                break;
            System.out.printf("%s ",temp.getInfo());
            //output += temp.getInfo() + " ";
            temp = temp.getNextNode();
        }

    }

    public int getSize(){
        return size;
    }

    public Node <T> getTail() {
        return tail;
    }

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList copy = new SinglyLinkedList();
        Node<T> temp = head;
        while(temp != null){
            copy.add(temp.getInfo());
            temp = temp.getNextNode();
        }
        return copy;
    }

    private void swap(Node<T> first , Node<T> second){
        Node<T> temp = get(find(first.info)-1);

        if(first == second){
            //break out of method when nodes are the same.
            return;
        }

        if(temp == null){
            head = second;
            first.setNextNode(second.nextNode);
            second.setNextNode(first);
        } else{
            temp.setNextNode(second);
            first.setNextNode(second.nextNode);
            second.setNextNode(first);
        }

    }

    public void sort(){
        int currentIndex;
        int finalIndex = size -1;

        while (0 < finalIndex){
            currentIndex = 0;
            while (currentIndex < finalIndex){
                Node<T> indexNode = get(currentIndex);
                Node<T> nextIndex = get(currentIndex+1);
                if(indexNode.getInfo().compareTo(nextIndex.getInfo()) > 0){
                    swap(indexNode,nextIndex);
                }
                currentIndex++;
            }
            finalIndex--;
        }
    }

    class Node<T> {
        private Node <T> nextNode;
        private T info;

        public Node(T info) {
            this.info = info;
        }

        public T getInfo() {
            return info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public Node <T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node <T> nextNode) {
            this.nextNode = nextNode;
        }
    }
}
