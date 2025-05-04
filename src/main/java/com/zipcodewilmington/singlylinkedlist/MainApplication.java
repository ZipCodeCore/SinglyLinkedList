package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        SinglyLinkedList doesThisWork = new SinglyLinkedList();
        doesThisWork.addNode(10);
        doesThisWork.addNode(9);
        doesThisWork.addNode(2);
        doesThisWork.addNode(146);
        doesThisWork.addNode(1245);
        doesThisWork.addNode(56);
        doesThisWork.addNode(4);
        doesThisWork.addNode(5);
        doesThisWork.addNode(90);
        doesThisWork.addNode(1);

        doesThisWork.display();
        System.out.println("\n" + "\n");

//        doesThisWork.sortLeastToGreatest();
//        doesThisWork.reverse().display();
        doesThisWork.sortGreatestToLeast();
    }
}
