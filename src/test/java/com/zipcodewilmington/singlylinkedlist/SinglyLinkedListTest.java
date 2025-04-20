package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer expectedSize = 3;
        //when
        list.add("a");
        list.add("b");
        list.add("c");
        Integer actual = list.size();
        //then
        Assert.assertEquals(expectedSize, actual);
    }


    @Test
    public void removeTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer expectedSize = 2;
        //when
        list.add("a");
        list.add("b");
        list.add("c");
        list.remove(2);
        Integer actual = list.size();
        //then
        Assert.assertEquals(expectedSize, actual);

    }
    @Test
    public void sizeTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer expectedSize = 6;
        //when
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        Integer actual = list.size();
        //then
        Assert.assertEquals(expectedSize, actual);

    }

    @Test
    public void containsTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        //when
        list.add("a");
        list.add("b");
        list.add("c");
        Boolean actual = list.contains("b");
         //then
        Assert.assertTrue(actual);

    }

    @Test
    public void findTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer expectedIndex = 2;
        //when
        list.add("a");
        list.add("b");
        list.add("c");
        Integer actual = list.find("c");
        //then
        Assert.assertEquals(expectedIndex, actual);

    }

    @Test
    public void getTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
       String expected = "c";
        //when
        list.add("a");
        list.add("b");
        list.add("c");

        String actual = list.get(2).data;
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest(){
        //given
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        Integer expectedSize = 3;
        //when
        list.add("a");
        list.add("b");
        list.add("c");
        SinglyLinkedList<String> list2 = list.copy();
        list.add("d"); //added after copy to test if it would be added to copy
        Integer actual = list2.size();
        //then
        Assert.assertEquals(expectedSize, actual);

    }

}
