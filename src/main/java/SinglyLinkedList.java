import java.util.logging.Logger;

public class SinglyLinkedList<T> {

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

    public String print(){
        logger.info("Printing List: ");
        String output = "";
        Node<T> temp = head;
        while(true){
            if(temp == null)
                break;
            //System.out.printf("%s ",temp.getInfo());
            output += temp.getInfo() + " ";
            temp = temp.getNextNode();
        }
        return output;
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

    public void sort(SinglyLinkedList<T> list){
        Node<T> temp = head;
    }

    class Node<T> implements Comparable <T> {
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

        @Override
        public int compareTo(T o) {
            if (o == this.info) {
                return 0;
            } else {
                return 1;
            }

        }
    }
}
