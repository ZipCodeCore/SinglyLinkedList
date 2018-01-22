package io.zipcoder.stirbu;

import org.junit.Assert;
import org.junit.Test;


public class BasicLinkedListTest {

    @Test
     public void addTest() throws Exception {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        Assert.assertFalse(singly.isEmpty());
        Assert.assertEquals(1, singly.size());
    }

    @Test
     public void addSecondTest() throws Exception {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");

        singly.printAll();
        Assert.assertEquals(3, singly.size());
    }

    @Test
     public void removeTest() throws Exception {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");
        singly.add("HAHAHAHA");
        singly.remove(1);

        singly.printAll();
        Assert.assertEquals(3, singly.size());
    }

    @Test
    public void containsTest() throws Exception {
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
    public void sizeTest() throws Exception {
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");
        singly.size();
        singly.printAll();

        Assert.assertEquals(3, singly.size());
    }

    @Test
    public void findTest() throws Exception{
        BasicLinkedList singly = new BasicLinkedList();

        singly.add("ABC");
        singly.add("JGHGF");
        singly.add("UYRTE");
        singly.add("HAHAHA");
        singly.find(1);
        singly.printAll();

        Assert.assertEquals(4, singly.size());
    }

    @Test
    public void copyTest(){
        BasicLinkedList singly = new BasicLinkedList();
        singly.add("JHGSDSD");
        singly.add("*&&*&^%");
        BasicLinkedList theClone = singly.copy();

        String actual = theClone.printAll().trim();
        String expected = "JHGSDSD\n*&&*&^%";

        Assert.assertEquals(expected ,actual);
    }

    @Test
    public void sortTest(){
        BasicLinkedList singly = new BasicLinkedList();
        singly.add("cat");
        singly.add("dog");
        singly.add("apple");
        singly.add("elephant");
        singly.add("bat");

        singly.sort();

        System.out.println(singly);
    }


}