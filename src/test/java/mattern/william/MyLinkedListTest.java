package mattern.william;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 2/24/17.
 */
public class MyLinkedListTest {
    MyLinkedList<String> list;
    String one = "One";
    String two = "Two";
    String three = "Three";
    String four = "Four";
    String five = "Five";

    @Before
    public void setUp() throws Exception {
        list = new MyLinkedList<String>();
        list.add(one);
    }

    @Test
    public void isEmptyTestFalse() throws Exception {
        assertFalse(list.isEmpty());
    }

    @Test
    public void sizeTest() throws Exception {
        assertEquals(1,list.size());
        list.add(two);
        assertEquals(2,list.size());
        list.add(three);
        assertEquals(3,list.size());
    }

    @Test
    public void containsTest() throws Exception {
        assertTrue(list.contains(one));
        assertFalse(list.contains(two));
        list.add(two);
        assertTrue(list.contains(two));
    }

    @Test
    public void findTest() throws Exception {
        list.add(two);
        list.add(three);
        assertEquals(0,list.find(one));
        assertEquals(2,list.find(three));
        assertEquals(1,list.find(two));
        assertEquals(-1,list.find(five));
    }

    @Test
    public void getTest() throws Exception {
        list.add(two);
        list.add(three);
        assertEquals(one,list.get(0));
        assertEquals(two, list.get(1));
        assertEquals(three,list.get(2));
    }

    @Test
    public void copy() throws Exception {
        list.add(two);
        list.add(three);
        MyLinkedList<String> listCopy = list.copy();
        String expected = "Three", actual = listCopy.get(2);
        assertEquals(expected, actual);
    }

    @Test
    public void sort() throws Exception {

    }

}