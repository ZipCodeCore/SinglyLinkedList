
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyDataStructuresTest {
    MyDataStructures<Integer> testData;
    @Before
    public void setUp(){
        testData = new MyDataStructures<>();
        testData.add(8);    //index 0
        testData.add(9);    //index 1
        testData.add(10);   //index 2
        testData.add(11);   //index 3
        testData.add(7);    //index 4
        testData.add(6);    //index 5
        testData.add(5);    //index 6
    }
    @After
    public void close(){
        testData.clear();
    }

    @Test
    public void testAdd(){
        int expected = 1;
        testData = new MyDataStructures<>();
        testData.add(expected);

        int actual = testData.getHead().getInfo();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getLastNode(){
        int expected = 5;

        int actual = testData.getLastNode().getInfo();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sizeTest(){
        int expected = 7;

        int actual = testData.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getByIndexTest(){
        int expected = 10;

        int actual = testData.get(2).getInfo();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeTest(){
        int beforeExpected = 10;
        int afterExpected = 11;

        int beforeActual = testData.get(2).getInfo();
        testData.remove(2);
        int afterActual = testData.get(2).getInfo();

        Assert.assertEquals(beforeExpected,beforeActual);
        Assert.assertEquals(afterExpected,afterActual);
    }

    @Test
    public void containsTestTrue(){
        Assert.assertTrue(testData.contains(10));
    }

    @Test
    public void containsTestFalse(){
        Assert.assertFalse(testData.contains(12));
    }

    @Test
    public void findByInfoTest(){
        int expected = 2;

        int actual = testData.find(10);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSizeTest(){
        int expected = 7;

        int actual = testData.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void copyTest(){
        MyDataStructures<Integer> copyData = testData.copy();
        Assert.assertTrue(testData.find(10) == copyData.find(10));
        testData.remove(2);
        Assert.assertFalse(testData.find(10) == copyData.find(10));
    }

    @Test
    public void printTest(){
        String expected = "8 9 10 11 7 6 5 ";

        String actual = testData.toString();

        Assert.assertEquals(expected,actual);
    }

    //      Private method
//    @Test
//    public void swapTest(){
//        String expected = "9 8 10 11 7 6 5 ";
//
//        testData.swap(testData.get(0),testData.get(1));
//
//        String actual = testData.toString();
//
//        Assert.assertEquals(expected,actual);
//    }

    @Test
    public void sortTest(){
        String expected = "5 6 7 8 9 10 11 ";

        testData.sort();

        String actual = testData.toString();

        Assert.assertEquals(expected,actual);
    }
}
