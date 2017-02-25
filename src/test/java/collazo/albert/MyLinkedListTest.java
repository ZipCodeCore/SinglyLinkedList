package collazo.albert;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MyLinkedListTest {

    MyLinkedList<Integer> myLinkedList;

    @Before
    public void setup(){
        myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
    }

    @Test
    public void addTest(){
        Integer expected = 2;
        Integer actual = myLinkedList.get(1);
        assertEquals(expected,actual);
    }

    @Test
    public void removeTest(){
      myLinkedList.remove(2);
      Integer expected = 1;
      Integer actual = myLinkedList.size();
      assertEquals(expected, actual);
    }

    @Test
    public void containsTest(){
        assertTrue(myLinkedList.contains(1));
        assertFalse(myLinkedList.contains(3));
    }

    @Test
    public void findTest(){
        Integer expected = 1;
        Integer actual = myLinkedList.find(2);
        assertEquals(expected,actual);
    }

    @Test
    public void sizeTest(){
        Integer expected = 2;
        Integer actual = myLinkedList.size();
        assertEquals(expected,actual);
    }

    @Test
    public void getTest(){
        Integer expected = 1;
        Integer actual = myLinkedList.get(0);
        assertEquals(expected,actual);
    }

}
