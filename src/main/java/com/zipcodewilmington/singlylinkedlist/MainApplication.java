package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {
    public static void main(String[] args) {

        SinglyLinkedList myList = new SinglyLinkedList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(55);
        myList.displayNodes();

        System.out.println(myList.get(5).getData());




    }

}
