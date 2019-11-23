package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
        Integer expected = 1;
        assertEquals(expected, linkedList.getSize());
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


}

