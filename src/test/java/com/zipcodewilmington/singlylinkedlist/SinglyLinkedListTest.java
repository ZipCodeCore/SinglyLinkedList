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
}
