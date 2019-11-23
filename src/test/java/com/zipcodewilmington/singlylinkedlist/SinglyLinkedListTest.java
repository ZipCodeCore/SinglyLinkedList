package com.zipcodewilmington.singlylinkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedTest;
import static org.junit.Assert.*;
/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

        LinkedList<String> list;

@Before
public void setUp() throws Exception {
        list = new LinkedList<String>();
        list.add("This");
        list.add("Is");
        list.add("Waaaaaaay");
        list.add("Too");
        list.add("Many");
        list.add("Tests");
        }

@After
public void tearDown() throws Exception {
        }

@Test
public void LinkedListGetLastTest() {
        assertEquals("Tests", list.getLast());
        }

@Test
public void LinkedListClearTest() {
        assertTrue(list.contains("Is"));
        }

@Test
public void LinkedListSetTest() {
        assertEquals("Tests", list.set(5, "Linked List Tests")):
        System.out.print(list); //Displays [This, Is, Waaaaaaay, Too, Many, Linked List Tests]
        }

@Test
public void LinkedListPeek() {
        assertEquals("This", list.peek()); //Retrieves, but does not remove, the head (first element) of this list.
        }

@Test
public void LinkedListPollTest() {
        assertEquals("This", list.poll()); // Retrieves and removes the head (first element) of this list.
        }
        }

