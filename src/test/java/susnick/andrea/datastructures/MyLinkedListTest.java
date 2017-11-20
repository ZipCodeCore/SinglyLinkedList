package susnick.andrea.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class MyLinkedListTest<Integer> {

    MyLinkedList myLinkedList = new MyLinkedList<>();

    @Test
    public void sizeTest() throws Exception{
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int expected = 4;
        int actual = myLinkedList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTest() throws Exception{
        int expected = 2;
        myLinkedList.add(expected);
        int actual = (int) myLinkedList.root.getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest() throws Exception{
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int expected = 3;
        int actual = (int) myLinkedList.get(1).getValue();
        myLinkedList.remove(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTest() throws Exception{
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        Assert.assertTrue(myLinkedList.contains(2));
        Assert.assertFalse(myLinkedList.contains(10));

    }

    @Test
    public void findTest() throws Exception{
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int expected = 3;
        int actual = myLinkedList.find(5);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getTest() throws Exception{
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        int expected = 2;
        int actual = (int) myLinkedList.get(0).getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest() throws Exception{
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        MyLinkedList<Integer> copyOfMyLinkedList = myLinkedList.copy();
        Assert.assertEquals(myLinkedList.contains(3), myLinkedList.copy().contains(3));
    }
}