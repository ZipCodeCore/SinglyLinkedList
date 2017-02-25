import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by randallcrame on 2/24/17.
 */
public class MyListedListTest {
    MyListedList<String> test, test2, test3;
    String item1, item2, item3;


    @Before
    public void setUp() {
        item1 = "First";
        item2 = "Second";
        item3 = "Third";
        test = new MyListedList<>();
        test2 = new MyListedList<>();
        test2.add(item1);
        test2.add(item2);
        test2.add(item3);
        test3 = test2;
        test3.add(item1);
        test3.add(item2);
        test3.add(item3);

    }

    @Test
    public void addTest() {
        test.add(item1);
        int expected = 1;
        int actual = test.size();
        assertEquals("Expected return of 1", expected, actual);
    }

    @Test
    public void add2Test() {
        test.add(item1);
        test.add(item2);
        int expected = 2;
        int actual = test.size();
        assertEquals("Expected return of 2", expected, actual);
    }

    @Test
    public void get0Test() {
        String expected = "First";
        String actual = test2.get(0);
        assertEquals("Expected return of 'First'", expected, actual);
    }

    @Test
    public void get1Test() {
        String expected = "Second";
        String actual = test2.get(1);
        assertEquals("Expected return of 'Second'", expected, actual);
    }

    @Test
    public void get2Test() {
        String expected = "Third";
        String actual = test2.get(2);
        assertEquals("Expected return of 'Third'", expected, actual);
    }

    @Test
    public void get3Test() {
        String actual = test2.get(3);
        assertNull("Expected return of 'null'", actual);
    }

    @Test
    public void removeTest() {
        test2.remove(0);
        int expected = 2;
        int actual = test2.size();
        assertEquals("Expected return of 2", expected, actual);

    }

    @Test
    public void removeHeadTest() {
        test2.remove(0);
        String expected = "Second";
        String actual = test2.get(0);
        assertEquals("Expected return of Second", expected, actual);
    }

    @Test
    public void removeMiddleTest() {
        test2.remove(1);
        String expected = "Third";
        String actual = test2.get(1);
        assertEquals("Expected return of Third", expected, actual);
    }

    @Test
    public void removeTailTest() {
        test2.remove(2);
        test2.add(item1);
        String expected = "First";
        String actual = test2.get(2);
        assertEquals("Expected return of First", expected, actual);
    }

    @Test
    public void containsTrueTest() {
        boolean actual = test2.contains("Second");
        assertTrue("Expected return True", actual   );
    }

    @Test
    public void containFalseTest() {
        boolean actual = test2.contains("11");
        assertFalse("Expected return False", actual);
    }

    @Test
    public void findPositiveTest(){
        int expected = 2;
        int actual = test2.find("Third");
        assertEquals("Expected return of 2", expected, actual);
    }

    @Test
    public void findNegativeTest(){
        int expected = -1;
        int actual = test2.find("11");
        assertEquals("Expected return of -1", expected, actual);
    }

    @Test
    public void copyTest(){
        int expected = 3;
        int actual = test2.copy().size();
        assertEquals("Expected return of 3", expected, actual);
    }

    @Test
    public void copyHeadTest(){
        String expected = "First";
        String actual = test2.copy().get(0);
        assertEquals("Expected return of First", expected, actual);
    }

    @Test
    public void sortTest(){
        test3.sort();
        String expected = "First";
        String actual = test3.get(1);
        assertEquals("Expected return of First",expected,actual);
    }

    @Test
    public void sort2Test(){
        test3.sort();
        String expected = "Second";
        String actual = test3.get(2);
        assertEquals("Expected return of Second",expected,actual);
    }

    @Test
    public void sort3Test(){
        test3.sort();
        String expected = "Second";
        String actual = test3.get(3);
        assertEquals("Expected return of Second",expected,actual);
    }
}