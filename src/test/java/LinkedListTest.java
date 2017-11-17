
import org.junit.Assert;
import org.junit.Test;


public class LinkedListTest {
    LinkedList<String> list=new LinkedList();

    @Test
    public void addTest() throws Exception {
        String expected ="3\n4\n5";

        list.add("3");
        list.add("4");
        list.add("5");
        String actual =list.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest() throws Exception {

        String expected="a\nb\nc";
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

        String expected="a\nb\nd";
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
        String expected="a\nb\nc\nd";
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
        String expected="a\nb\nz\nc\nd";
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
        String expected="a\n" +
                "tato\n" +
                "tbtb\n" +
                "tetc\n" +
                "turtle\n" +
                "tut\n" +
                "z";

        list.add("turtle");
        list.add("tetc");
        list.add("tbtb");
        list.add("tut");
        list.add("tato");
        list.add("a");
        list.insert(4,"z");

        list.sort();
        String actual=list.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void reverseTest() throws Exception {
        String expected="e\nd\nc\nb\na";

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
        String expected = "c\nd\ne";

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
