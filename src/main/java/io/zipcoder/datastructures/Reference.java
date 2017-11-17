/*
import java.util.NoSuchElementException;
import java.util.Scanner;

class Node<T> {

    public Node<T> next;
    public T data;

    public Node() {

    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node [next=" + next + ", data=" + data + "]";
    }
}

class LinkedList<T> {

    Node<T> start = null;
    Node<T> end = null;

    public void insertAtStart(T data) {
        Node<T> nptr = new Node<T>(data, null);
        if (empty()) {
            start = nptr;
            end = start;
        } else {
            nptr.next = start;
            start = nptr;
        }
        display();
    }

    public void insertAtEnd(T data) {
        Node<T> nptr = new Node<T>(data, null);
        if (empty()) {
            insertAtStart(data);
            return;
        } else {
            end.next = nptr;
            end = nptr;
        }
        display();
    }

    public void insertAtPosition(int position, T data) {
        if (position != 1 && empty())
            throw new IllegalArgumentException("Empty");
        if (position == 1) {
            insertAtStart(data);
            return;
        }

        Node<T> nptr = new Node<T>(data, null);
        if (position == size()) {

            Node<T> startPtr = start;
            Node<T> endPtr = startPtr;
            while (startPtr.next != null) {
                endPtr = startPtr;
                startPtr = startPtr.next;
            }
            endPtr.next = nptr;
            nptr.next = end;
        } else {
            position -= 1;
            Node<T> startPtr = start;
            for (int i = 1; i < size(); i++) {
                if (i == position) {
                    Node<T> temp = startPtr.next;
                    startPtr.next = nptr;
                    nptr.next = temp;
                }
                startPtr = startPtr.next;
            }
        }
        display();
    }

    public void delete(int position) {

        if (empty())
            throw new IllegalArgumentException("Empty");

        if (position == 1) {
            start = start.next;
        } else if (position == size()) {
            Node<T> startPtr = start;
            Node<T> endPtr = start;
            while (startPtr.next != null) {
                endPtr = startPtr;
                startPtr = startPtr.next;
            }
            endPtr.next = null;
            end = endPtr;
        } else {
            position -= 1;
            Node<T> startPtr = start;
            for (int i = 1; i <= position; i++) {
                if (i == position) {
                    Node<T> temp = startPtr.next.next;
                    startPtr.next = temp;
                }
                startPtr = startPtr.next;
            }
        }
        display();
    }

    public int index(T data) {
        if (empty())
            throw new IllegalArgumentException("Empty");
        return index(start, data, 0);
    }

    private int index(Node<T> link, T data, int index) {
        if (link != null) {
            if (link.data == data) {
                return index;
            }
            return index(link.next, data, ++index);
        }
        return -1;
    }

    public void replace(int position, T data) {
        if (empty())
            throw new IllegalArgumentException("Empty");
        if (position == 1)
            start.data = data;
        else if (position == size())
            end.data = data;
        else {
            Node<T> startPtr = start;
            for (int i = 1; i <= position; i++) {
                if (i == position)
                    startPtr.data = data;
                startPtr = startPtr.next;
            }
        }
        display();
    }

    public void replaceRecursively(int position, T data) {
        replaceRecursively(start, position, data, 1);
        display();
    }

    private void replaceRecursively(Node<T> link, int position, T data, int count) {
        if (link != null) {
            if (count == position) {
                link.data = data;
                return;
            }
            replaceRecursively(link.next, position, data, ++count);
        }
    }

    public T middle() {
        if (empty())
            throw new NoSuchElementException("Empty");
        Node<T> slowPtr = start;
        Node<T> fastPtr = start;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr.data;
    }

    public int occurence(T data) {
        if (empty())
            throw new NoSuchElementException("Empty");
        return occurence(start, data, 0);
    }

    private int occurence(Node<T> link, T data, int occurence) {
        if (link != null) {
            if (link.data == data)
                ++occurence;
            return occurence(link.next, data, occurence);
        }
        return occurence;
    }

    public void reverseRecusively() {
        reverseRecusively(start);
        swapLink();
        display();
    }

    private Node<T> reverseRecusively(Node<T> link) {
        if (link == null || link.next == null)
            return link;
        Node<T> nextLink = link.next;
        link.next = null;
        Node<T> revrseList = reverseRecusively(nextLink);
        nextLink.next = link;
        return revrseList;
    }

    public void reverse() {
        if (empty())
            throw new NoSuchElementException("Empty");
        Node<T> prevLink = null;
        Node<T> currentLink = start;
        Node<T> nextLink = null;
        while (currentLink != null) {
            nextLink = currentLink.next;
            currentLink.next = prevLink;
            prevLink = currentLink;
            currentLink = nextLink;
        }
        swapLink();
        display();
    }

    private void swapLink() {
        Node<T> temp = start;
        start = end;
        end = temp;
    }

    public void swapNode(T dataOne, T dataTwo) {
        if (dataOne == dataTwo)
            throw new IllegalArgumentException("Can't swap " + dataOne + " and " + dataTwo + " both are same");
        boolean foundDataOne = false;
        boolean foundDataTwo = false;

        Node<T> dataOnePtr = start;
        Node<T> dataOnePrevPtr = start;
        while (dataOnePtr.next != null && dataOnePtr.data != dataOne) {
            dataOnePrevPtr = dataOnePtr;
            dataOnePtr = dataOnePtr.next;
        }

        Node<T> dataTwoPtr = start;
        Node<T> dataTwoPrevPtr = start;
        while (dataTwoPtr.next != null && dataTwoPtr.data != dataTwo) {
            dataTwoPrevPtr = dataTwoPtr;
            dataTwoPtr = dataTwoPtr.next;
        }

        if (dataOnePtr != null && dataOnePtr.data == dataOne)
            foundDataOne = true;

        if (dataTwoPtr != null && dataTwoPtr.data == dataTwo)
            foundDataTwo = true;

        if (foundDataOne && foundDataTwo) {

            if (dataOnePtr == start)
                start = dataTwoPtr;
            else if (dataTwoPtr == start)
                start = dataOnePtr;

            if (dataTwoPtr == end)
                end = dataOnePtr;
            else if (dataOnePtr == end)
                end = dataTwoPtr;

            Node<T> tempDataOnePtr = dataOnePtr.next;
            Node<T> tempDataTwoPtr = dataTwoPtr.next;

            dataOnePrevPtr.next = dataTwoPtr;
            dataTwoPtr.next = tempDataOnePtr;
            dataTwoPrevPtr.next = dataOnePtr;
            dataOnePtr.next = tempDataTwoPtr;

            if (dataOnePtr == dataTwoPrevPtr) {
                dataTwoPtr.next = dataOnePtr;
                dataOnePtr.next = tempDataTwoPtr;
            } else if (dataTwoPtr == dataOnePrevPtr) {
                dataOnePtr.next = dataTwoPtr;
                dataTwoPtr.next = tempDataOnePtr;
            }

        } else
            throw new NoSuchElementException("Either " + dataOne + " or " + dataTwo + " not in the list");
        display();
    }

    public int size() {
        return size(start, 0);
    }

    private int size(Node<T> link, int i) {
        if (link == null)
            return 0;
        else {
            int count = 1;
            count += size(link.next, 0);
            return count;
        }
    }

    public void printNthNodeFromLast(int n) {

        if (empty())
            throw new NoSuchElementException("Empty");

        Node<T> main_ptr = start;
        Node<T> ref_ptr = start;

        int count = 0;
        while (count < n) {
            if (ref_ptr == null) {
                System.out.println(n + " is greater than the no of nodes in the list");
                return;
            }
            ref_ptr = ref_ptr.next;
            count++;
        }

        while (ref_ptr != null) {
            main_ptr = main_ptr.next;
            ref_ptr = ref_ptr.next;
        }

        System.out.println("Node no " + n + " from the last is " + main_ptr.data);

    }

    public void display() {
        if (empty())
            throw new NoSuchElementException("Empty");
        display(start);
    }

    private void display(Node<T> link) {
        if (link != null) {
            System.out.print(link.data + " ");
            display(link.next);
        }
    }

    public boolean empty() {
        return start == null;
    }

}

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        boolean yes = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n1. Insert At Start");
            System.out.println("2. Insert At End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete");
            System.out.println("5. Display");
            System.out.println("6. Empty status");
            System.out.println("7. Get Size");
            System.out.println("8. Get Index of the Item");
            System.out.println("9. Replace data at given position");
            System.out.println("10. Replace data at given position recusively");
            System.out.println("11. Get Middle Element");
            System.out.println("12. Get Occurence");
            System.out.println("13. Reverse Recusively");
            System.out.println("14. Reverse");
            System.out.println("15. Swap the nodes");
            System.out.println("16. Nth Node from last");
            System.out.println("\nEnter your choice");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter the item");
                        linkedList.insertAtStart(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Enter the item");
                        linkedList.insertAtEnd(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Enter the position");
                        int position = scanner.nextInt();
                        if (position < 1 || position > linkedList.size()) {
                            System.out.println("Invalid Position");
                            break;
                        }
                        System.out.println("Enter the Item");
                        linkedList.insertAtPosition(position, scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        System.out.println("Enter the position");
                        int position = scanner.nextInt();
                        if (position < 1 || position > linkedList.size()) {
                            System.out.println("Invalid Position");
                            break;
                        }
                        linkedList.delete(position);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        linkedList.display();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println(linkedList.empty());
                    break;

                case 7:
                    try {
                        System.out.println(linkedList.size());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        System.out.println(linkedList.index(scanner.nextInt()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        System.out.println("Enter the position");
                        int position = scanner.nextInt();
                        if (position < 1 || position > linkedList.size()) {
                            System.out.println("Invalid Position");
                            break;
                        }
                        linkedList.replace(position, scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        System.out.println("Enter the position");
                        int position = scanner.nextInt();
                        if (position < 1 || position > linkedList.size()) {
                            System.out.println("Invalid Position");
                            break;
                        }
                        System.out.println("Enter the item");
                        linkedList.replaceRecursively(position, scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 11:
                    try {
                        System.out.println(linkedList.middle());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 12:
                    try {
                        System.out.println("Enter the item");
                        System.out.println(linkedList.occurence(scanner.nextInt()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 13:
                    try {
                        linkedList.reverseRecusively();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 14:
                    try {
                        linkedList.reverse();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 15:
                    try {
                        System.out.println("Enter the nodes");
                        linkedList.swapNode(scanner.nextInt(), scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 16:
                    try {
                        System.out.println("Enter which node do you want from last");
                        linkedList.printNthNodeFromLast(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (yes);
        scanner.close();
    }
}*/
