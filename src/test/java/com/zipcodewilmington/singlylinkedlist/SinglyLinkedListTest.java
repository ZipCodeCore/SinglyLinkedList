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
        String expectedString = "0 Hello";
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void testAdd3() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("Hello");
        list.add("World");
        String actualString = list.toString();
        String expectedString = "0 Hello\n1 World";
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
        String expectedString = "0 World";
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
        String expectedString = "0 Hello\n1 World\n2 House";
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
        String expectedString = "0 World\n1 House";
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
    public void testGet() {

    }

    @Test
    public void testCopy() {

    }

    @Test
    public void testSort() {

    }

    @Test
    public void testReverse() {

    }

    @Test
    public void testSlice() {

    }



}
