package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;

import org.junit.Test;

import javax.xml.soap.Node;
import java.lang.annotation.Target;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {


    @Test
    public void TestAdd(){
        //given
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.addNode(2);
        singlyLinkedList.addNode(3);
        Integer expected=2;
        //when
        Integer actual= singlyLinkedList.nodeSize();
        //then
        Assert.assertEquals(expected,actual);

    }
@Test
    public void TestSize(){
        //given
    SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
    singlyLinkedList.addNode("hi");
    singlyLinkedList.addNode("hello");
    Integer expected=2;

    //when
    Integer actual= singlyLinkedList.nodeSize();

    //then
    Assert.assertEquals(expected,actual);
}

@Test
    public void TestFind(){
        //given
    SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
    Integer expectedIndex=2;
    singlyLinkedList.addNode("hi");
    singlyLinkedList.addNode("hello");
    singlyLinkedList.addNode("vanakkam");
    //when
    Object actual=singlyLinkedList.find("vanakkam");
    //then
    Assert.assertEquals(expectedIndex,actual);
    }

    @Test
    public void TestContains(){
        //given
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.addNode("hi");
        singlyLinkedList.addNode("hello");
        Boolean expected=true;

        //when
        Boolean actual=singlyLinkedList.contains("hello");

        //then
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void copy(){
        //given
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.addNode(2);
        singlyLinkedList.addNode(3);
        Integer expected=2;

        //when
     Integer actual=  singlyLinkedList.copy().nodeSize();

        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sort(){
        //given
        SinglyLinkedList singlyLinkedList=new SinglyLinkedList();
        singlyLinkedList.addNode(5);
        singlyLinkedList.addNode(4);
        singlyLinkedList.addNode(3);
        singlyLinkedList.addNode(2);
        Integer expected=4;
        Integer actual=singlyLinkedList.nodeSize();
        Assert.assertEquals(expected,actual);
    }
}
