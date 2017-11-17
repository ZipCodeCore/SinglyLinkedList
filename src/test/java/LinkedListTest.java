
import org.junit.Assert;
import org.junit.Test;


public class LinkedListTest {
    LinkedList<String> list=new LinkedList();

    @Test
    public void addTest() throws Exception {
        String expected ="345";

        list.add("3");
        list.add("4");
        list.add("5");
        String actual =list.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest() throws Exception {

        String expected="abc";
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");


        list.remove(3);
        String actual=list.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeByValueTest() throws Exception {

        String expected="abd";
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        list.removeByValue("c");
        String actual=list.toString();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void containsTest() throws Exception {
        boolean expected=false;
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        boolean actual=list.contains("e");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findTest() throws Exception {
        int expected=2;
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        int actual=list.find("c");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest() throws Exception {

        int expected=4;
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        int actual=list.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest() throws Exception {
        String expected="c";
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        String actual=list.get(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest() throws Exception {
        String expected="abcd";
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        LinkedList copy=list.copy();
        String actual=copy.toString();
       Assert.assertEquals(expected, actual);
    }

    @Test
    public void insertTest() throws Exception {
        String expected="abzcd";
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.insert(2,"z");
        String actual=list.toString();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void sortTest() throws Exception {
        String expected="aabcdez";

        list.add("e");
        list.add("c");
        list.add("b");
        list.add("a");
        list.add("d");
        list.add("a");
        list.insert(4,"z");

        list.sort();
        String actual=list.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest() throws Exception {
        String expected="edcba";

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list=list.reverse();
        String actual=list.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sliceTest() throws Exception {
        String expected = "cde";

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list = list.slice(2, 5);
        String actual = list.toString();
        Assert.assertEquals(expected, actual);
    }
}
