import com.dataStructures.LinkedList;
import org.junit.Assert;
import org.junit.Test;

public class TestLinedList<X>{
    LinkedList<Integer> linkedList = new LinkedList<>();
    @Test
    public void testAddAtTheEnd(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        Assert.assertEquals(linkedList.size(),2);
    }
    @Test
    public void testInsertIntoIndex(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(34,2);
        int data = linkedList.get(2);
        Assert.assertEquals(34,data);
    }
    @Test
    public void testSize(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(34,2);
        Assert.assertEquals(3,linkedList.size());
    }
    @Test
    public void testRemoveFromIndex(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(34,2);
        linkedList.removeFromIndex(2);
        Assert.assertEquals(2,linkedList.size());
    }
    @Test
    public void testContains(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(34,2);
        Assert.assertEquals(true,linkedList.contains(23));
    }
    @Test
    public void testFind(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(34,2);
        Assert.assertEquals(1,linkedList.find(10));
    }
    @Test
    public void testGet(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(32,2);
        int result = linkedList.get(2);
        Assert.assertEquals(32,result);
    }
    @Test
    public void testCopy(){
        linkedList.addAtTheFront(10);
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(32,2);
        LinkedList<Integer> copyList = linkedList.copy();
        Assert.assertEquals(copyList.size(),linkedList.size());
    }
    @Test
    public void testSort(){
        linkedList.addAtTheFront(10);
        String expected = "List: 10, 23, 32";
        linkedList.addAtTheFront(23);
        linkedList.insertIntoIndex(32,2);
        linkedList.sort();
        Assert.assertEquals(expected,linkedList.toString());
    }

}
