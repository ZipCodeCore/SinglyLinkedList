package io.zipcoder.lawrence;

public class Link {
    /*

Implement a singly linked list:
  You may not use the LinkedList or ArrayList class or any other predefined Java collections
 Your linked list must have a node inner class to represent each element
 Your linked list must have add, remove, contains, find, size, get, copy and sort methods
 Method definitions:

    * add -- add an element to the list
remove -- remove an element (specified by numeric index) from the list
contains -- returns true if the element is in the list, false otherwise
find -- returns the element's index if it is in the list, -1 otherwise
size -- returns the current size of the list
get -- returns the element at the specified index
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

    theNodeList.showNodes();

  }
}

class Linklist {

  public Link firstLink;

  Linklist() {
    firstLink = null;
  }

  public boolean isEmpty() {
    return (firstLink == null);
  }

  public void addNode(String nodes, int nodeCount) {

    Link newLink = new Link(nodes, nodeCount);

    newLink.next = firstLink;

    firstLink = newLink;

  }

  public Link removeNode() {
    Link nodeReference = firstLink;

    if (isEmpty()) {
      firstLink = firstLink.next;
    } else {
      System.out.println("Empty");
    }
    return nodeReference;
  }

  public void showNodes() {
    Link thelink = firstLink;

    while (thelink != null) {
      thelink.showNodes();
      System.out.println("Next Link is: " + thelink.next);

      thelink = thelink.next;
      System.out.println();
    }
  }

  public Link findNode(String nodes) {

    Link thelink = firstLink;
    if (thelink != null) {
      while (thelink.nodes != nodes) {
        if (thelink.next == null) {
          return null;
        } else {
          thelink = thelink.next;
        }
      }
    } else {
      System.out.println("The list is empty.");
    }
    return thelink;
  }

  public Link removeNode(String nodes) {
    Link currentNode = firstLink;
    Link previousNode = firstLink;

    while (currentNode.nodes == nodes) {

      if (currentNode.next != null) {
        return null;
      } else {
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
    }

    if (currentNode == firstLink) {
      firstLink = firstLink.next;
    } else {
      previousNode.next = currentNode.next;
    }
    return currentNode;


  }
}
