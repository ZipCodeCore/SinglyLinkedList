package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {
    public static void main(String[] args) {
        SinglyLinkedList doesThisWork = new SinglyLinkedList();
        doesThisWork.addNode(1);
        doesThisWork.addNode(29);
        doesThisWork.addNode(33);
        doesThisWork.addNode(45);
        doesThisWork.addNode(53);
        doesThisWork.addNode(62);
        doesThisWork.addNode(7);
        doesThisWork.addNode(100);
        doesThisWork.addNode(62);
        doesThisWork.addNode(87);

    //    doesThisWork.remove(3);
    //    remove method can reset the val, havent figured out how
    //    to remove it yet
        doesThisWork.display();
        System.out.println("\n" + "\n");

        System.out.println("Here's to hoping this works: " +
                doesThisWork.size());
    }
}
