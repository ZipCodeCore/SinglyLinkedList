package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addNodeTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.addNode("Hey");
        String expected = "Hey";

        //then
        String actual = testString.get(0);
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void addNodeTest2(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.addNode("Hey");
        int expected = 1;

        //then
        int actual = testString.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addNodeTest3(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.addNode("Hey");
        testString.addNode("there");
        int expected = 2;

        //then
        int actual = testString.size();
        Assert.assertEquals(expected, actual);
    }



    @Test (expected = UnsupportedOperationException.class)
    public void sliceTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.slice(3,5);

        //then
        //Assert.assertEquals(expected, actual);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void removeExceptionTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.remove("Hey");

    }

    @Test
    public void removeFirstTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");

        //when
        testString.remove("Hey");
        String actual = testString.get(0);

        //then
        String expected = "there";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeSecondTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");
        testString.addNode("Delilah");

        //when
        testString.remove("there");
        String actual = testString.get(0);

        //then
        String expected = "Hey";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeCheckThirdTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");
        testString.addNode("Delilah");

        //when
        testString.remove("there");
        String actual = testString.get(1);

        //then
        String expected = "Delilah";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void containsTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");

        //when
        boolean contains = testString.contains("there");

        //then
        Assert.assertTrue(contains);

    }
}
