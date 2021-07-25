package com.zipcodewilmington.singlylinkedlist;

import javax.xml.soap.Node;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList {

    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void addNode(String data){
        Node newNode = new Node (data);
        if (head == null){
            head = newNode;
        } else {
            tail.next =newNode;
        }
        tail = newNode;
    }

    public int size() {
       int length = 0;
       Node current = head;

       while (current != null){
          length++;
          current = current.next;
       }
       return length;
    }

    public void remove(int index){
        Node current = head;
        if (current == null) {
            throw new UnsupportedOperationException("List is uhhh duhh empty");
        }
        int trackIndex = 0;
        while (current != null){
            if (trackIndex == index){
                current.data = null;
            }
            current = current.next;
        }

    }

    public SinglyLinkedList remove(String data) {
        SinglyLinkedList list = new SinglyLinkedList();
        Node current = head;
        if (current == null) {
            throw new UnsupportedOperationException("No list here, smart guy");
        }

        while (current != null) {
               // current = current.next;
                if (current.data != data) {
                    list.addNode(current.data);
                   //current.data = null;
                }

                current = current.next;
            }
        return list;

    }


    public Boolean contains(String data){
        Node current = head;
        if (head == null){
            throw new UnsupportedOperationException("No list again fool!");
        }
        while(current != null){
            if (current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public int find (String data) {
        Node current = head;
        int index = 0;
        if (head == null) {
            throw new UnsupportedOperationException("Got ya again!");
        }
        while (current != null){
            if (current.data == data){
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public String get (int index) {
        Node current = head;
        int trackIndex = 0;
        if (head == null || index > size() || index <0) {
            throw new UnsupportedOperationException("THERE'S NO LIST");
        }
        while (current != null){
            if (trackIndex ==index){
                return current.data;
            }
            trackIndex++;
            current = current.next;
        }
        return null;
    }

    public SinglyLinkedList copy() {
        SinglyLinkedList copied = new SinglyLinkedList();

        Node current = head;
        if (head ==null) {
            throw new UnsupportedOperationException("Nick proved this would happen");
        }
        while (current != null){
            copied.addNode(current.data);
            current = current.next;
        }
        return copied;
    }

    public SinglyLinkedList reverse () {
        SinglyLinkedList reverseList = new SinglyLinkedList();
        int i = size() -1;
        if (head == null) {
            throw new UnsupportedOperationException("Try it again");
        }
        while (i >=0) {
            reverseList.addNode(get(i));
            i--;
        }
        return reverseList;
    }

    public String slice(int start, int end){
        String substring = "";
        Node current = head;
        if (head == null){
            throw new UnsupportedOperationException("You wildin again, no list buddy");
        }
        int i = 0;
        while (current.next != null){
            if (i >= start && i < end) {
                substring += current.data;
            }
            current = current.next;
            i++;
        }

      return substring;
    }

    public void sort(){
        //Node current = head;
        int length = size();

        for (int i = 0; i < length; i++) {
            Node current = head;
            while (current.next != null){
                String currentValue = current.data;
                String nextValue = current.next.data;
                if (compareNodeValue(currentValue, nextValue)){
                    String temp = current.data;
                    current.data = nextValue;
                    current.next.data = temp;
                }
                current = current.next;
            }

        }

//        while (i < length) {
//                String currentValue = copyOfSort.get(i);
//                String nextValue = copyOfSort.get(i + 1);
//                while (compareNodeValue(currentValue, nextValue)) {
//                    String temp = currentValue;
//                    copyOfSort.setNode(i, nextValue);
//                    copyOfSort.setNode(i+1, temp); //null??
//                    //copyOfSort.addNode(nextValue);
//                    i++;
//                }
////                copyOfSort.addNode(current.data);
//                i++;
//            current = current.next;
//            }

        //return copyOfSort;
        }

    public void setNode (int index, String reset) {
        Node current = head;
        int trackIndex = 0;
        if (head == null || index > size() || index <0) {
            throw new UnsupportedOperationException("THERE'S NO LIST");
        }
        while (current != null) {
            if (trackIndex == index) {
                current.data = reset;
            }
            trackIndex++;
            current = current.next;
        }
    }

    public Boolean compareNodeValue(String first, String next){
        if (first == null || next == null){
            throw new UnsupportedOperationException("empty node");
        }

        if (first.charAt(0) > next.charAt(0)){
            return true;
        }
        return false;
    }

}
