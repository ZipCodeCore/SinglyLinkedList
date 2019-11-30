package com.zipcodewilmington.singlylinkedlist;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest<AnyType> {
    @Test
    public void ConstructorTest(){

        String expected = "Sonia";
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>(expected);

        Assert.assertEquals(expected, linkedList.getHead().getData());
    }

    @Test
    public void testAdd(){
        //given
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<Integer>();

        //when
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(50);
        linkedList.add(70);
        Integer expected = 4;

        //then
        Assert.assertEquals(expected, linkedList.getSize());

    }

    @Test
    public void testRemove(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");

        //when
        Boolean remove = linkedList.remove(2);

        //then
        Assert.assertTrue(remove);

    }

    @Test
    public void testRemove2(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");

        //when
        linkedList.remove(2);

        //then
        Assert.assertFalse(linkedList.contains("Rajani"));
    }

    @Test
    public void testContain(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();

        //when
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");
        linkedList.add("Rashmi");
        System.out.println(linkedList.toString());
        //then
        Assert.assertTrue(linkedList.contains("Sonia"));
        Assert.assertTrue(linkedList.contains("Rajani"));
        Assert.assertTrue(linkedList.contains("Veer"));

    }

    @Test
    public void testFind(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();

        //when
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");

        //then
        Assert.assertEquals((Integer)1, linkedList.find("Sonia"));
        Assert.assertEquals((Integer)3, linkedList.find("Veer"));
    }

    @Test
    public void testSize(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();

        //when
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");
        Integer expected = 3;

        //then
        Assert.assertEquals(expected, linkedList.getSize());
    }

    @Test
    public void testGetByIndex(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();

        //when
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");

        Assert.assertEquals("Rajani", linkedList.getByIndex(2));
    }

    @Test
    public void testClone(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");

        //when
        SinglyLinkedList<String> linkedList1 = null;
        try{
            linkedList1 = (SinglyLinkedList<String>) linkedList.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }

        //then
        Assert.assertEquals(linkedList.toString(), linkedList1.toString());


    }
    ///Check the reverse method<<<<<<<<<<
    @Test
    public void testReverse(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");



        //then
        Assert.assertEquals("Veer", linkedList.reverse(linkedList.getHead()).getData());
    }

    @Test
    public void testSort(){
        //given
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        linkedList.add("Sonia");
        linkedList.add("Rajani");
        linkedList.add("Veer");

        System.out.println(linkedList.getHead().toString());

        linkedList.sort();

        System.out.println(linkedList.getHead().toString());
    }


    }
