package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void testSize(){
        SinglyLinkedList testList = new SinglyLinkedList();

        testList.addItem("First");
        testList.addItem("Second");
        testList.addItem("Third");

        Integer expected = 3;
        Integer actual = testList.getSize();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetValue(){
        SinglyLinkedList testList = new SinglyLinkedList();

        testList.addItem("First");
        testList.addItem("Second");
        testList.addItem("Third");

        String actual = (String) testList.getValue(1);
        String expected = "Second";
        Assert.assertEquals(expected,actual);

        actual = (String) testList.getValue(2);
        expected = "Third";
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void contains() {
        SinglyLinkedList testList = new SinglyLinkedList();

        testList.addItem("First");
        testList.addItem("Second");
        testList.addItem("Third");

        boolean actual = testList.contains("Second");
        Assert.assertTrue(actual);

        testList.addItem(3);
        testList.addItem(6);

        actual = testList.contains(3);
        Assert.assertTrue(actual);
    }

    @Test
    public void find() {

        SinglyLinkedList testList = new SinglyLinkedList();

        testList.addItem("First");
        testList.addItem("Second");
        testList.addItem("Third");

        Integer actual = testList.find("Second");
        Integer expected = 1;
        Assert.assertEquals(expected,actual);

        actual = testList.find("Boo");
        expected = -1;
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void removeItemLast() {

        SinglyLinkedList testList = new SinglyLinkedList();

        testList.addItem("First");
        testList.addItem("Second");
        testList.addItem("Third");

        testList.removeItem(2);

        Integer expected = -1;
        Integer actual = testList.find("Third");

        Assert.assertEquals(expected,actual);


    }
    @Test
    public void removeItemHead() {

        SinglyLinkedList testList = new SinglyLinkedList();

        testList.addItem("First");
        testList.addItem("Second");
        testList.addItem("Third");

        testList.removeItem(0);

        Integer expected = 0;
        Integer actual = testList.find("Second");

        Assert.assertEquals(expected,actual);


    }

    @Test
    public void removeItem() {

        SinglyLinkedList testList = new SinglyLinkedList();

        testList.addItem("First");
        testList.addItem("Second");
        testList.addItem("Third");

        testList.removeItem(1);

        Integer expected = 1;
        Integer actual = testList.find("Third");

        Assert.assertEquals(expected,actual);


    }
}
