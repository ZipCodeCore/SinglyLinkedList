package com.zipcodewilmington.singlylinkedlist;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;



import javax.xml.soap.Node;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {



    @Test
    public void addTest(){
        //GIVEN
        int expected = 3;
     SinglyLinkedList<String> listina = new SinglyLinkedList<String>();

     //WHEN
        listina.add("Butter");
        listina.add("lgo");
        listina.add("ptd");

        int actual = listina.size();

        //THEN
       Assert.assertEquals(expected, actual);
}

@Test
    public void sizeTest(){
        //GIVEN
    SinglyLinkedList<Integer> listy = new SinglyLinkedList<Integer>();;
    int expected = 2;

    //WHEN
    listy.add(7);
    listy.add(13);
    int actual = listy.size();

    //THEN
    Assert.assertEquals(expected,actual);

}

@Test
    public void containsTest(){
    //GIVEN
    SinglyLinkedList<String> listina = new SinglyLinkedList<String>();

    //WHEN
    listina.add("Butter");
    listina.add("lgo");
    listina.add("ptd");

    Assert.assertTrue(listina.contains("Butter"));
}

@Test
    public void findTest(){
    SinglyLinkedList<Integer> listy = new SinglyLinkedList<Integer>();;
    Integer expected = 0;

    //WHEN
    listy.add(7);
    listy.add(13);
    listy.add(20);
    Integer actual = listy.find(7);

    Assert.assertEquals(expected, actual);
}

@Test
    public void getTest(){
        //GIVEN
    SinglyLinkedList<String> listina = new SinglyLinkedList<String>();
    String expected = "ptd";
    //WHEN
    listina.add("Butter");
    listina.add("lgo");
    listina.add("ptd");

    String actual = listina.get(2);
    //THEN
    Assert.assertEquals(expected, actual);

}

@Test
public void copyTest(){
    SinglyLinkedList<String> listina = new SinglyLinkedList<String>();
    String expected = "ptd";
    //WHEN
    listina.add("Butter");
    listina.add("lgo");
    listina.add("ptd");

    SinglyLinkedList<String> actual = listina.copy();
    String actualPrimera = actual.get(0);
    String actualDespues = actual.get(1);

    Assert.assertEquals((String) "Butter", actualPrimera);


}

@Test
    public void removeTest(){
    SinglyLinkedList<Integer> listy = new SinglyLinkedList<Integer>();;
    Integer expected = 2;

    //WHEN
    listy.add(7);
    listy.add(13);
    listy.add(20);


    listy.remove(1);
    Integer actual = listy.size();

    Assert.assertEquals(expected, actual);
}



}
