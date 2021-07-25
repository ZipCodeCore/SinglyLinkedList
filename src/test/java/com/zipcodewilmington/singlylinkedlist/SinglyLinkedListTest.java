package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addNodeTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.addNode("Hey");
        String expected = "Hey";

        //then
        String actual = testString.get(0);
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void addNodeTest2(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.addNode("Hey");
        int expected = 1;

        //then
        int actual = testString.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addNodeTest3(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.addNode("Hey");
        testString.addNode("there");
        int expected = 2;

        //then
        int actual = testString.size();
        Assert.assertEquals(expected, actual);
    }



    @Test (expected = UnsupportedOperationException.class)
    public void sliceErrorTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.slice(3,5);

        //then
        //Assert.assertEquals(expected, actual);
    }

    @Test
    public void sliceTest(){
            //given
            SinglyLinkedList testString = new SinglyLinkedList();
            testString.addNode("Wonder");
            testString.addNode("if ");
            testString.addNode("this ");
            testString.addNode("will ");
            testString.addNode("be ");
            testString.addNode("cut");
            testString.addNode("right");
            String expected = "this will be cut";

            //when
            String actual = testString.slice(2,6);


            //then
            Assert.assertEquals(expected, actual);
        }


    @Test (expected = UnsupportedOperationException.class)
    public void removeExceptionTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();

        //when
        testString.remove("Hey");

    }

    @Test
    public void removeFirstTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");

        //when
        testString.remove(0);
        String actual = testString.get(0);

        //then
        Assert.assertNull(actual);

    }

    @Test
    public void removeSecondTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");
        testString.addNode("Delilah");

        //when
        testString.remove("there");
        String actual = testString.get(0);

        //then
        String expected = "Hey";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeCheckThirdTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");
        testString.addNode("Delilah");

        //when
        testString.remove("there");
        String actual = testString.get(2);

        //then
        String expected = "Delilah";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void checkNewListWithRemove(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");
        testString.addNode("Delilah");

        //when
        testString.remove("there");
        SinglyLinkedList actual = testString.remove("there");
        String actualString = actual.get(1);

        //then
        String expected = "Delilah";
        Assert.assertEquals(expected, actualString);

    }

    @Test
    public void containsTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");

        //when
        boolean contains = testString.contains("there");

        //then
        Assert.assertTrue(contains);

    }

    @Test
    public void findHelloAbsentTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");
        testString.addNode("Delilah");
        int expected = -1;

        //when
        int actual = testString.find("Hello");

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void findHelloPresentTest(){
        //given
        SinglyLinkedList testString = new SinglyLinkedList();
        testString.addNode("Hey");
        testString.addNode("there");
        testString.addNode("Delilah");
        testString.addNode("Hello");
        int expected = 3;

        //when
        int actual = testString.find("Hello");

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test (expected = UnsupportedOperationException.class)
    public void copyNothingTest(){
        //given
        SinglyLinkedList perfect = new SinglyLinkedList();

        //when
        perfect.copy();
    }

    @Test
    public void copyNotNullTest(){
        //given
        SinglyLinkedList perfect = new SinglyLinkedList();
        perfect.addNode("I");
        perfect.addNode("went");
        perfect.addNode("the");
        perfect.addNode("extra");
        perfect.addNode("mile");

        //when
        SinglyLinkedList copy = perfect.copy();
        String actual = copy.get(1);
        String expected = perfect.get(1);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest(){
        //given
        SinglyLinkedList testSort = new SinglyLinkedList();
        testSort.addNode("i");
        testSort.addNode("went");
        testSort.addNode("the");
        testSort.addNode("extra");
        testSort.addNode("mile");
        String expected = "extra";

        //when
        testSort.sort();
        String actual = testSort.get(0);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest(){
        //given
        SinglyLinkedList testSort = new SinglyLinkedList();
        testSort.addNode("i");
        testSort.addNode("went");
        testSort.addNode("the");
        testSort.addNode("extra");
        testSort.addNode("mile");
        String expected = "mile";

        //when
        SinglyLinkedList sorted = testSort.reverse();
        String actual = sorted.get(0);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setTest(){
        //given
        SinglyLinkedList setThis = new SinglyLinkedList();
        setThis.addNode("hope");
        setThis.addNode("this");
        setThis.addNode("doesnt");
        setThis.addNode("works");
        String reset = "does";

        //when
        setThis.setNode(2, reset);
        String actual = setThis.get(2);

        //then
        Assert.assertEquals(reset, actual);

    }

    @Test
    public void compareTest(){
        //given
        SinglyLinkedList setThis = new SinglyLinkedList();
        setThis.addNode("hope");
        setThis.addNode("this");
        setThis.addNode("doesnt");
        setThis.addNode("works");

        //when
        String first = setThis.get(1);
        String second = setThis.get(2);

        boolean actual = setThis.compareNodeValue(first, second);


        //then
        Assert.assertTrue(actual);

    }

}
