package com.zipcodewilmington.singlylinkedlist;
import java.util.Comparator;
/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<C> implements Comparator{

    Node nodes;
    Node <C>head = null;
    Integer size;
    C data;
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
        this.data = data;
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

    public void sort() {
        for (int i = 0; i < size; i++) {
            Node current = head;
            Node nextNode = head.next;
            for (int j = 0; j < size; j++) {
                if (current.data.compareTo(nextNode.data) >0){
                    Node temp = current;
                    current = nextNode;
                    nextNode = temp;
                }
                current = nextNode;
                nextNode = nextNode.next;
            }
        }
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

