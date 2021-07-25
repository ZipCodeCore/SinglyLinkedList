package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

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
        //when
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(2);
        list.remove(2);
        //then
        Assert.assertTrue(list.contains(5));
        Assert.assertFalse(list.contains(7));
    }

}
