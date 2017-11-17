package io.zipcoder.datastructures;

import org.junit.Assert;
import org.junit.Test;
import sun.awt.image.ImageWatched;

public class LinkedListTest {

    //Given
    //When
    //Then

    @Test
    public void testNewListHasSize0 (){
        LinkedList<Integer> list = new LinkedList<>();

        int expectedSize = 0;
        int actualSize = list.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testAddIncreasesSizeByOne (){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);

        int expectedSize = 1;
        int actualSize = list.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testSizeAddIncreasesFive (){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }

        System.out.println();

        int expectedSize = 5;
        int actualSize = list.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testRemoveHead (){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }
        list.remove(0);

        int expectedSize = 4;
        int actualSize = list.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testRemoveTail (){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }
        list.remove(4);

        int expectedSize = 4;
        int actualSize = list.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testRemoveMid (){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }
        list.remove(2);

        int expectedSize = 4;
        int actualSize = list.size();

        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveOutOfBounds (){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }
        list.remove(10);
    }

    @Test
    public void testContains (){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            list.add(i);
        }

        Assert.assertTrue(list.contains(3));
        Assert.assertFalse(list.contains(10));
    }

    @Test
    public void testFind (){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 10; i < 15; i++){
            list.add(i);
        }

        int expectedIndex = 3;
        int actualIndex = list.find(13);

        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testGet(){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 10; i < 15; i++){
            list.add(i);
        }

        int expectedVal = 13;
        int actualVal = list.get(3);

        Assert.assertEquals(expectedVal, actualVal);
    }

    @Test
    public void testCopy (){
        LinkedList<Integer> originalList = new LinkedList<>();
        for(int i = 10; i < 15; i++){
            originalList.add(i);
        }

        LinkedList<Integer> newList = originalList.copy();

        Assert.assertNotEquals(originalList, newList);

        Integer originalListsize = 5;
        Assert.assertEquals(originalListsize, newList.size());

        int i = 0;
        while(i < newList.size()) {
            Assert.assertEquals(originalList.get(i), newList.get(i));
            i++;
        }
    }

    @Test
    public void testSort (){
        LinkedList<Integer> originalList = new LinkedList<>();
            originalList.add(11);
            originalList.add(13);
            originalList.add(10);
            originalList.add(14);
            originalList.add(12);

        originalList.sort();

        //System.out.println(originalList.toString()+"\n\n");

        LinkedList<Integer> compareToList = new LinkedList<>();
        for(int i = 10; i <= 14; i++){
            compareToList.add(i);
        }
        //System.out.println(compareToList.toString()+"\n\n");

        int i = 0;
        //System.out.println(originalList.size());
        while(i < originalList.size()) {
            //System.out.println(i);
            //System.out.println(originalList.get(i)+" "+compareToList.get(i));
            Assert.assertEquals(compareToList.get(i), originalList.get(i));
            i++;
        }
    }

    /*
    @Test
    public void testReverse(){
        LinkedList<Integer> originalList = new LinkedList<>();
        for(int i = 10; i <= 14; i++){
            originalList.add(i);
        }

        originalList.reverse();

        LinkedList<Integer> compareToList = new LinkedList<>();
        for(int i = 14; i >= 10; i--){
            compareToList.add(i);
        }

        int i = 0;
        while(i < originalList.size()) {
            Assert.assertEquals(originalList.get(i), compareToList.get(i));
            i++;
        }
    }
    //*/

    @Test
    public void testSlice(){
        LinkedList<Integer> originalList = new LinkedList<>();
        for(int i = 10; i <= 14; i++){
            originalList.add(i);
        }

        LinkedList<Integer> slicedList = originalList.slice(1, 3);

        LinkedList<Integer> compareToList = new LinkedList<>();
        for(int i = 11; i <= 13; i++){
            compareToList.add(i);
        }

        int i = 0;
        while(i < slicedList.size()) {
            Assert.assertEquals(slicedList.get(i), compareToList.get(i));
            i++;
        }
    }
}
