package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<C> {

    Node nodes;
    Node <C>head = null;
    Integer size;
    SinglyLinkedList list = new SinglyLinkedList();

    public Node getHead() {
        return head;
    }

    public Integer getSize() {
        return size;
    }

    public void setHead(Node<C> head) {
        this.head = head;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    public SinglyLinkedList(C data) {
        this.head = getHead();
        this.size = 0;
    }

    public SinglyLinkedList(){
        this.size = 0;
    }

    public void add(C data){
        if(head != null) {
            Node current = head;
            while (current.getNext() != null) {
                if (current.getNext() == null) {
                    current.setNext(getHead());
                }
                current = current.getNext();
            }
        }
        else {
            this.head = getHead();
            size++;
            }
        }


        public Boolean remove(Integer index) {
            Node current = this.head;
            Integer counter = 0;
            while (current != null) {
                if (index.equals(0)) {
                    this.head = current.getNext();
                    size--;
                    return true;
                } else if (counter == index - 1) {
                }
            }
            return false;
        }


        public Boolean contains(C data) {
            Node current = this.head;
            while (current != null) {
                if (current.getData() == data) {
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }

        public Integer find(C data) {
            Node current = this.head;
            Integer index = 0;
            while (current != null) {
                if(current.getData() == data)
                    return index;

                current = current.getNext();
                index++;
            }
            return -1;
        }

        public Node<C> getByIndex(Integer index) {
            Node current = this.head;
            Integer currentIndex = 0;
            while(current != null) {
                if(currentIndex.equals(index))
                    return current;
                current = current.getNext();
                currentIndex++;
            }
            return null;
        }

    public SinglyLinkedList<C> sort() {
        SinglyLinkedList<C> sorted = new SinglyLinkedList<T>();
        SinglyLinkedList<C> copy = copy();
        while (copy.size > 1) {
            Node<C> min = copy.getByIndex();
            C minimum = copy.getByIndex(min);
            copy.remove(min);
            sorted.add(minimum);
        }
        sorted.add(copy.getByIndex(0));
        return sorted;
    }


        public void reverse() {
            if(this.size == 0) {

            }
        }

        public SinglyLinkedList copy(SinglyLinkedList copy) {
        SinglyLinkedList linkedCopy = list;
        copy = list;
        return copy;
        }
}
