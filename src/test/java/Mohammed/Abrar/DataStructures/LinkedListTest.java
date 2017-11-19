package Mohammed.Abrar.DataStructures;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {
    LinkedList<String> linkedList = new LinkedList<>();
    @Test
    public void getHead()  {
    }

    @Test

     public    void addAndSize() {


            linkedList.add("Abrar");
            linkedList.add("Zen");

            int expected = 2;

            int actual = linkedList.size();

            Assert.assertEquals(expected, actual);

            linkedList.add("Raul");


            int expected2 = 3;

            int actual2 = linkedList.size();

            Assert.assertEquals(expected2, actual2);


        }



    @Test
    public void size() throws Exception {
    }

    @Test
    public void getTest(){
        linkedList.add("Raul");
        linkedList.add("Greg");
        linkedList.add("Zen");
        linkedList.add("Brian");


        String expected = "Raul";
        String actual = linkedList.get(4);

        Assert.assertEquals(expected,actual);

        linkedList.add("Merzuk");
        System.out.println(linkedList.get(4));


    }

    @Test
    public void findTest() {
        linkedList.add("Raul");
        linkedList.add("Greg");
        linkedList.add("Zen");
        linkedList.add("Brian");


        int expected = 1;

        int actual = linkedList.find("Zen");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public  void sortTest(){

        linkedList.add("Raul");
        linkedList.add("Greg");
        linkedList.add("Zen");
        // System.out.println(linkedList.toString());
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));

        linkedList.sort();
        System.out.println("____________________");
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(3));


    }

    @Test
    public void isEmpty() {
        linkedList.add("Raul");
        boolean expected = false;
        boolean actual = linkedList.isEmpty();
        Assert.assertEquals(expected, actual);

        linkedList.remove("Raul");
        boolean expected2 = true;
        boolean actual2 = linkedList.isEmpty();
        Assert.assertEquals(expected2, actual2);

    }

    @Test
    public  void containTest() {

        linkedList.add("Raul");
        boolean expected = true;
        boolean actual = linkedList.contains("Raul");
        Assert.assertEquals(expected, actual);


        boolean expected2 = false;
        boolean actual2 = linkedList.contains("Greg");
        Assert.assertEquals(expected2, actual2);



    }

    @Test
    public void remove() {
        linkedList.add("Raul");
        linkedList.add("Greg");
        linkedList.add("Zen");
        int expected = linkedList.size() - 1;
        System.out.println(linkedList.size());

        linkedList.remove("Zen");
        System.out.println(linkedList.size());

        int actual = linkedList.size();

        Assert.assertEquals(expected, actual);

    }


    @Test
    public void copy() throws Exception {
    }

    @Test
    public  void addLastTest(){
        linkedList.add("Raul");
        linkedList.add("Greg");
        linkedList.add("Zen");
        System.out.println(linkedList.getHead());
        // System.out.println(linkedList.get(3));

        linkedList.addLast("Logan");

        System.out.println(linkedList.getHead());
        System.out.println(linkedList.getLast());


    }

    @Test
    public void getLast() throws Exception {
    }

}