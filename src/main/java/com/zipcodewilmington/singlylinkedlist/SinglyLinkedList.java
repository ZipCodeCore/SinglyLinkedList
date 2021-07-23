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

    public void remove(String data) {
        Node current = head;
        if (current == null) {
            throw new UnsupportedOperationException("No list here, smart guy");
        }

        if (current.data == data) {
            current = current.next;
            while (current.next != null) {
                current = current.next;
        }

        }
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
        int i = start;
        while (i < end) {
          substring += current.data;
            current = current.next;
            i++;
        }

      return substring;
    }
}
