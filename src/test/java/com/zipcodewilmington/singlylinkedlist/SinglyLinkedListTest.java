package com.zipcodewilmington.singlylinkedlist;
import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest{

    SinglyLinkedList newList;

    @Test
    public void testAdd() {

        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");
        newList.add("Cow");
        newList.add("Fish");

        Assert.assertEquals(4, newList.size());
    }

    @Test
    public void testRemove() {

        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");
        newList.add("Cow");
        newList.add("Fish");

        Assert.assertTrue(newList.remove(0));
        System.out.println(newList.toString());

        Assert.assertEquals(3, newList.size());
    }

    @Test
    public void testContains() {

        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");
        newList.add("Cow");
        newList.add("Fish");

        Assert.assertTrue(newList.contains("Cat"));
    }

    @Test
    public void testFind() {

        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");
        newList.add("Cow");
        newList.add("Fish");

        Assert.assertEquals(1, newList.find("Dog"));
    }

    @Test
    public void testSize() {

        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");

        Assert.assertEquals(2, newList.size());
    }

    @Test
    public void testGet() {

        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");
        newList.add("Cow");
        newList.add("Fish");
        Node actual = newList.get(3);

        Assert.assertEquals("Fish", actual.getData());
    }

    @Test
    public void testCopy(){
        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");
        newList.add("Cow");
        newList.add("Fish");

        Assert.assertEquals(newList, newList.copy());
    }

    @Test
    public void testToString() {

        newList = new SinglyLinkedList();

        newList.add("Cat");
        newList.add("Dog");
        newList.add("Cow");
        newList.add("Fish");

        System.out.println(newList.toString());
    }
}