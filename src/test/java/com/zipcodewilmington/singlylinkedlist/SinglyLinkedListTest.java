package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void addTest() {
        //given
        SinglyLinkedList list = new SinglyLinkedList();

        //when
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int actual = list.size();
        int expected = 5;

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void containsTest1() {
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        Boolean expected = true;
        Boolean actual = list.contains(2);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTest2() {
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        Boolean check = list.contains(6);

        //then
        Assert.assertFalse(check);
    }

    @Test
    public void remove1() {
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        list.remove(2);
        int expected = list.size();
        int actual = 4;

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove2() {
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        list.remove(1);
        list.remove(2);

        int expected = list.size();
        int actual = 3;

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findTest1() {
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        int expected = list.find(2);
        int actual = 1;

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findTest2() {
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        int expected = list.find(6);
        int actual = -1;

        //then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getTest1(){
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(8);
        list.add(4);
        list.add(5);

        //when
        Object expected = list.get(2);
        Object actual = 8;

        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void copyTest(){
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        SinglyLinkedList newList = list.copy();
        Integer expected = list.size();
        Integer actual = newList.size();


        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void sort(){
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(4);

        //when
        list.sort();

        //then
        Assert.assertTrue(list.find(1) == 0);
        Assert.assertTrue(list.find(2) == 1);
        Assert.assertTrue(list.find(3) == 2);
        Assert.assertTrue(list.find(4) == 3);
        Assert.assertTrue(list.find(5) == 4);
    }
}
