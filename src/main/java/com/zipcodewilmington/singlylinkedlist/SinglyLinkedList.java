package com.zipcodewilmington.singlylinkedlist;

import java.util.Iterator;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;


    public SinglyLinkedList(){
        head = null;
    }

    public Boolean isEmpty(){
        return head == null;
    }

    public void addFirst(T item){
        head = new Node<>(item, head);
    }

    public T getFirst(){
        if (head == null) throw  new NoSuchElementException();
        return head.data;
    }

    public T removeFirst(){
        T temp = getFirst();
        head = head.next;
        return temp;
    }

    public void remove(Integer index) {
        if (head == null || index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0){
            removeFirst();
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        temp.next = node.next;
    }


    public Integer size(){
        Node<T> tmp = head;
        Integer size = 1;
        if (head == null){
            return 0;
        } else {
            while (tmp.next != null) {
                size++;
                tmp = tmp.next;
            }
        }
        return size;
    }


    public void add(T item){
        if (head == null){
            addFirst(item);
        } else {
            Node<T> tmp = head;
            while (tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new Node<>(item, null);
        }
    }


    public T getLast(){
        if(head == null) throw new NoSuchElementException();

        Node<T> tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        return tmp.data;
    }


    public void clear(){
        head = null;
    }

    public Boolean contains(T t){
        for(T tmp : this){
            if(tmp.equals(t)){
                return true;
            }
        }
        return false;
    }


    public T get(Integer pos){
        if(head == null) throw new IndexOutOfBoundsException();

        Node<T> tmp = head;
        for (int i = 0; i < pos; i++){
            tmp = tmp.next;
        }
        if(head == null) throw new IndexOutOfBoundsException();
        return tmp.data;
    }


    public Integer find(T element){
        if(head == null) throw new IndexOutOfBoundsException();
        if (this.contains(element)) {
            SinglyLinkedListIterator iterator = (SinglyLinkedListIterator) this.iterator();
            Integer index = 0;
            while (iterator.hasNext()) {
                if (iterator.next().equals(element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }



    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();
        for (int i = 0; i < size(); i++){
            copy.add(this.get(i));
        }
        return copy;
    }


    public void sort(){
        GenericCompare<T> comp = new GenericCompare<>();

        Boolean wasChanged;
        do {
            Node<T> current = head;
            Node<T> previous = null;
            Node<T> next = head.next;
            wasChanged = false;

            while (next != null) {
                if (comp.compare(current.data, next.data) > 0) {
                    wasChanged = true;
                    if (previous != null) {
                        Node temp = next.next;
                        previous.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        Node temp = next.next;
                        head = next;
                        next.next = current;
                        current.next = temp;
                    }
                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (wasChanged);
    }





    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }
    }


    public Iterator<T> iterator() {
        return new SinglyLinkedListIterator();
    }


    private class SinglyLinkedListIterator implements Iterator<T>{
        private Node<T> nextNode;

        public SinglyLinkedListIterator(){
            nextNode = head;
        }


        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }
    }

    public class GenericCompare<T extends Comparable<T>> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    }

}