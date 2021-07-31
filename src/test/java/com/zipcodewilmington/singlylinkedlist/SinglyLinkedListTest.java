package com.zipcodewilmington.singlylinkedlist;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int actual = list.size();
        int expected = 4;


        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

       list.remove(3);
       int expected = 3;
       int actual = list.size();

       Assert.assertEquals(expected, actual);

    }

    @Test
    public void containsTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Boolean actual = list.contains(3);

        Assert.assertTrue(actual);
        Assert.assertFalse(list.contains(6));
    }

    @Test
    public void sizeTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int expected = 6;
        int actual =list.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Integer actual = list.find(4);
        Integer expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        Integer actual = (Integer) list.get(4);
        Integer expected = 5;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        SinglyLinkedList newList = list.copy();
        Integer expected = list.size();
        Integer actual = newList.size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void sortTest(){
        // Given
        SinglyLinkedList list = new SinglyLinkedList();

        // When
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(9);
        list.add(7);
        list.add(6);

        list.sort();

        Assert.assertTrue(list.find(1) == 0);
        Assert.assertTrue(list.find(9) == 7);

    }

}
