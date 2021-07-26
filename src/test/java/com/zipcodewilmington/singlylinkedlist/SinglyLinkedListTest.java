package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void testAdd() {
        //given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 3;
        //when
        list.add(3);
        list.add(5);
        list.add(7);
        Integer actual = list.size();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        //given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 3;
        //when
        list.add(3);
        list.add(5);
        list.add(7);
        Integer actual = list.size();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFind() {
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer expected = 1;
        //when
        list.add("wine");
        list.add("coffee");
        list.add("tea");
        Integer actual = list.find("coffee");
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContains() {
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        //when
        list.add("wine");
        list.add("coffee");
        list.add("tea");
        //then
        Assert.assertTrue(list.contains("tea"));
    }

    @Test
    public void testRemove() {
        //given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 3;
        //when
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(2);
        list.remove(2);
        Integer actual = list.size();
        //then
        Assert.assertTrue(list.contains(5));
        Assert.assertFalse(list.contains(7));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        String expected = "wine";
        //when
        list.add("wine");
        list.add("coffee");
        list.add("tea");
        String actual = list.get(0);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCopy() {
        //given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 2;
        //when
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(2);
        SinglyLinkedList<Integer> newList = list.copy();
        Integer actual = newList.get(3);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSort() {
        //given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected0 = 1;
        Integer expected1 = 5;
        Integer expected2 = 8;
        Integer expected3 = 13;
        //when
        list.add(8);
        list.add(1);
        list.add(13);
        list.add(5);
        list.sort();
        Integer actual0 = list.get(0);
        Integer actual1 = list.get(1);
        Integer actual2 = list.get(2);
        Integer actual3 = list.get(3);
        //then
        Assert.assertEquals(expected0, actual0);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void testReverse() {
        //given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected0 = 1;
        Integer expected1 = 5;
        Integer expected2 = 8;
        Integer expected3 = 13;
        //when
        list.add(13);
        list.add(8);
        list.add(5);
        list.add(1);
        list.reverse();
        Integer actual0 = list.get(0);
        Integer actual1 = list.get(1);
        Integer actual2 = list.get(2);
        Integer actual3 = list.get(3);
        //then
        list.display();
        Assert.assertEquals(expected0, actual0);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void testSlice() {
        //given
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expected = 4;
        //when
        list.add(13);
        list.add(8);
        list.add(5);
        list.add(1);
        list.add(12);
        list.add(9);
        SinglyLinkedList<Integer> slicedList = list.slice(1, 4);
        Integer actual = slicedList.size();
        //then
        slicedList.display();
        Assert.assertEquals(expected, actual);
    }
}
