import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicLinkedListTest {
    BasicLinkedList<String> myList;

    @Before
    public void setUp() {
        myList = new BasicLinkedList<>();

    }

    @After
    public void tearDown() {
        myList = null;
    }

    @Test
    public void add() throws Exception {
        System.out.println("Add Test\n");
        myList.add("Brian");
        myList.add("Andrew");
        myList.add("Pavel");
        myList.add("Tim");
        myList.add("Linda");
        myList.add("Ryan");

        int expected = 6;
        int actual = myList.size();

        Assert.assertEquals(expected, actual);

        System.out.println(myList.print());
        System.out.println("\n\nEnd Test\n\n");
    }

    @Test
    public void remove() throws Exception {
        System.out.println("Remove test\n");
        myList.add("Brian");
        myList.add("Andrew");
        myList.add("Pavel");
        myList.add("Tim");
        myList.add("Linda");
        myList.add("Ryan");

        myList.remove(0);

        int expected = 5;
        int actual = myList.size();

        Assert.assertEquals(expected, actual);

        System.out.println(myList.print());

        System.out.println("\n\nEnd Test\n\n");
    }

    @Test
    public void contains() throws Exception {
        myList.add("Andrew");

        boolean expected = true;
        boolean actual = myList.contains("Andrew");

        boolean expected2 = false;
        boolean actual2 = myList.contains("Brian");

        Assert.assertEquals(expected, actual);

        Assert.assertEquals(expected2, actual2);

    }

    @Test
    public void find() throws Exception {
        myList.add("Pavel");
        myList.add("Andrew");

        int expected = 1;
        int actual = myList.find("Andrew");

        int expected2 = -1;
        int actual2 = myList.find("Brian");

        Assert.assertEquals(expected, actual);

        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void size() throws Exception {
        myList.add("Brian");
        myList.add("Andrew");
        myList.add("Pavel");
        myList.add("Tim");
        myList.add("Linda");
        myList.add("Ryan");

        int expected = 6;
        int actual = myList.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get() throws Exception {
        myList.add("Brian");
        myList.add("Andrew");
        myList.add("Pavel");
        myList.add("Tim");
        myList.add("Linda");
        myList.add("Ryan");

        String expected = "Tim";

        String actual = myList.get(3).value;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copy() throws Exception {
        myList.add("Brian");
        myList.add("Andrew");
        myList.add("Pavel");
        myList.add("Tim");
        myList.add("Linda");
        myList.add("Ryan");

        System.out.println("Original List\n");
        System.out.println(myList.print());

        BasicLinkedList<String> copy = myList.copy();

        System.out.println("\nCopied List\n");

        System.out.println(copy.print());

        Assert.assertEquals(myList.print(), copy.print());
    }

    @Test
    public void sort() throws Exception {
        myList.add("Tim");
        myList.add("Ryan");
        myList.add("Brian");
        myList.add("Andrew");
        myList.add("Pavel");
        myList.add("Linda");

        String expected = "Andrew\nBrian\nLinda\nPavel\nRyan\nTim";

        myList.sort();

        String actual = myList.print();

        Assert.assertEquals(expected, actual);
    }

}