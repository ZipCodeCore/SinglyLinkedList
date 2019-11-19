package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList sll;

    @Before
    public void before(){
        sll = new SinglyLinkedList();
        sll.add(1);
        sll.add(10);
        sll.add(5);
        sll.add(3);
        sll.add(15);
    }

    @Test
    public void testAdd(){
        sll.add(11);
        Assert.assertTrue(sll.contains(11));
    }

    @Test
    public void testRemove(){
        sll.remove(10);
        Assert.assertFalse(sll.contains(10));
    }

    @Test
    public void testContains(){
        Assert.assertTrue(sll.contains(3));
    }

    @Test
    public void testFind(){
        Assert.assertEquals(2, sll.find(10));
        Assert.assertEquals(5, sll.find(15));
        Assert.assertEquals(1, sll.find(1));
    }

    @Test
    public void testSize(){
        Assert.assertEquals(5, sll.size());
    }

    @Test
    public void testSizeAndAdd(){
        sll.add(6);
        sll.add(18);

        Assert.assertEquals(7, sll.size());
    }

    @Test
    public void testGet(){
        Assert.assertEquals(10, sll.get(2));
        Assert.assertEquals(15, sll.get(5));
        Assert.assertEquals(1, sll.get(1));
    }

    @Test
    public void testCopy1(){
        SinglyLinkedList sllCopy = new SinglyLinkedList();
        sllCopy.copy();
        Assert.assertEquals(1, sllCopy.find(10));
    }
    @Test
    public void testCopy2(){
        SinglyLinkedList sllCopy = new SinglyLinkedList();

        sllCopy.add(1);
        sllCopy.add(10);
        sllCopy.add(5);
        sllCopy.add(3);
        sllCopy.add(15);

        Assert.assertEquals(2, sllCopy.find(10));
        Assert.assertEquals(10, sllCopy.get(2));
        Assert.assertNotEquals(2, sllCopy.get(15));
        Assert.assertNotEquals(10, sllCopy.get(3));
    }

    @Test
    public void testSort(){
        sll.sort();
        Assert.assertEquals(1, sll.get(1));
        Assert.assertEquals(3, sll.get(2));
        Assert.assertEquals(5, sll.get(3));
    }
}
