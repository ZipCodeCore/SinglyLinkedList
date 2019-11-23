package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<C> {

    Node nodes;
    Node head = null;
    Integer size;

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
        this.head = new Node<C>(data);
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
                    current.setNext(new Node<C>(data));
                }
                current = current.getNext();
            }
        }
        else {
            this.head = new Node<C>(data);
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
        if(this.nodes.length == 0) {
            return;
        }
        C temp;
        for (int i = 0; i < this.nodes.length -1; i++) {
            for (int j = i; j < this.size -i - 1; j++) {
                if(this.nodes[j].compareTo(this.nodes[j + 1]) > 0) {
                    temp = (C) this.nodes[j].data;
                    this.nodes[j].data = this.nodes[j + 1].data;
                    this.nodes[j + 1].data = temp;
                }
            }
        }
        }

        public void reverse() {
            if(this.size == 0) {

            }
        }

}
