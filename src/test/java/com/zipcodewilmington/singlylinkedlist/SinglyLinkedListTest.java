package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void testConstructor() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer actual = list.size();
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLast1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        String actual = list.getLast().getData();
        String expected = "Hello";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLast2() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        String actual = list.getLast().getData();
        String expected = "World";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAdd1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        Integer actualSize = list.size();
        Integer expectedSize = 2;
        Assert.assertEquals(expectedSize, actualSize);

    }

    @Test
    public void testAdd2() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        String actualString = list.toString();
        String expectedString = "0 Hello\n";
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testAdd3() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        String actualString = list.toString();
        String expectedString = "0 Hello\n1 World\n";
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testRemove1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.remove("Hello");
        Integer actualSize = list.size();
        Integer expectedSize = 1;
        Assert.assertEquals(expectedSize, actualSize);
    }
    @Test
    public void testRemove2() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.remove("Hello");
        String actualString = list.toString();
        String expectedString = "0 World\n";
        Assert.assertEquals(expectedString, actualString);
    }
    @Test
    public void testRemove3() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        list.add("Java");
        list.remove("Java");
        String actualString = list.toString();
        String expectedString = "0 Hello\n1 World\n2 House\n";
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testRemove4() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        list.add("Java");
        list.remove("Java");
        list.remove("Hello");
        String actualString = list.toString();
        String expectedString = "0 World\n1 House\n";
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testContains1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        Assert.assertTrue(list.contains("World"));
    }

    @Test
    public void testContains2() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        Assert.assertFalse(list.contains("Glup"));
    }

    @Test
    public void testFind1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        Integer actual = list.find("World");
        Integer expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFind2() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        Integer actual = list.find("House");
        Integer expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer actual = list.size();
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize2() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        Integer actual = list.size();
        Integer expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize3() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        for (int i = 0; i < 44; i++) {
            list.add("element"+i);
        }
        Integer actual = list.size();
        Integer expected = 44;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        String actual = list.get(1);
        String expected = "World";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet2() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        String actual = list.get(42);
        Assert.assertEquals(null, actual);
    }

    @Test
    public void testCopy() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        list.add("House");
        SinglyLinkedList<String> newList = list.copy();
        Assert.assertEquals(list, newList);
    }

    @Test
    public void testSort1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Apple");
        list.add("Horse");
        list.add("Train");
        list.add("Banana");
        list.add("Gibraltar");
        SinglyLinkedList<String> sortedList = list.sort();
        String actual = sortedList.toString();
        String expected = "0 Apple\n1 Banana\n2 Gibraltar\n3 Horse\n4 Train\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSort2() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.add(4);
        list.add(7);
        list.add(2);
        list.add(6);
        list.add(3);
        SinglyLinkedList<Integer> sortedList = list.sort();
        String actual = sortedList.toString();
        String expected = "0 2\n1 3\n2 4\n3 6\n4 7\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReverse1() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Apple");
        list.add("Horse");
        list.add("Train");
        list.add("Banana");
        list.add("Gibraltar");
        String actual = list.reverse().toString();
        String expected = "0 Gibraltar\n1 Banana\n2 Train\n3 Horse\n4 Apple\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSlice() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Apple");
        list.add("Horse");
        list.add("Train");
        list.add("Banana");
        list.add("Gibraltar");
        String actual = list.slice(0,2).toString();
        String expected = "0 Apple\n1 Horse\n";
        Assert.assertEquals(expected, actual);
    }

}