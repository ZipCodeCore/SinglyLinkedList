package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<C> {

    Node head = null;
    Integer size;
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




}
