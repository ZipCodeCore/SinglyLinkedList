package com.zipcodewilmington.singlylinkedlist;
import org.junit.Assert;
import org.junit.Test;



/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void testAdd() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        Integer expected = 2;
        // When
        Integer actual = singlyLinkedList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemove() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        // When
        singlyLinkedList.remove(1);
        Integer expectedSize = 1;
        Integer actualSize = singlyLinkedList.size();
        // Then
        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void testContains() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("one");
        singlyLinkedList.add("two");
        Boolean expected = true;
        // When
        Boolean actual = singlyLinkedList.contains("one");
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFind() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);
        Integer expectedIndex = 2;
        // When
        Object actualIndex = singlyLinkedList.find(3);
        // Then
        Assert.assertEquals(expectedIndex,actualIndex);
    }

    @Test
    public void testSize() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        // When
        Integer expectedSize = 2;
        Integer actualSize = singlyLinkedList.size();
        // Then
        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void testGet() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);

        // When
        Integer expectedElement = 2;
        Integer actualElement = (Integer) singlyLinkedList.get(1);

        // Then
        Assert.assertEquals(expectedElement, actualElement);

    }

    @Test
    public void testCopy() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);

        // When
        SinglyLinkedList newList = singlyLinkedList.copy();
        int singleSize = singlyLinkedList.size();
        int newListSize = newList.size();

        // Then
        Assert.assertEquals(singleSize, newListSize);
    }

    @Test
    public void testSort() {
        // Given
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(2);
        singlyLinkedList.add(1);
        singlyLinkedList.add(3);
        singlyLinkedList.add(5);
        singlyLinkedList.add(4);
        singlyLinkedList.add(6);

        // When
        singlyLinkedList.sort();

        // Then
        Assert.assertTrue(singlyLinkedList.find(1).equals(0));
        Assert.assertTrue(singlyLinkedList.find(2).equals(1));
        Assert.assertTrue(singlyLinkedList.find(3).equals(2));
    }
}
