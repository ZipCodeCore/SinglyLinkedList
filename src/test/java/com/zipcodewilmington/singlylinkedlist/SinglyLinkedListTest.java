package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;
import java.lang.Integer;
import static org.junit.Assert.*;
/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {




@Test
public void ConstructorTest() {
        SinglyLinkedList<String >linkedList = new SinglyLinkedList<String>();
        String expected = "Charlotte is a Rock Star!";
        assertEquals(expected, linkedList.getHead().getData());
        }

@Test
public void addTest() {
        SinglyLinkedList<Integer>linkedList = new SinglyLinkedList<Integer>();
        linkedList.add(5000);
        linkedList.add(1000);
        Boolean actual = linkedList.contains(1);
        Assert.assertTrue(actual);
        }

@Test
public void RemoveTest() {
        SinglyLinkedList<String >linkedList = new SinglyLinkedList<String>();
        linkedList.add("5000");
        linkedList.add("1000");
        linkedList.add("5000");
        linkedList.add("1000");
        Boolean remove = linkedList.remove(1);

        assertTrue(remove);
        }

        @Test
        public void sizeTest1(){
                SinglyLinkedList<Integer >linkedList = new SinglyLinkedList<Integer>();

                linkedList.add(3);
                linkedList.add(4);
                linkedList.add(5);

                linkedList.contains(3);
                linkedList.contains(4);
                linkedList.contains(5);
                Integer expected = 3;
                Integer actual = linkedList.getSize();
                Assert.assertEquals(expected, actual);
        }

        @Test
        public void getByIndexTest(){
                SinglyLinkedList<Integer >linkedList = new SinglyLinkedList<Integer>();

                linkedList.add(1);
                Integer expected = 1;

                Node<Integer> actual = linkedList.getByIndex(0);

                Assert.assertEquals(expected, actual);
        }

        @Test
        public void findTest(){
                SinglyLinkedList<Integer >linkedList = new SinglyLinkedList<Integer>();

                linkedList.add(1);
                int expected = 0;

                int actual = linkedList.find(1);

                Assert.assertEquals(expected, actual);
        }

        @Test
        public void copyTest(){
                SinglyLinkedList<Integer >linkedList = new SinglyLinkedList<Integer>();

                SinglyLinkedList copyList = new SinglyLinkedList();
                linkedList.add(1);
                linkedList.copy(copyList);
                Node<Integer> expectedList1 = copyList.getByIndex(0);
                Node<Integer> expectedList2 = linkedList.getByIndex(0);
                Assert.assertEquals(expectedList1, expectedList2);
        }

        @Test
        public void sort(){
                SinglyLinkedList<Integer >linkedList = new SinglyLinkedList<Integer>();

                linkedList.add(4);
                linkedList.add(3);
                linkedList.add(2);
                linkedList.add(1);
                Integer expected1 = 1;
                Integer expected2 = 2;
                Integer expected3 = 3;
                Integer expected4 = 4;
                linkedList.sort();
                Node<Integer> actual1 = linkedList.getByIndex(0);
                Node<Integer> actual2 = linkedList.getByIndex(1);
                Node<Integer> actual3 = linkedList.getByIndex(2);
                Node<Integer> actual4 = linkedList.getByIndex(4);
                Assert.assertEquals(expected1,actual1);
                Assert.assertEquals(expected2,actual2);
                Assert.assertEquals(expected3,actual3);
                Assert.assertEquals(expected4,actual4);
        }
}

