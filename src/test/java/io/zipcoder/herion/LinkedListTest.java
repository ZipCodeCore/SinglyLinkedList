package io.zipcoder.herion;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class LinkedListTest {

    LinkedList myList = new LinkedList();

    @Test
    public void addTest() {

        Object expected = "hello world";

        Assert.assertEquals(expected, myList.add("hello world").getVal());

    }

    @Test(expected = NoSuchElementException.class)
    public void removeThrowsNoSuchElementExceptionTest() {

        myList.head = null;
        myList.remove(1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeThrowsIndexOutOfBoundsExceptionTest() {

        myList.add(1);
        myList.remove(-1);

    }

    @Test
    public void removeTest() {

        myList.add("hello world");
        myList.add("foo");
        myList.add("bar");
        myList.remove(2);

        int expected = -1;
        int actual = myList.find("foo");


        Assert.assertEquals(expected, actual);

    }

    @Test(expected = NoSuchElementException.class)
    public void findThrowsNoSuchElementExceptionTest() {

        myList.head = null;
        myList.find(1);

    }

    @Test
    public void findTest() {

        myList.add("hello world");
        myList.add("foo");
        myList.add("bar");

        int expected = 2;
        int actual = myList.find("foo");

        Assert.assertEquals(expected, actual);

    }

    @Test(expected = NoSuchElementException.class)
    public void containsThrowsNoSuchElementExceptionTest() {

        myList.head = null;
        myList.contains(1);
    }

    @Test
    public void containsIsTrueTest() {

        myList.add("hello world");
        myList.add("foo");
        myList.add("bar");

        boolean expected = true;
        boolean actual = myList.contains("foo");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsIsFalseTest() {

        myList.add("hello world");
        myList.add("foo");
        myList.add("bar");

        boolean expected = false;
        boolean actual = myList.contains("dog");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeEmptyListTest() {

        int expected = 0;
        int actual = myList.size();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void sizeListNotEmptyTest() {

        myList.add(1);

        int expected = 1;
        int actual = myList.size();

        Assert.assertEquals(expected, actual);


    }

    @Test(expected = NoSuchElementException.class)
    public void getThrowsNoSuchElementExceptionTest() {

        myList.head = null;
        myList.get(1);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getThrowsIndexOutOfBoundsExceptionTest() {

        myList.add(1);
        myList.get(-1);

    }

    @Test
    public void getTest() {

        myList.add("hello world");
        myList.add("foo");
        myList.add("bar");

        String expected = "foo";

        Assert.assertEquals(expected, myList.get(2).getVal());
    }

    @Test(expected = NoSuchElementException.class)
    public void copyThrowsNoSuchElementExceptionTest() {

        myList.head = null;
        myList.copy();

    }

    @Test
    public void copyTest() {

        myList.add("hello world");
        myList.add("foo");
        myList.add("bar");

        LinkedList linkedListCopy = myList.copy();

        Assert.assertEquals(myList.listSize, linkedListCopy.listSize);

    }

    @Test
    public void sortTest() {

        myList.add("C");
        myList.add("A");
        myList.add("A");
        myList.add("D");

        String expected = "AACD";
        String actual = myList.sort().toString();

        Assert.assertEquals(expected, actual);

    }
}
