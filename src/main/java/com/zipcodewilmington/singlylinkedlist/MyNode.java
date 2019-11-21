package com.zipcodewilmington.singlylinkedlist;

public class MyNode <SomeType>{



    private MyNode nextNode;
    private  SomeType nodeValue;


//-------   constructor -------------------------
    public MyNode(MyNode next, SomeType value){
        this.nextNode = next;
        this.nodeValue = value;
    }

//------ getters and setters --------------------



    public MyNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyNode nextNode) {
        this.nextNode = nextNode;
    }


    public SomeType getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(SomeType nodeValue) {
        this.nodeValue = nodeValue;
    }




}
