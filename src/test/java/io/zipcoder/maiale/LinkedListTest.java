package io.zipcoder.maiale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LinkedListTest {

    LinkedBuilder<Integer> theList = new LinkedBuilder();

    @SuppressWarnings("unchecked")
    @Before
    public void setup() {

        theList.add(1);//0 index
        theList.add(2);//1
        theList.add(3);//2
        theList.add(4);//3


    }

    @Test
    public void addTest(){
        int expected = 4;
        int actual = theList.getTail().getData();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeTest() {
        int expected = 3;
        theList.remove(4);
        int actual = theList.getTail().getData();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void containsTest(){
        Assert.assertTrue(theList.contains(4));
        Assert.assertFalse(theList.contains(10));

    }

    @Test
    public void findTest(){
        int expected1 = 0;
        int expected2 = -1;
        int actual1 = theList.find(1);
        int actual2 = theList.find(10);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);

    }

    @Test
    public void sizeTest(){
        int expected = 4;
        int actual = theList.sizeOfList();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getTest(){
        int expected = 2;
        int actual = theList.get(1);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void copyTest(){
        LinkedBuilder expected = theList;
        LinkedBuilder<Integer> copiedList = new LinkedBuilder();
        LinkedBuilder actual = copiedList.copy(theList);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void sortTest(){
        theList.add(12);
        theList.add(8);
        theList.add(11);
        LinkedBuilder<Integer> sortedList = new LinkedBuilder();
        sortedList.sort(theList);
        int expected = 12;
        int actual = sortedList.getTail().getData();
        Assert.assertEquals(expected, actual);

    }
}
