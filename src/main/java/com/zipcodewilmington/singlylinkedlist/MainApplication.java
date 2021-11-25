package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {

    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("1");
        singlyLinkedList.add("2");
        singlyLinkedList.add("3");


        Boolean result = singlyLinkedList.contains("4");
        System.out.println(result);
        System.out.println(singlyLinkedList.find("1"));
    }

}
