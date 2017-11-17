package com.pastelasgreg;

import com.patselasgreg.LinkedList;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;


public class LinkedListTest {


    @Test
    public void emptyListTest() {
        LinkedList testList = new LinkedList();

        LinkedList.Node expected = null;
        LinkedList.Node actual = testList.getHead();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void add() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(1);
        int expected = 1;
        int actual = testList.head.getValue();

        Assert.assertEquals(expected, actual);

    }


    @Test
    public void remove() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(32);
        testList.add(2);
        testList.add(99);
        testList.add(3);
        testList.remove(2);
        testList.remove(32);
        testList.remove(99);

        int expected = 3;
        int actual = testList.head.getNext().getValue();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void contains() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(23);
        testList.add(21);
        testList.add(19);

        boolean actualFalse = testList.contains(32);
        boolean actualtrue = testList.contains(21);
        Assert.assertFalse(actualFalse);
        Assert.assertTrue(actualtrue);
    }

    @Test
    public void find() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(23);
        testList.add(45);
        testList.add(231);
        testList.add(46);
        testList.add(47);

        int expected = 3;
        int actual = testList.find(46);

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void size() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(3);
        int expected =4;
        int actual = testList.size();

        Assert.assertEquals(expected,actual);
    }

     @Test
    public void get() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(23);
        testList.add(34);
        testList.add(32);
        testList.add(39);

        int expected = 39;
        int actual = testList.get(3).getValue();

        Assert.assertEquals(expected,actual);


    }

   @Test
    public void copy() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(23);
        testList.add(54);
        testList.add(99);
        testList.add(24);
        testList.add(99);
        testList.add(24);

        LinkedList copy = testList.copy();

       for(int i=0; i<testList.size()-1; i++) {
           Assert.assertTrue(testList.get(i).getValue() == copy.get(i).getValue());
       }

    }

    @Test
    public void sort() throws Exception {
        LinkedList testList = new LinkedList();

        testList.add(99);
        testList.add(31);
        testList.add(34);
        testList.add(22);
        testList.add(33);
        testList.add(4);

        testList.sort();

        String expected = "4, 22, 31, 33, 34, 99";
        Assert.assertEquals(expected, testList.get(0).getValue()+", "+testList.get(1).getValue()
                +", "+testList.get(2).getValue()+", "+testList.get(3).getValue()+", "+testList.get(4).getValue()+", "+testList.get(5).getValue());

    }





}