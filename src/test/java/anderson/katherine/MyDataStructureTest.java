package anderson.katherine;

import org.junit.Assert;
import org.junit.Test;

public class MyDataStructureTest {

    @Test
    public void testConstructor() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Assert.assertTrue(testDataStructure instanceof MyDataStructure<?>);
    }

    @Test
    public void sizeIsZeroTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Assert.assertEquals(0, testDataStructure.size());
    }

    @Test
    public void addAndCheckSizeTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        testDataStructure.add(Integer.valueOf(5));
        Assert.assertEquals(1, testDataStructure.size());
    }

    @Test
    public void addMultipleAndCheckSizeTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        for(int i = 0; i < 20; i++) {
            testDataStructure.add(Integer.valueOf(i * 5));
        }
        Assert.assertEquals(20, testDataStructure.size());
    }

    @Test
    public void findForNotInListTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        for(int i = 0; i < 20; i++) {
            testDataStructure.add(Integer.valueOf(i * 5));
        }
        Assert.assertEquals(-1, testDataStructure.find(7));
    }

    @Test
    public void findForInListTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        for(int i = 0; i < 20; i++) {
            testDataStructure.add(Integer.valueOf(i * 5));
        }
        Assert.assertEquals(5, testDataStructure.find(25));
    }

    @Test
    public void getTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        for(int i = 0; i < 20; i++) {
            testDataStructure.add(Integer.valueOf(i * 5));
        }
        int valueToGet = testDataStructure.get(3).getValue();

        Assert.assertEquals(15, valueToGet);
    }

    @Test
    public void containsTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        for(int i = 0; i < 20; i++) {
            testDataStructure.add(Integer.valueOf(i * 5));
        }

        Assert.assertTrue(testDataStructure.contains(30));
    }

    @Test
    public void doesNotContainTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        for(int i = 0; i < 20; i++) {
            testDataStructure.add(Integer.valueOf(i * 5));
        }

        Assert.assertFalse(testDataStructure.contains(11));
    }

    @Test
    public void removeTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Integer[] initialArray = {1, 3, 4, 9};
        for(int i = 0; i < initialArray.length; i++) {
            testDataStructure.add(initialArray[i]);
        }
        Integer[] expectedArray = {1, 3, 9};
        testDataStructure.remove(2);
        Integer[] actualArray = new Integer[3];
        for(int i = 0; i < testDataStructure.size(); i++) {
            actualArray[i] = testDataStructure.get(i).getValue();
        }
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void copyTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Integer[] initialArray = {1, 3, 4, 9};
        for(int i = 0; i < initialArray.length; i++) {
            testDataStructure.add(initialArray[i]);
        }
        MyDataStructure<Integer> iWantACopy = testDataStructure.copy();
        Integer[] actualArray = new Integer[4];
        for(int i = 0; i < iWantACopy.size(); i++) {
            actualArray[i] = iWantACopy.get(i).getValue();
        }
        Assert.assertArrayEquals(initialArray, actualArray);
    }

    @Test
    public void sortTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Integer[] initialArray = {14, 15, 11, 2};
        for(int i = 0; i < initialArray.length; i++) {
            testDataStructure.add(initialArray[i]);
        }

        Integer[] expectedArray = {2, 11, 14, 15};
        testDataStructure.sort();
        Integer[] actualArray = new Integer[4];
        for(int i = 0; i < testDataStructure.size(); i++) {
            actualArray[i] = testDataStructure.get(i).getValue();
        }
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void sortStringsTest() {
        MyDataStructure<String> testDataStructure = new MyDataStructure<String>();
        String[] initialArray = {"the", "test", "passes", "this", "is", "awesome"};
        for(int i = 0; i < initialArray.length; i++) {
            testDataStructure.add(initialArray[i]);
        }

        String[] expectedArray = {"awesome", "is", "passes", "test", "the", "this"};
        testDataStructure.sort();
        String[] actualArray = new String[6];
        for(int i = 0; i < testDataStructure.size(); i++) {
            actualArray[i] = testDataStructure.get(i).getValue();
        }
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void reverseTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Integer[] initialArray = {14, 15, 11, 2};
        for(int i = 0; i < initialArray.length; i++) {
            testDataStructure.add(initialArray[i]);
        }

        Integer[] expectedArray = {2, 11, 15, 14};
        testDataStructure.reverse();
        Integer[] actualArray = new Integer[4];
        for(int i = 0; i < testDataStructure.size(); i++) {
            actualArray[i] = testDataStructure.get(i).getValue();
        }
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void sliceTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Integer[] initialArray = {14, 15, 11, 2, 19, 11, 12};
        for(int i = 0; i < initialArray.length; i++) {
            testDataStructure.add(initialArray[i]);
        }

        Integer[] expectedArray = {11, 2, 19, 11};
        MyDataStructure<Integer> slicedList = testDataStructure.slice(2, 6);
        Integer[] actualArray = new Integer[4];
        for(int i = 0; i < slicedList.size(); i++) {
            actualArray[i] = slicedList.get(i).getValue();
        }
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void toStringTest() {
        MyDataStructure<Integer> testDataStructure = new MyDataStructure<Integer>();
        Integer[] initialArray = {14, 15, 11, 2, 19, 11, 12};
        for(int i = 0; i < initialArray.length; i++) {
            testDataStructure.add(initialArray[i]);
        }
        System.out.println(testDataStructure);
        String expected = "14 -> 15 -> 11 -> 2 -> 19 -> 11 -> 12";
        Assert.assertEquals(expected, testDataStructure.toString());
    }
}
