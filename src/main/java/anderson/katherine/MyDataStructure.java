package anderson.katherine;

import java.util.StringJoiner;

public class MyDataStructure<T extends Comparable<T>> {

    private int sizeOfCollection = 0;
    private MyNode head;
    private MyNode last;

    public void add(T element) {
        MyNode addedElement = new MyNode(element);

        if(sizeOfCollection > 0) {
            last.setNext(addedElement);
        } else {
            head = addedElement;
        }
        sizeOfCollection++;
        last = addedElement;
    }

    public void remove(int index) {
        if(isValidIndex(index)) {
            if (index > 0) {
                MyNode previous = get(index - 1);
                previous.setNext(previous.next.next);
                if(index == sizeOfCollection - 1) {
                    last = previous;
                }
            } else {
                head = head.next;
            }
            sizeOfCollection--;
        }
    }

    public boolean contains(T element) {
        return find(element) > -1;
    }

    public int find(T element) {
        MyNode currentElement = head;
        for(int i = 0; i < sizeOfCollection; i++) {
            if(currentElement.value.equals(element)) {
                return i;
            }
            currentElement = currentElement.next;
        }
        return -1;
    }

    public int size() {
        return sizeOfCollection;
    }

    public MyNode get(int index) {
        if(isValidIndex(index)) {
            MyNode toReturn = head;
            int i = 0;
            while (i < index) {
                toReturn = toReturn.next;
                i++;
            }
            return toReturn;
        } else {
            return null;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < sizeOfCollection;
    }

    public MyDataStructure<T> copy() {
        MyDataStructure<T> newCopy = new MyDataStructure<T>();
        for(int i = 0; i < sizeOfCollection; i++) {
            newCopy.add(this.get(i).getValue());
        }
        return newCopy;
    }

    public void sort() {
        MyNode currentNode = head;
        boolean hasSetNewHead = false;
        while(currentNode.next != null) {
            if (!hasSetNewHead) {
                head = swapNext(head);
                hasSetNewHead = true;
                currentNode = head;
            } else {
                MyNode next = swapNext(currentNode.next);
                currentNode.next = next;
                currentNode = currentNode.next;
            }
        }

    }

    private MyNode swapNext(MyNode tempHead) {
        if(tempHead.next == null) {
            return tempHead;
        }
        MyNode min = tempHead;
        MyNode beforeMin = null;
        MyNode currentNode = tempHead;

        while(currentNode.next != null) {
            if (currentNode.next.getValue().compareTo(min.getValue()) < 0) {
                min = currentNode.next;
                beforeMin = currentNode;
            }
            currentNode = currentNode.next;
        }

        if(min != tempHead) {
            beforeMin.setNext(tempHead);

            MyNode tempNode = tempHead.next;
            tempHead.setNext(min.next);
            min.setNext(tempNode);
        }
        return min;
    }

    // 14, 15, 11, 2

    // currentNode = null (currentNode = previous)          currentNode = null
    // previous = {14, 15} (previous = nowBefore)           previous = head

    // nowBefore = {15, 11} (nowBefore = previous.next)
    // previous = {14, null} (previous.next = currentNode)
    // currentNode = {14, null} (currentNode = previous)
    // previous = {15, 11} (previous = nowBefore)

    // nowBefore = {11, 2} (nowBefore = previous.next)
    // previous = {15, 14} (previous.next = currentNode)
    // currentNode = {15, 14} (currentNode = previous)
    // previous = {11, 2} (previous = nowBefore)

    // nowBefore = {2, null} (nowBefore = previous.next)
    // previous = {11, 15} (previous.next = currentNode)
    // currentNode = {11, 15} (currentNode = previous)
    // previous = {2, null} (previous = nowBefore)

    // nowBefore = null (nowBefore = previous.next)
    // previous = {2, 11} (previous.next = currentNode)
    // currentNode = {2, 11} (currentNode = previous)
    // previous = null (previous = nowBefore)

    public void reverse() {
        MyNode currentNode = null;
        MyNode previous = head;

        boolean hasSetNewHead = false;
        while(!hasSetNewHead) {
            MyNode nowBefore = previous.next;
            previous.next = currentNode;
            currentNode = previous;
            previous = nowBefore;
            if(previous == null) {
                head = currentNode;
                hasSetNewHead = true;
            }
        }
    }

    public MyDataStructure<T> slice(int start, int end) {
        MyDataStructure<T> sliced = new MyDataStructure<T>();
        if(isValidIndex(start) && isValidIndex(end - 1) && start < end) {
            for(int i = start; i < end; i++) {
                sliced.add(this.get(i).getValue());
            }
        } else {
            return null;
        }
        return sliced;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" -> ");
        MyNode currentNode = new MyNode(null);
        currentNode.setNext(head);
        while(currentNode.next != null) {
            stringJoiner.add(currentNode.next.getValue().toString());
            currentNode = currentNode.next;
        }
        return stringJoiner.toString();
    }

    public class MyNode {
        private T value;
        private MyNode next;

        public MyNode(T value) {
            this.value = value;
            this.next = null;
        }

        public void setNext(MyNode nextNode) {
            this.next = nextNode;
        }

        public T getValue() {
            return value;
        }

        public MyNode getNext() {
            return next;
        }
    }
}
