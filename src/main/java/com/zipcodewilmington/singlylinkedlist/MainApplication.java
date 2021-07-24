package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        SinglyLinkedList doesThisWork = new SinglyLinkedList();
        doesThisWork.addNode(10);
        doesThisWork.addNode(9);
        doesThisWork.addNode(8);
        doesThisWork.addNode(7);
        doesThisWork.addNode(6);
        doesThisWork.addNode(5);
        doesThisWork.addNode(4);
        doesThisWork.addNode(3);
        doesThisWork.addNode(2);
        doesThisWork.addNode(1);

        doesThisWork.splice(2,6).display();
    }
}
