package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList< T extends Comparable<T>> {

    Node head = null;
    Node tail = null;


    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }


    public void add(T data) {
        Node elNubo = new Node(data);
        if (head == null) {
            head = elNubo;

        } else {// SI NO ESTA VASIO AGRAGARLO AL FINAL..

            tail.next = elNubo;
        }
        tail = elNubo; // AHORA EL EL ES TAIL.
    }


    public int size() {
        Node otro = head;
        int count = 0;
        while (otro != null) {
            count++;
            otro = otro.next;
        }
        return count;
    }

    public Boolean contains(T data) {
        Node otro = head;
        while (otro != null) {
            if (otro.data == data) {
                return true;
            }
            otro = otro.next;

        }
        return false;
    }

    public Integer find(T element) {
        Node enElQueEsta = head;
        for (int i = 0; i < size(); i++) {
            if (!enElQueEsta.data.equals(element)) {
                enElQueEsta = enElQueEsta.next;
            } else return i;
        }
        return -1;
    }


    public T get(int index) {
        Node box = head;
        for (int i = 0; i < size(); i++) {
          if (i == index ){
              return box.data;
          }else box = box.next;


        }
        return null;
    }


    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> copy = new SinglyLinkedList<T>();

        Node nodito = head;
        for (int i = 0; i <= size(); i++) {
            copy.add(nodito.data);
            nodito = head.next;
        }

        return copy;
    }
    public void remove(Integer index) {
        Node current = head;
        Node last = head;
        for (int i = 0; i < size(); i++) {
            if(i != index) {
                last = current;
                current = current.next;
            } else {
                while(i < size() - 1) {
                    last.next = current.next;
                }
            }
        }
    }
}



