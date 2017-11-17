class BasicLinkedList<E extends Comparable> {

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

    public boolean contains(E value) {
        Node<E> temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            else if (temp.value == value ) {
                return true;
            }
            temp = temp.nextNode;
        }
        return false;
    }

    public String print() {
        Node<E> temp = head;
        String returnString = "";
        int count = 0;
        while(true) {
            if (temp == null)
                break;
            if (count == 0) {
                returnString += temp.value;
            }
            else {
                returnString += "\n" + temp.value;
            }
            temp = temp.nextNode;
            count++;
        }
        return returnString;
    }


    public int find(E value) {
        Node<E> temp = head;
        int count = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            else if (temp.value == value) {
                return count;
            }
            temp = temp.nextNode;
            count++;
        }
        return -1;
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

    public BasicLinkedList<E> copy () {
        BasicLinkedList<E> copyOfLinkedList = new BasicLinkedList<>();
        Node<E> temp = head;
        while (true) {
            if (temp == null) {
                break;
            }
            else {
                copyOfLinkedList.add(temp.value);
            }
            temp = temp.nextNode;
        }
        return copyOfLinkedList;
    }

    public void sort() {
            Node<E> temp_i = head;
            for (int i = 0; i < size() - 1; i++) {
                Node<E> temp_j = temp_i.nextNode;
                for (int j = i + 1; j < size(); j++) {
                    if ((temp_j.value).compareTo(temp_i.value) < 0) {
                        E swap_val = temp_i.value;
                        temp_i.value = temp_j.value;
                        temp_j.value = swap_val;
                    }
                    temp_j = temp_j.nextNode;
                }
                temp_i = temp_i.nextNode;
            }
    }

    static class Node<E> implements Comparable<E> {
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

        @Override
        public int compareTo(E o) {
            if (o == this.value) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}