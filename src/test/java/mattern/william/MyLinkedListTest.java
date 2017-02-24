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

    }

    @Test
    public void isEmptyTestTrue() throws Exception {
        assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyTestFalse() throws Exception {
        list.add(one);
        assertFalse(list.isEmpty());
    }

    @Test
    public void sizeTest() throws Exception {

    }

    @Test
    public void contains() throws Exception {

    }

    @Test
    public void find() throws Exception {

    }

    @Test
    public void copy() throws Exception {

    }

    @Test
    public void sort() throws Exception {

    }

}