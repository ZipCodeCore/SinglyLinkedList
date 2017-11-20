package io.zipcoder.lawrence;

public class Link {
    /*

Implement a singly linked list:
  You may not use the LinkedList or ArrayList class or any other predefined Java collections
 Your linked list must have a node inner class to represent each element
 Your linked list must have add, remove, contains, find, size, get, copy and sort methods
 Method definitions:

 add -- add an element to the list  --  ***addNode
remove -- remove an element (specified by numeric index) from the list --  ***deleteNode
contains -- returns true if the element is in the list, false otherwise  --  ***findNode
find -- returns the element's index if it is in the list, -1 otherwise  -- ***findIndex
size -- returns the current size of the list --  ***lenghtOfNodes
get -- returns the element at the specified index -- ***nodeByIndex
copy -- returns a new linked list containing the same values (look up deep versus shallow copy)
sort -- sorts the list using your algorithm of choice. You must perform the sorting yourself (no fair using someone else's library

    */

  public String nodes;
  public int nodeCount;

  public Link next;

  public Link(String nodes, int nodeCount) {
    this.nodes = nodes;
    this.nodeCount = nodeCount;

  }

  public void showNodes(){
    System.out.println(nodes + " : " + nodeCount);
  }

  public String printNodes(){
    return nodes;
  }

  public static void main(String[] args){

    Linklist theNodeList = new Linklist();

    theNodeList.addNode("blue",1);
    theNodeList.addNode("red",2);
    theNodeList.addNode("brown",3);
    theNodeList.addNode("black",4);
    theNodeList.addNode("pink",5);


    //theNodeList.addNode("purple", 6);
   // theNodeList.removeNode("brown");
   // System.out.println(theNodeList.lenghtOfNodes());
   //theNodeList.findNode("red");
   // theNodeList.deleteNode(3);
    //System.out.println(theNodeList.nodeByIndex(4));
    System.out.println(theNodeList.findIndex("blue"));

  // System.out.println(theNodeList.findNode("candy"));
   //theNodeList.showNodes();

  }
}

class Linklist {

  public Link firstNode;

  Linklist() {
    firstNode = null;
  }

  public boolean isEmpty() {
    return (firstNode == null);
  }


  public void deleteNode(int position){
    Link thelink = firstNode;

    // If linked list is empty
    if (thelink == null)
      return;

    // Store head node
    Link temp = firstNode;

    // If head needs to be removed
    if (position == 0)
    {
      firstNode = temp.next;   // Change head
      return;
    }

    // Find previous node of the node to be deleted
    for (int i=0; temp!=null && i<position-1; i++)
      temp = temp.next;

    // If position is more than number of ndoes
    if (temp == null || temp.next == null)
      return;

    // Node temp->next is the node to be deleted
    // Store pointer to the next of node to be deleted
    Link next = temp.next.next;

    temp.next = next;  // Unlink the deleted node from list
  }

  public void addNode(String nodes, int nodeCount) {

    Link newLink = new Link(nodes, nodeCount);

    newLink.next = firstNode;

    firstNode = newLink;

  }

  public int lenghtOfNodes(){
    Link thelink = firstNode;
    int nodeNumber = 0;

    if(thelink == null){
      return 0;
    }
    while (thelink != null){
      nodeNumber++;
      thelink = thelink.next;
    }
    return nodeNumber;
  }

  public boolean findNode(String nodes) {
    String isThere = null;

    Link thelink = firstNode;
    if (thelink != null) {
      while (thelink.nodes != nodes) {
        if (thelink.next == null) {
          isThere = "false";
          return false;
        } else {
          thelink = thelink.next;
        }
      }
    } else {
      System.out.println("The list is empty.");
    }
    return true;
  }

  public String nodeByIndex(int index){
    Link thelink = firstNode;
    int count = 0; /* index of Node we are
                          currently looking at */
    while (thelink != null)
    {
      if (count == index)
        return thelink.nodes;
      count++;
      thelink = thelink.next;
    }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
    assert(false);
    return null;
  }

  public int findIndex(String nodes) {

    Link thelink = firstNode;
    int count = 0; /* index of Node we are
                          currently looking at */
    if(!isEmpty()) {
      while (thelink.nodes != nodes) {
        if (thelink.next == null) {
        } else {
          thelink = thelink.next;
        }
        count++;
      }

      }else{
      System.out.println(count);
    }
    return count;
    }


//  public Link removeNode(String nodes) {
//    Link currentNode = firstNode;
//    Link previousNode = firstNode;
//
//    while (currentNode.nodes == nodes) {
//
//      if (currentNode.next != null) {
//        return null;
//      } else {
//        previousNode = currentNode;
//        currentNode = currentNode.next;
//      }
//    }
//
//    if (currentNode == firstNode) {
//      firstNode = firstNode.next;
//    } else {
//      previousNode.next = currentNode.next;
//    }
//    return currentNode;
//
//
//  }

  public void showNodes() {
    Link thelink = firstNode;

    while (thelink != null) {
      thelink.showNodes();
      System.out.println("Next Link is: " + thelink.next);

      thelink = thelink.next;
      System.out.println();
    }
  }



}
