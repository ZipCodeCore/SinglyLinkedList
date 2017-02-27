import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prestonbattin on 2/24/17.
 */
public class MyLinkedListTest {

    MyLinkedList linkedList;
    Link link1;
    Link link2;
    Link link3;


    @Before
    public void setUp(){

        linkedList = new MyLinkedList();
        link1 = new Link("Hello");
        link2 = new Link("World");
        link3 = new Link("!");
    }

    @Test
    public void addFirstTest(){

        linkedList.addFirst(link1);
        String expected = "Hello";
        Link actual = linkedList.getHead();
        Assert.assertEquals("Adding first link", expected, actual.toString());
    }


    @Test
    public void addLastTest(){

        linkedList.addFirst(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        String expected = "!";
        Link actual = linkedList.getTail();
        Assert.assertEquals("Adding link to last", expected, actual.toString());
    }

    @Test
    public void removeFirstTest(){

        linkedList.addLast(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        linkedList.removeFirst();
        String expected = "World";
        Link actual = linkedList.getHead();
        Assert.assertEquals("Testing removing first elements", expected, actual.toString());
    }

    @Test
    public void removeLastTest(){


        linkedList.addFirst(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        linkedList.removeLast();
        String expected = "World";
        Link actual = linkedList.getTail();
        Assert.assertEquals("Removing last link", expected, actual.toString());
    }

    @Test
    public void removeTest(){

        linkedList.addFirst(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        linkedList.remove(2);
        String expected = "!";
        Link actual = linkedList.getHead().next;
        Assert.assertEquals("Tesint removing by index", expected, actual.toString());

    }

    @Test
    public void containsTest(){
        Link<String> temp = new Link<String>("World");
        Link<String> temp2 = new Link<String>("Should Be False");
        linkedList.addLast(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        boolean expected = true;
        boolean actual = linkedList.contains(temp);
        Assert.assertEquals("Testing list contains", expected, actual);
        expected = false;
        actual = linkedList.contains(temp2);
        Assert.assertEquals("Testing it doesnt contain", expected, actual);
    }

    @Test
    public void findTest(){
        linkedList.addLast(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        int expected = 2;
        int actual = linkedList.find(link2);
        Assert.assertEquals("Testing find method", expected, actual);
    }
    @Test
    public void getTest(){

        linkedList.addLast(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        Link<String> expected = new Link<String>("!");
        Link<String> actual = linkedList.get(3);
        Assert.assertEquals("Testing get at index", expected.toString(), actual.toString());

    }

    @Test
    public void copyTest(){

        linkedList.addLast(link1);
        linkedList.addLast(link2);
        linkedList.addLast(link3);
        MyLinkedList<String> copy = linkedList.copy();
        boolean expected = true;
        boolean actual = copy.equals(linkedList);
        Assert.assertEquals("Testing shallow copy", expected, actual);
    }
}
