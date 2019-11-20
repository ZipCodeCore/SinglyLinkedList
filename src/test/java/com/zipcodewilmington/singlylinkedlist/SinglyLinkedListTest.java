package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList mylist;

    @Before
    public void setUp() throws Exception {
        mylist = new SinglyLinkedList();
        mylist.addNode(20);
        mylist.addNode(15);
        mylist.addNode(18);
    }

    @Test
    public void addNode() {
        mylist.addNode(82);
        Integer expected = 4;
        Integer actual = mylist.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNode() {
        Integer expected = 2;
        mylist.removeNode(0);
        Integer actual = mylist.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeNode2() {
        mylist.removeNode(1);
        Assert.assertFalse(mylist.contains(15));
    }

    @Test
    public void find() {
        Integer expected = -1;
        Integer actual = mylist.find(37);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void find2() {
        Integer expected = 2;
        Integer actual = mylist.find(18);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() {  //returns the element at the specified index
        Integer expected = 15;
        Integer actual = mylist.get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get2() {  //returns the element at the specified index
        Integer expected = -1;
        Integer actual = mylist.get(8);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size() {
        Integer expected = 3;
        Integer actual = mylist.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains() {
        boolean expected = true;
        boolean actual = mylist.contains(18);
        Assert.assertEquals(expected, actual);
    }

}

