package susnick.andrea.datastructures;

public class MyLinkedList<T> {
    Node root;
    Node tail;
    int listSize;

    public MyLinkedList() {
        root = null;
        tail = null;
        listSize = 0;
    }

    public int size() {
        return listSize;
    }

    public void add(T element){
        Node<T> nextNode = new Node<>(element, null);
        if (root == null) {
            root = nextNode;
            tail = nextNode;
        } else {
            tail.nextNode = nextNode;
            tail = nextNode;
        }
        listSize++;
    }

    public void remove(int index){
        if (index == 0){
            root = root.nextNode;
        }
        else{
            int count = 1;
            Node<T> current = root;
            while (index < count) {
                current = current.nextNode;
                count++;
            }
            if (count == listSize) {
                tail = current;
                current.setNextNode(current.nextNode.nextNode);
            }
        }
        listSize--;
    }

    public boolean contains(T element){
        Node current = root;
        while (current != null) {
            if (current.value.equals(element)) {
                return true;
            } else {
                current = current.nextNode;
            }
        }
        return false;
    }

    public int find(T element){
        Node<T> current = root;
        Node<T> previous;
        int index = 0;
        do{
            if (current.value.equals(element))
                return index;
                previous = current;
                current = current.nextNode;
                index++;
        }while(previous.nextNode != null);
        return -1;
    }

    public Node<T> get(int element){
        Node<T> current = root;
        int index = 0;
        while(current != null){
            if(index == element) {
                return current;
            }
            current = current.nextNode;
            index++;
        }
        return null;
    }

    public MyLinkedList<T> copy() {
        MyLinkedList<T> copyOfMyLinkedList = new MyLinkedList<>();
        Node<T> current = root;
        while (true) {
            if (current == null) {
                break;
            } else {
                copyOfMyLinkedList.add(current.value);
                current = current.nextNode;
            }
        }
        return copyOfMyLinkedList;
    }

//    public void sort(){
//    }
    //trying to figure this method out

    public void display() {
        System.out.println();
        Node current = root;
        while (current != null){
            System.out.println(current.value);
            current = current.nextNode;
        }
    }

    class Node<T> {
        public Node<T> nextNode;
        public T value;

        public Node(T value, Node<T> nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        public T getValue(){
            return value;
        }

        public void setValue(T value){
            this.value = value;
        }
    }
}
