package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void TestSize(){
        //given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Integer expected = 0;
        //when
        Integer actual = singlyLinkedList.size();
        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testAdd(){
        //given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addNode(1);
        singlyLinkedList.addNode(2);
        Integer expected = 2;
        //when
        Integer actual = singlyLinkedList.size();
        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFind(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Integer expectedInd = 2;
        singlyLinkedList.addNode("Hello");
        singlyLinkedList.addNode("World");
        singlyLinkedList.addNode("Zipcode");

        //When
        Object actual = singlyLinkedList.find("Zipcode");

        //then
        Assert.assertEquals(expectedInd,actual);

    }

    @Test
    public void testContains(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Boolean expected = true;
        singlyLinkedList.addNode("Hi");
        singlyLinkedList.addNode("Hello");

        //when
        Boolean actual = singlyLinkedList.contains("Hello");

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void testCopy(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addNode(2);
        singlyLinkedList.addNode(3);
        Integer expected = 2;

        //When
        Integer actual = singlyLinkedList.copy().size();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sort(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addNode(5);
        singlyLinkedList.addNode(4);
        singlyLinkedList.addNode(3);
        singlyLinkedList.addNode(2);
        Integer expected = 4;

        //When
        Integer actual = singlyLinkedList.size();

        //then
        Assert.assertEquals(expected,actual);



    }

}
