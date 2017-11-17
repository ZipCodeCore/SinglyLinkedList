package DataStructures;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class SinglyLinkedListTest {

    @Test
    public void testAddAndSize(){

        SinglyLinkedList<Integer> intSLL = new SinglyLinkedList<>();
        intSLL.add(5);
        int expected = 1;
        int actual = intSLL.size();

        Assert.assertEquals(expected, actual);

        expected+=3;
        intSLL.add(4);
        intSLL.add(4);
        intSLL.add(4);
        actual=intSLL.size();

        Assert.assertEquals(expected, actual);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveAndGet(){

        SinglyLinkedList<String> strSLL = new SinglyLinkedList<>();
        int size = strSLL.size();
        for (int i=0; i<10; i++)
        {
            strSLL.add(""+i);
        }
        size = strSLL.size();
        String expected = ""+1;

        for (int i=0; i<5; i++)//Test remove by index
        {
            strSLL.remove(0);
            size = strSLL.size();
            Assert.assertEquals(expected.compareTo(strSLL.get(0)),0);
            expected=""+(i+2);

        }

        strSLL.remove(-1);

//        for (int i=5; i<10; i++){//Test remove by element overload
//            strSLL.remove(""+i);
//            String actual=strSLL.get(0);
//            if (i!=9) {
//                Assert.assertEquals(expected.compareTo(strSLL.get(0)), 0);
//            } else{
//                Assert.assertNull(strSLL.get(0));
//            }
//            expected=""+(i+2);
//        }

    }

    @Test
    public void testContains(){

        SinglyLinkedList<String> strSLL = new SinglyLinkedList<>();

        for (int i=0; i<10; i++){
            strSLL.add(""+i);
        }

        boolean expected=true;
        boolean actual;

        for (int i=0; i<10; i++){
            actual=strSLL.contains(""+i);
            Assert.assertEquals(expected, actual);
        }

        expected = false;

        for (int i=10; i<15; i++){
            actual = strSLL.contains(""+i);
            Assert.assertEquals(expected, actual);
        }

    }

    @Test
    public void testFind(){

        SinglyLinkedList<Integer> intSLL = new SinglyLinkedList<>();

        for (int i=0; i<50; i++){
            intSLL.add(i);
        }

        int actual;

        for (int i=49; i>=0; i--){
            actual = intSLL.find(i);
            Assert.assertEquals(i, actual);
        }


    }

    @Test
    public void testCopy(){

        SinglyLinkedList<String> original = new SinglyLinkedList<>();

        for (char letter='a'; letter<='z'; letter++){
            original.add(""+letter);
        }

        SinglyLinkedList<String> copy = original.copy();

        for (int i=0; i<26; i++){
            Assert.assertEquals(original.get(i), copy.get(i));
        }

        original.remove(0);

        for (int i=0; i<25; i++) {
            Assert.assertNotEquals(original.get(i), copy.get(i));
        }
    }

    @Test
    public void testSortAndReverse(){

        SinglyLinkedList<Integer> intSLL = new SinglyLinkedList<>();
        ArrayList<Integer> intAL = new ArrayList<>();
        Random rando = new Random();
        int nextInt=rando.nextInt();

        for (int i=0; i<50; i++){
            intAL.add(nextInt);
            intSLL.add(nextInt);
            nextInt=rando.nextInt();
        }

        int al;
        int sll;

        for (int i=0; i<50; i++){
            al=intAL.get(i);
            sll=intSLL.get(i);
            Assert.assertEquals(al, sll);
        }

        Collections.sort(intAL);
        intSLL.sort();

        for (int i=0; i<50; i++){
            al=intAL.get(i);
            sll=intSLL.get(i);
            Assert.assertEquals(al, sll);
        }

        Collections.reverse(intAL);
        intSLL.reverse();

        for (int i=0; i<50; i++){
            al=intAL.get(i);
            sll=intSLL.get(i);
            Assert.assertEquals(al, sll);
        }
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSlice(){

        SinglyLinkedList<Integer> intSLL = new SinglyLinkedList<>();

        for (int i=0; i<10; i++){
            intSLL.add(i);
        }

        SinglyLinkedList<Integer> sliced = intSLL.slice(2,8);
        Assert.assertEquals(6, sliced.size());
        for (int i=0; i<6; i++){
            Assert.assertEquals(sliced.get(i), intSLL.get(i+2));
        }

        for (int i=0; i<10; i++){
            intSLL.remove(i);
            intSLL.add(i-1);
        }
        for (int i=0; i<6; i++){
            Assert.assertNotEquals(sliced.get(i), intSLL.get(i+2));
        }

        sliced = intSLL.slice(2,12);//indexOutOfBounds, return an empty list
        Assert.assertNull(sliced.get(0));
        Assert.assertEquals(0, sliced.size());

        sliced = intSLL.slice(-1,8);//indexOutOfBounds, return an empty list
        Assert.assertNull(sliced.get(0));
        Assert.assertEquals(0, sliced.size());

        sliced = sliced.slice(0,8);//indexOutOfBounds, return an empty list
        Assert.assertNull(sliced.get(0));
        Assert.assertEquals(0, sliced.size());

        sliced = intSLL.slice(2,2);//impossible index combination
        Assert.assertNull(sliced.get(0));
        Assert.assertEquals(0, sliced.size());

        sliced = intSLL.slice(3,2);//impossible index combination
        Assert.assertNull(sliced.get(0));
        Assert.assertEquals(0, sliced.size());

    }

}
