package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addNodeTest () {
        SinglyLinkedList single = new SinglyLinkedList();
        Integer expected = 3;

        single.addNode(3);
        single.addNode(2);
        single.addNode(5);
        Integer actual = single.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest () {
        SinglyLinkedList single = new SinglyLinkedList();
        Integer expected = 0;
        Integer actual = single.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayTest () {
        SinglyLinkedList single = new SinglyLinkedList();
        single.addNode(3);
        single.addNode(2);
        single.addNode(5);

        // Visual test - display returns void
        single.display();
    }

    @Test
    public void removeTest() {
        SinglyLinkedList test = new SinglyLinkedList();
        test.addNode(3);
        test.addNode(6);
        test.addNode(4);
        test.addNode(1);
        test.addNode(8);

        SinglyLinkedList actual = test.remove(4);

        Assert.assertEquals(test.size() - 1, actual.size());
    }
}
