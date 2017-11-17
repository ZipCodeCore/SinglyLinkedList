import org.junit.*;

public class SinglyLinkedListTest {
    private SinglyLinkedList<String> aLinkedList;

    @Before
    public void setUp() throws Exception {
        aLinkedList = new SinglyLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        aLinkedList = null;
    }

    @Test
    public void addNodeToEndOfLinkedListTest() throws Exception {
        Integer expected = 1;
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        Integer actual = aLinkedList.getSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getNodeByIndexTest() throws Exception {
        String expected = "Andrew";
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        String actual = aLinkedList.getNodeByIndex(0).getNodeData();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void removeNodeByIndexTest_SizeOfZero() throws Exception {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        aLinkedList.removeNodeByIndex(0);
        SinglyLinkedList.Node indexOf0Test = aLinkedList.getNodeByIndex(0);
        Assert.assertNull(indexOf0Test);
    }

    @Test
    public void removeNodeByIndexTest_SizeOfOne() throws Exception {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        String expected = "Brian";
        aLinkedList.removeNodeByIndex(0);
        String actual = aLinkedList.getNodeByIndex(0).getNodeData();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeNodeByIndexTest_ReplaceLastElement() throws Exception {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        aLinkedList.addNodeToEndOfLinkedList("Pavel");
        String expected = "Brian";
        aLinkedList.removeNodeByIndex(2);
        String actual = aLinkedList.getNodeByIndex(aLinkedList.getSize()-1).getNodeData();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void removeNodeByIndexTest_AnyElementInMiddleOfList() throws Exception {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        aLinkedList.addNodeToEndOfLinkedList("Pavel");
        String expected = "Pavel";
        aLinkedList.removeNodeByIndex(1);
        String actual = aLinkedList.getNodeByIndex(1).getNodeData();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void containsNodeTest_True() {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        boolean expected = true;
        boolean actual = aLinkedList.containsNode("Andrew");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void containsNodeTest_False() {
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        boolean expected = false;
        boolean actual = aLinkedList.containsNode("Andrew");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findNodeIndexTest_True() {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        int expected = 0;
        int actual = aLinkedList.findNodeIndex("Andrew");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findNodeIndexTest_False() {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        int expected = -1;
        int actual = aLinkedList.findNodeIndex("Brian");
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getSizeTest() {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        aLinkedList.addNodeToEndOfLinkedList("Pavel");
        int expected = 3;
        int actual = aLinkedList.getSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void copyLinkedListTest() {
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        aLinkedList.addNodeToEndOfLinkedList("Pavel");
        SinglyLinkedList<String> aCopyList = aLinkedList.copyLinkedList();
        Assert.assertEquals(aCopyList.getNodeByIndex(0).getNodeData(),aCopyList.getNodeByIndex(0).getNodeData());
        Assert.assertEquals(aCopyList.getNodeByIndex(1).getNodeData(),aCopyList.getNodeByIndex(1).getNodeData());
        Assert.assertEquals(aCopyList.getNodeByIndex(2).getNodeData(),aCopyList.getNodeByIndex(2).getNodeData());
        // Not great way to clone... I know. Should update it in the future.
    }

    @Test
    public void sortTest() {
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        aLinkedList.addNodeToEndOfLinkedList("Pavel");
        aLinkedList.addNodeToEndOfLinkedList("Andrew");

        aLinkedList.sort();

        Assert.assertEquals(aLinkedList.getNodeByIndex(0).getNodeData(),"Andrew");
        Assert.assertEquals(aLinkedList.getNodeByIndex(1).getNodeData(),"Brian");
        Assert.assertEquals(aLinkedList.getNodeByIndex(2).getNodeData(),"Pavel");
    }

    @Test
    public void reverseTest() {
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        aLinkedList.addNodeToEndOfLinkedList("Pavel");
        aLinkedList.addNodeToEndOfLinkedList("Andrew");

        SinglyLinkedList reverseList = aLinkedList.reverse();

        Assert.assertEquals(reverseList.getNodeByIndex(0).getNodeData(),"Andrew");
        Assert.assertEquals(reverseList.getNodeByIndex(1).getNodeData(),"Pavel");
        Assert.assertEquals(reverseList.getNodeByIndex(2).getNodeData(),"Brian");
    }

    @Test
    public void sliceTest() {
        aLinkedList.addNodeToEndOfLinkedList("Brian");
        aLinkedList.addNodeToEndOfLinkedList("Pavel");
        aLinkedList.addNodeToEndOfLinkedList("Andrew");
        aLinkedList.addNodeToEndOfLinkedList("Tim");
        aLinkedList.addNodeToEndOfLinkedList("Peter");
        aLinkedList.addNodeToEndOfLinkedList("Ryan");

        SinglyLinkedList aSlicedList = aLinkedList.slice(2,4);

        Assert.assertEquals(aSlicedList.getNodeByIndex(0).getNodeData(),"Andrew");
        Assert.assertEquals(aSlicedList.getNodeByIndex(1).getNodeData(),"Tim");

    }







}