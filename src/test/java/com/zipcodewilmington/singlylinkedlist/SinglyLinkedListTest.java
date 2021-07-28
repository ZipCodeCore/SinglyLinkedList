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
        singlyLinkedList.remove(2);
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
        singlyLinkedList.add("one");
        singlyLinkedList.add("two");
        singlyLinkedList.add("three");
        Integer expectedIndex = 1;
        // When
        Object actualIndex = singlyLinkedList.find("three");
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

        // When

        // Then

    }

    @Test
    public void testSort() {
        // Given

        // When

        // Then

    }
}
