import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    SinglyLinkedList<Integer> test = new SinglyLinkedList();

    @Test
    public void addTest() {

        int expected = 3;
        test.add(2);
        test.add(3);
        test.add(4);
        int actual = test.get(1).getInfo();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void removeTest(){

        int expected = 3;
        test.add(1);//0
        test.add(2);//1
        test.add(3);//2
        test.add(4);//3
        test.remove(1);//removing 2 by replacing it with 3.
        int actual = test.get(1).getInfo();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void sizeTest(){
        int expected = test.getSize();

        test.add(1);
        test.add(2);
        //size will increment by 1 each time add is called.
        int actual = test.getSize();

        Assert.assertTrue(actual>expected);
    }
    @Test
    public void containTestTrue(){

        test.add(1);//0
        test.add(2);//1
        test.add(3);//2

        Assert.assertTrue(test.contains(2));
    }
    @Test
    public void containTestFalse(){

        test.add(1);//0
        test.add(2);//1
        test.add(3);//2

        Assert.assertFalse(test.contains(4));
    }
    @Test
    public void printTest(){
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.print();
    }
    @Test
    public void findTest(){
        int expected = 2;
        test.add(1);//0
        test.add(2);//1
        test.add(3);//2
        test.add(4);//3
        int actual = test.find(3);

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void copyTest(){
        test.add(1);
        SinglyLinkedList copy = test.copy();
        Assert.assertTrue(test.contains(1) == copy.contains(1));
        copy.remove(0);
        Assert.assertFalse(test.contains(1) == copy.contains(1));
    }

}
