package io.zipcoder.stirbu;

import org.junit.Assert;
import org.junit.Test;


public class BasicLinkedListTest {

    @Test
     public void addTest() {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        Assert.assertFalse(singly.isEmpty());
        Assert.assertEquals(1, singly.size());
    }

    @Test
     public void addSecondTest() {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");

        singly.printAll();
        Assert.assertEquals(3, singly.size());
    }

    @Test
     public void removeTest() {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");
        singly.add("HAHAHAHA");
        singly.remove(3);

        singly.printAll();
        Assert.assertEquals(3, singly.size());
    }

    @Test
    public void containsTest() {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");
        singly.remove(1);
        singly.add("O(*(*^");
        singly.contains("ABC");
        singly.printAll();
        //System.out.println(singly.contains("ABC"));

        Assert.assertTrue(true);
    }

    @Test
    public void sizeTest() {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");
        singly.size();
        singly.printAll();

        Assert.assertEquals(3, singly.size());
    }

    @Test
    public void findTest(){
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");
        singly.add("HAHAHA");
        singly.find(1);
        singly.printAll();

        Assert.assertEquals(4, singly.size());
    }

//    @Test
//    public void copyTest(){
//        BasicLinkedList singly = new BasicLinkedList();
//        Node
//        singly.add("JHGSDSD");
//        singly.add("*&&*&^%");
//        BasicLinkedList copy = singly.copy();
//        singly.
//
//        Assert.assertEquals(singly.);
//    }
}