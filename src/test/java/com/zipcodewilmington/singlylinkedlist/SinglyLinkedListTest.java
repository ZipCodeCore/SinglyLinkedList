package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    //SinglyLinkedList<String> sl =new SinglyLinkedList<String>();

    @Test
    public void addNodeTest() {
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();

        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("Fish");
        int expected = 4;
        int actual = sl.size;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeNodeTest() {
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();

        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("Fish");
        int expected = 3;
        sl.remove("Cow");
        int actual = sl.size;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containTest() {
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();

        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("fish");
        Boolean actual1 = sl.contains("lion");
        Boolean actual2 = sl.contains("fish");
        Assert.assertFalse(actual1);
        Assert.assertTrue(actual2);
    }

    @Test
    public void findTest1() {
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();

        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("fish");

        Integer actual2 = sl.find("tiger");
        Integer expected2 = -1;


        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void findTest2() {
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();
        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("fish");
        Integer expected1 = 0;
        Integer actual1 = sl.find("Cat");
        Assert.assertEquals(expected1,actual1);
    }

    @Test
    public void sizeTest(){
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();
        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("fish");
        Integer expected = 4;
        Integer actual = sl.size();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void findByIndexTest(){
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();
        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("fish");
        Assert.assertEquals("Cow",sl.findByIndex(2));

    }
    @Test
    public void cloneTest(){
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();
        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("fish");
        //when
        SinglyLinkedList<String> linkedList1 = null;
        try{
            linkedList1 = (SinglyLinkedList<String>) sl.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        //then
        Assert.assertEquals(sl.toString(), linkedList1.toString());


    }
    @Test
    public void reverseTest(){
        SinglyLinkedList<String> sl = new SinglyLinkedList<String>();
        sl.add("Cat");
        sl.add("Dog");
        sl.add("Cow");
        sl.add("fish");
        Assert.assertEquals("fish",sl.reverse(sl.getHead()).getData());
    }



}