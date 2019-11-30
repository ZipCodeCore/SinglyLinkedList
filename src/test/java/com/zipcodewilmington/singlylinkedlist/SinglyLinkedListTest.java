package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
    SinglyLinkedList<String> stringList = new SinglyLinkedList<>();

    @Before
    public void setUp() {
        intList = new SinglyLinkedList<>();
    }


    @Test
    public void emptySizeTest() {
        Integer expected = 0;
        Integer actual = intList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeThreeTest() {
        intList = new SinglyLinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        Integer expected = 3;
        Integer actual = intList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest() {
        intList = new SinglyLinkedList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        Integer expected = 1;
        Integer actual = intList.get(0);

        Integer expected2 = 2;
        Integer actual2 = intList.get(1);


        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);

    }

    @Test
    public void addTest() {
        intList = new SinglyLinkedList<>();
        intList.add(5);
        Integer expected = 5;
        Integer actual = intList.get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest2(){
        intList = new SinglyLinkedList<>();
        intList.add(10);
        intList.add(5);
        Integer actual = intList.size();
        Integer expected = 2;
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void containsTestFalse() {
        Assert.assertFalse(intList.contains(5));
    }

    @Test
    public void containsTestTrue() {
        intList.add(3);
        intList.add(4);
        intList.add(5);
        Assert.assertTrue(intList.contains(5));
    }


    @Test
    public void removeTest() {
        intList.add(3);
        intList.add(4);
        intList.add(5);

        intList.remove(1);

        Integer expected = 2;
        Integer actual = intList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest2() {
        intList.add(3);
        intList.add(4);
        intList.add(5);

        intList.remove(1);

        Integer expected = 5;
        Integer actual = intList.get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findTest() {
        stringList.add("needle");
        stringList.add("in");
        stringList.add("the");
        stringList.add("hay");

        Integer expected = 0;
        Integer actual = stringList.find("needle");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findTest2() {
        stringList.add("needle");
        stringList.add("in");
        stringList.add("the");
        stringList.add("hay");

        Integer expected = 3;
        Integer actual = stringList.find("hay");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findTest3() {
        stringList.add("needle");
        stringList.add("in");
        stringList.add("the");
        stringList.add("hay");

        Integer expected = -1;
        Integer actual = stringList.find("nope");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest() {
        intList.add(1);
        intList.add(2);
        intList.add(3);

        SinglyLinkedList<Integer> copy = intList.copy();

        Assert.assertEquals(intList.get(0), copy.get(0));
        Assert.assertEquals(intList.get(1), copy.get(1));
        Assert.assertEquals(intList.get(2), copy.get(2));
    }

    @Test
    public void copyStringTest() {
        stringList.add("plz");
        stringList.add("hlp");
        stringList.add("me");

        SinglyLinkedList<String> copy = stringList.copy();

        Assert.assertEquals(stringList.get(0), copy.get(0));
        Assert.assertEquals(stringList.get(1), copy.get(1));
        Assert.assertEquals(stringList.get(2), copy.get(2));
    }

    @Test
    public void sortNumTest() {
        intList.add(5);
        intList.add(8);
        intList.add(4);
        intList.add(2);
        intList.add(3);
        intList.add(6);
        intList.add(7);
        intList.add(1);

        intList.sort();

        Integer expectedFirst = 1;
        Integer actualFirst = intList.get(0);

        Integer expectedLast = 8;
        Integer actualLast = intList.get(7);

        Assert.assertEquals(expectedFirst, actualFirst);
        Assert.assertEquals(expectedLast, actualLast);
    }


    @Test
    public void sortAlphaTest() {
        stringList.add("E");
        stringList.add("F");
        stringList.add("C");
        stringList.add("G");
        stringList.add("D");
        stringList.add("B");
        stringList.add("A");

        stringList.sort();


        String expectedFirst = "A";
        String actualFirst = stringList.get(0);

        String expectedLast = "G";
        String actualLast = stringList.get(6);

        Assert.assertEquals(expectedFirst, actualFirst);
        Assert.assertEquals(expectedLast, actualLast);
    }


}