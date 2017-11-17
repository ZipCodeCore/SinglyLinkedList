import java.net.Inet4Address;

class BasicLinkedList<E> {

    private Node<E> head;// = new Node<>(null);
    private Node<E> tail;// = head;
    private int size;

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head =  newNode;
            tail = newNode;
        }
        else {
            tail = tail.nextNode = new Node<>(value);
        }
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.nextNode;
        } else {
            get(index - 1).setNextNode(get(index + 1));
        }
        size--;
    }

    public void print() {
        Node<E> temp = head;
        while(true) {
            if (temp == null)
                break;
            System.out.println(temp.value);
            temp = temp.nextNode;
        }
    }

    public void contains() {

    }

    public void find() {

    }

    public int size() {
        return this.size;
    }

    public Node <E> get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("" + index);

        Node<E> node = head;
        while(index > 0) {
            node = node.nextNode;
            index--;
        }
        return node;
    }


    static class Node<E> {
        E value;
        Node<E> nextNode;

        Node(E value) {
            this.value = value;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }
    }
}