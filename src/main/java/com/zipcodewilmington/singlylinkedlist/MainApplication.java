package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {

    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("1");
        singlyLinkedList.add("2");
        singlyLinkedList.add("3");
        singlyLinkedList.add("4");
       // singlyLinkedList.remove(3);


        SinglyLinkedList<String> singlyLinkedList1 = singlyLinkedList.copy();
       singlyLinkedList.add("6");

        Boolean result = singlyLinkedList.contains("3");

        System.out.println(result);
        System.out.println(singlyLinkedList.find("1"));
        singlyLinkedList.display();
        singlyLinkedList1.display();


        LinkedList<String> list = new LinkedList<String>();
        list.clone();
        list.add("1");
        list.add("2");
        list.add("3");

    //    System.out.println(list);
    }

}
