import org.junit.Assert;
import org.junit.Test;

public class LinkedListBuilderTest {

    LinkedListBuilder<Integer> testList = new LinkedListBuilder<>();


    @Test
    public void testEmptyList(){

        LinkedListBuilder.Node expected = null;
        LinkedListBuilder.Node actual = testList.getHead();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testSingleNodeSize(){
        testList.add(4);
        int sizeExpected = 1;
        int sizeActual = testList.size();

        Assert.assertEquals(sizeExpected, sizeActual);
    }

    @Test
    public void testGetNodeValue(){
        testList.add(8);

        Integer expected = 8;
        Integer actual = testList.getHead().getValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMultipleNodeTail(){
        testList.add(8);
        testList.add(7);
        testList.add(2);
        testList.add(1);
        testList.add(1);

        Integer expected = 1;
        Integer actual = testList.getTail().getValue();
        // Same as Integer actual = testList.getHead().getNextNode().getValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemove(){
        testList.add(3);
        testList.add(8);
        testList.add(9);
        testList.add(4);

        testList.remove(3);

        Integer expected = 4;
        Integer actual = testList.get(3).getValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testContains(){
        testList.add(8);
        testList.add(9);
        testList.add(2);

        boolean expeded = true;
        boolean actual = testList.contains(2);

        Assert.assertEquals(expeded, actual);
    }

    @Test
    public void testFind(){
        testList.add(3);
        testList.add(9);
        testList.add(2);

        int expected = 2;
        int actual = testList.find(6);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCopy(){
        testList.add(8);
        testList.add(3);
        testList.add(0);
        testList.add(4);

        LinkedListBuilder<Integer> newList = testList.copy();

        String expected = "";
        String actual = newList.toString();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testCopiesAreIndependent(){
        testList.add(8);
        //testList.add(3);
//        testList.add(0);
//        testList.add(4);

        LinkedListBuilder<Integer> newList = testList.copy();

        newList.add(9);

        String  expected = "";
        String actual = newList.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortInteger(){
        testList.add(7);
        testList.add(2);
        testList.add(1);
        testList.add(8);
        testList.add(6);

        testList.sort();

        String expected = "";
        String actual = testList.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortStrings(){
        LinkedListBuilder<String> testListStrings = new LinkedListBuilder<>();

        testListStrings.add("banana");
        testListStrings.add("apple");
        testListStrings.add("elephant");
        testListStrings.add("frisbee");
        testListStrings.add("dog");
        testListStrings.add("cat");

        testListStrings.sort();

        String expected = "";
        String actual = testListStrings.toString();

        Assert.assertEquals(expected, actual);
    }

}