package io.zipcoder.zhang;

import org.junit.Assert;
import org.junit.Test;

public class TestLinkedList {
    LinkedList<Integer> list = new LinkedList<>();

    @Test
    public void testAdd(){
        list.add(1);
        list.add(2);
        list.add(3);
        String expected = "1,2,3";
        Assert.assertEquals(expected, list.toString());
    }
    @Test
    public void testRemoveAt(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.removeAt(3);
        String expected ="1,2";
        Assert.assertEquals(expected, list.toString());

    }
    @Test
    public void testContains(){
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(true, list.contains(2));
    }
    @Test
    public void testFind(){
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(1,list.find(1));
    }
    @Test
    public void testSize(){
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(3,list.size());
    }
    @Test
    public void get(){
        list.add(1);
        list.add(2);
        list.add(3);
        int actual = list.get(2);
        Assert.assertEquals(2,actual);
    }
    @Test
    public void copy(){
        list.add(1);
        list.add(2);
        list.add(3);
        String expected = "1,2,3";
        Assert.assertEquals(expected,list.copy().toString());
    }
    @Test
    public void testSort(){
        list.add(6);
        list.add(2);
        list.add(4);
        String expected = "2,4,6";
        list.sort();
        Assert.assertEquals(expected, list.toString());
    }
    @Test
    public void testSortString(){
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Merin");
        list2.add("Lina");
        list2.add("Rob");
        String expected ="Lina,Merin,Rob";
        list2.sort();
        Assert.assertEquals(expected,list2.toString());

    }
}
