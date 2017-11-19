package Mohammed.Abrar.DataStructures;


public class LinkedList<T extends Comparable> {

    private Node<T> head;


    public LinkedList() {
        this.head = null;
    }


    public T getHead() {
        if (head == null) {
            return null;
        }
        return head.data;
    }


    public void add(T t) {
        head = new Node<T>(t, head);
    }


    public int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    public T get(int reference) {
        try {
            if (head == null)
                return null;
            Node<T> tmp = head;
            for (int i = 0; i < reference && tmp != null; i++)
                tmp = tmp.next;
            return tmp.data;
        } catch (Exception e) {

            System.out.println("Can not get the item");
            return null;
        }
    }


    public int find(T data) {
        try {
            if (head == null)
                return -1;
            int index = 0;
            Node<T> tmp = head;
            for (index = 1; tmp.data == data && tmp != null; index++)
                tmp = tmp.next;
            return index;
        } catch (Exception e) {

            System.out.println("Can not get the item");
            return -1;
        }
    }


    public void sort() {
        if (head == null) {
            System.out.println("Nothing to be sorted");
        }
        Node tmp = head;
        for (int i = 0; i < size() - 1; i++) {
            Node tmp2 = tmp.next;
            for (int j = i + 1; j < size(); j++) {
                if ((tmp2.data).compareTo(tmp.data) < 0) {
                    T data1 = (T) tmp.data;
                    tmp.data = tmp2.data;
                    tmp2.data = data1;
                }
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
    }


    public boolean isEmpty() {
        return head == null;
    }


    public boolean contains(T data) {
        T data1 = head.data;
        if (data1.equals(data))
            return true;
        while (head != null) {
            if (head.data.equals(data))
                return true;
            head = head.next;
        }
        return false;
    }


    public void remove(T data) {
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        Node<T> previousPosition = head;
        Node<T> currentPostion = null;

        while (!previousPosition.data.equals(data)) {
            previousPosition = currentPostion;
            currentPostion = currentPostion.next;
        }
        previousPosition.next = currentPostion.next;
    }


    public LinkedList<T> copy(LinkedList<T> linkedList) {
        Node<T> tmp = head;
        while (tmp != null) {
            linkedList.addLast(tmp.data);
            tmp = tmp.next;
        }
        return linkedList;
    }


    public void addLast(T item) {
        if (head == null)
            add(item);
        else {
            Node<T> tmp = head;
            while (tmp.next != null)
                tmp = tmp.next;
            tmp.next = new Node<T>(item, null);
        }
    }


    public T getLast() {
        Node<T> tmp = head;
        while (tmp.next != null)
            tmp = tmp.next;
        return tmp.data;

    }


    private static class Node<T extends Comparable> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public int compareTo(T o) {
            return next.compareTo(o);
        }
    }

}
