package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void TestAddNode() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addNode(1);
        list.addNode(2);
        list.addNode(3);

        Integer expected = 3;
        Integer actual = list.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestFind() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        list.addNode("Skyrim");
        list.addNode("Fallout");
        list.addNode("PipMAN");

        Integer expected = 2;
        Integer actual = list.find("PipMAN");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestRemove() {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();

        list.addNode("Skyrim");
        list.addNode("Fallout");
        list.addNode("PipMAN");
        list.addNode("DankBrotherhood");
        list.addNode("ArgonianMaid");

        list.remove("DankBrotherhood");
        Integer expected = 4;
        Integer actual = list.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestCopy() {
        SinglyLinkedList<Double> list = new SinglyLinkedList<Double>();

        list.addNode(4.0);
        list.addNode(8.0);
        list.addNode(6.0);
        list.addNode(9.0);
        list.addNode(11.0);

        SinglyLinkedList<Double> newList = list.copy();
        Integer expected = 5;
        Integer actual = newList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSort() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addNode(4);
        list.addNode(8);
        list.addNode(6);
        list.addNode(9);
        list.addNode(11);

        list.sort();
        Integer expected = 6;
        Integer actual = list.get(1);

        Assert.assertEquals(expected, actual);
    }
}
