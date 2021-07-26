package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Nathan on 7/25/22.
 */
public class SinglyLinkedListTest {
    @Test
    public void testConstruction(){
        //when
        SinglyLinkedList<Integer> newList = new SinglyLinkedList<Integer>();
        //then
        Assert.assertTrue(newList instanceof SinglyLinkedList);
    }

    @Test
    public void testAddNext(){
        //given
        SinglyLinkedList<String> myList = new SinglyLinkedList<String>();
        //when
        myList.add("2");
        //then
        Assert.assertTrue(myList.contains("2"));
    }

    @Test
    public void addHeadTest(){
        //given
        SinglyLinkedList<Integer> myList = new SinglyLinkedList();
        //when
        myList.add(2);
        myList.addHead(1);
        Integer expected = 1;
        Integer actual = myList.get(0).getData();
        //then

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testContains(){
        //given
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.add(1);
        myList.add(2);
        //when
        boolean actual = myList.contains(2);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testRemoveTail(){
        //given
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.add(1);
        myList.add(2);
        //when
        myList.removeTail();
        Integer exp = 1;
        Integer act = myList.size();
        //then
        Assert.assertEquals(exp,act);
    }

    @Test
    public void testRemoveHead(){
        //given
        SinglyLinkedList myList = new SinglyLinkedList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        //when
        myList.removeHead();
        Integer exp = 2;
        Integer act = myList.size();
        //then
        Assert.assertEquals(exp,act);
    }

    @Test
    public void testRemove_firstIndex(){
        //given
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        //when
        newList.remove(0);
        Integer exp = 2;
        Integer act = newList.size();
        //then
        Assert.assertEquals(exp,act);
    }

    @Test
    public void testRemove_lastIndex(){
        //given
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        //when
        newList.remove(2);
        boolean actual = newList.contains(3);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testFindIndex(){
        //given
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        //when
        Integer actual = newList.findIndex(3);
        Integer expected = 2;
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testClone(){
        //given
        SinglyLinkedList newList = new SinglyLinkedList();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        //when
        SinglyLinkedList clone = newList.clone();
        //then
        clone.displayNodes();
        newList.displayNodes();
        Assert.assertNotEquals(clone, newList);
    }

    @Test
    public void testReverse(){
        //given
        SinglyLinkedList<Integer> newList = new SinglyLinkedList();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        //when
        newList.reverse();
        Integer expected = 3;
        Integer actual = newList.get(0).getData();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSort(){
        //given
        SinglyLinkedList<Integer> newList = new SinglyLinkedList();
        newList.add(5);
        newList.add(4);
        newList.add(3);
        newList.add(2);
        newList.add(1);
        //when
        newList.sort();
        //then
        newList.displayNodes();
    }

    @Test
    public void testSlice(){
        //given
        SinglyLinkedList<Integer> newList = new SinglyLinkedList<Integer>();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(5);
        newList.add(6);
        newList.add(7);
        newList.add(8);
        //when
        SinglyLinkedList<Integer> sliced = newList.slice(2,7);
        //then
        sliced.displayNodes();
    }




}
