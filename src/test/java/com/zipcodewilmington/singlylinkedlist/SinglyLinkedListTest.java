package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    @Test
    public void containsTest1(){
        //given
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //when
        Boolean check = list.contains(2);

        //then
        Assert.assertTrue(check);
    }
    @Test
    public void containsTest2(){
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

}
