package DataStructures;

public class SinglyLinkedList<E> {

    private class Node<E>{
        private int index;
        private E element;
        Node next=null;

        private Node(){
        }

        private Node(int index, E element){
            this.index=index;
            this.element=element;
        }
    }//No need for setters and getters: Outer class can access directly.

    private Node head=null;

    public void add (E element){

    }

    public void remove(int index){

    }

    public void remove(E element){

    }

    public boolean contains(E element){
        return false;
    }

    public int find(E element){

        return -2;
    }

    public int size(){
        return -2;
    }

    public E get(int index){
        return null;
    }

    public SinglyLinkedList<E> copy(){
        return null;
    }

    public void sort(){

    }

    public SinglyLinkedList<E> slice(int startIndex, int endIndexExclusive){
        return null;
    }

}
