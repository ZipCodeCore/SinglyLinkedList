import sun.awt.image.ImageWatched;

import java.util.Comparator;
import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> {

    private Node head;
    private Node tail;

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
    }

    public T removeByValue(T val) {
        Node nxt = head;
        T rem = null;
        if (head.value.equals(val)) {
            rem = head.value;
            head = head.next;

        } else
            while (nxt.next != null) {
                if (nxt.next.value.equals(val)) {
                    rem = nxt.next.value;
                    if (nxt.next.next != null)
                        nxt.next = nxt.next.next;
                    else {
                        tail = nxt;
                        nxt.next = null;
                    }
                    break;
                }
                nxt = nxt.next;
            }

        return rem;
    }

    public Node remove(int index) {
        try {
            Node rem = null;
            if (index == 0) {
                rem = head;
                head = head.next;
            } else {
                int count = 1;
                Node remove = head;
                while (count != index) {
                    remove = remove.next;
                    count++;
                }
                if (remove.next.next != null) {
                    rem = remove.next;
                    remove.next = remove.next.next;
                } else {
                    rem = tail;
                    tail = remove;
                    remove.next = null;
                }
                return rem;
            }
        } catch (NullPointerException e) {
            System.out.println("Invalid Index");
        }
        return null;
    }


    public boolean contains(T val) {
        if (find(val) != -1)
            return true;
        else return false;

    }

    public int find(T val) {
        Node nxt = head;
        int count = 0;
        if (head.value.equals(val)) {
            return count;

        } else
            while (nxt.next != null) {
                count++;
                if (nxt.next.value.equals(val))
                    return count;

                nxt = nxt.next;
            }
        return -1;
    }

    public int size() {
        int count = 1;
        Node nxt = head;
        while (nxt.next != null) {
            count++;
            nxt = nxt.next;
        }

        return count;
    }

    public T get(int index) {
        try {
            if (index == 0) {
                return head.value;
            } else {
                int count = 1;
                Node item = head;
                while (count != index) {
                    item = item.next;
                    count++;
                }
                return item.next.value;
            }
        } catch (NullPointerException e) {
            System.out.println("Invalid Index");
        }
        return null;
    }


    public LinkedList<T> copy() {
        LinkedList<T> copy = new LinkedList<T>();
        for (int i = 0; i < this.size(); i++)
            copy.add(this.get(i));

        return copy;
    }

    public void insert(int index, T value) {
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            int count = 1;
            Node item = head;
            while (count != index) {
                item = item.next;
                count++;
            }
            newNode.next = item.next;
            item.next = newNode;
        }

    }

    public void sort() {
        for (int i = 1; i < size(); i++) {
            Node temp = remove(i);
            for (int j = i - 1; j >= 0; j--) {
                if (j == 0) {
                    insert((get(j).compareTo(temp.value) == -1 ? 1 : 0), temp.value);
                    break;
                } else if (get(j).compareTo(temp.value) < 0) {
                    insert(j + 1, temp.value);
                    break;
                } else if (get(j).compareTo(temp.value) == 0) {
                    insert(j, temp.value);
                    break;
                }

            }
        }

    }

    public LinkedList reverse(){
        LinkedList reversed=new LinkedList();
        for (int i=size()-1; i>=0; i--)
            reversed.add(this.get(i));

        return reversed;
    }

    public LinkedList slice(int start, int stop){
        LinkedList partial=new LinkedList();
        for (int i=start; i<stop;i++)
            partial.add(get(i));
        return partial;
    }

    public String toString() {
        Node nxt = head;
        String list = "";
        while (nxt.next != null) {
            list += nxt.value;
            nxt = nxt.next;
        }
        list += nxt.value;
        return list;
    }


    class Node {

        private Node next;
        private T value;

        Node(T value) {
            this.value = value;
        }
    }
}
