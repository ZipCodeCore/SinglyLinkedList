package DataStructures;

public class SinglyLinkedList<E extends Comparable> {

    private class Node{
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

    private Node head;

    public SinglyLinkedList(){
        head=null;
    }

    private Node findLastNode(){
        if (head==null){
            return null;
        }
        Node traverse = head;
        while (traverse.next!=null){
            traverse=traverse.next;
        }
        return traverse;
    }

    public void add (E element){

        Node node = new Node();

        node.element=element;
        node.next=null;

        if (head==null){
            head=node;
            head.index=0;
        }
        else{
            node.index=findLastNode().index+1;
            findLastNode().next=node;
        }

    }

    private boolean isIndexOutOfBounds(int index){
        return (index<0 || index>=size());
    }

    private void adjustIndices(){

        if (head!=null) {

            int index = 0;
            Node traverse = head;

            traverse.index = index;

            while (traverse.next != null) {
                index++;
                traverse.next.index = index;
                traverse = traverse.next;
            }
        }
    }

    public void remove(int index){
        adjustIndices();
        if (!(isIndexOutOfBounds(index))) {
            if (index==0) {
                head = head.next;
            }
            else {
                Node traverse = head;
                while (traverse.next.index != index) {
                    traverse = traverse.next;
                }
                traverse.next=traverse.next.next;
            }
        }
        adjustIndices();

    }
//WHAT HAPPENS IF I PASS AN INTEGER OBJECT?
// deprecated until I can figure this out
//    public void remove(E element){
//
//        if (contains(element))
//        {
//            do{
//                remove(find(element));
//            }while (contains(element));
//            adjustIndices();
//        }
//    }

    public boolean contains(E element){

        if (head==null) {
            return false;
        } else {
            Node traverse = head;
            do {
                if (traverse.element.equals(element))
                    return true;
                traverse = traverse.next;
            } while (traverse != null);
        }
        return false;
    }

    public int find(E element){

        if (contains(element)) {

            Node traverse = head;

            while (traverse != null) {
                if (traverse.element.equals(element)) {
                    return traverse.index;
                }
                traverse = traverse.next;
            }
        }
        return -1;
    }

    public int size(){
        if (head==null)
            return 0;
        return findLastNode().index+1;
    }

    public E get(int index){

        if (isIndexOutOfBounds(index))
            return null;

        Node traverse = head;
        while (traverse.index != index){
            traverse=traverse.next;
        }

        return traverse.element;

    }

    public SinglyLinkedList<E> copy(){//deep copy

        SinglyLinkedList<E> copyList = new SinglyLinkedList<>();

        if (head==null){
            return copyList;
        }

        Node traverse = head;
        do {
            copyList.add(traverse.element);
            traverse = traverse.next;
        }while (traverse!=null);

        return copyList;
    }

    public void sort(){

        if (size()>2){

            boolean isInOrder;
            Node traverse;
            Node swap;

            do{
                isInOrder=true;
                traverse = head;
                swap = traverse.next;

                if (traverse.element.compareTo(swap.element)>0)
                {
                    isInOrder=false;
                    traverse.next=swap.next;
                    swap.next=traverse;
                    head=swap;
                }

                traverse = head;
                swap = traverse.next;

                while (swap!=null && swap.next!=null) {
                    if (swap.element.compareTo(swap.next.element) > 0) {//We want to sort in ascending order,
                        // so if this returns a positive, we need to switch them. Otherwise, we leave them alone.
                        //This methodology is NOT efficient: imagine a list 1, 2, 3, ... , n-2, n-1, 5, n. This would
                        //result in us swapping two nodes, returning to the beginning, and doing it all over again until
                        //it was sorted. This becomes less efficient with a largely unordered list. Plans to refactor later.
                        isInOrder=false;
                        Node bubble = swap.next;
                        swap.next = bubble.next;
                        bubble.next = swap;
                        traverse.next = bubble;
                    }
                    traverse = traverse.next;
                    swap=traverse.next;
                }

            }while (!isInOrder);
        } else if(size()>1){

            Node traverse = head;
            Node swap = traverse.next;

            if (traverse.element.compareTo(swap.element)>0)
            {
                traverse.next=swap.next;
                swap.next=traverse;
                head=swap;
            }
        }
        adjustIndices();
    }

    public void reverse(){
        if (size()>1) {
            SinglyLinkedList<E> reversed = new SinglyLinkedList<>();
            int reverseIndex = size() - 1;

            do {
                reversed.add(get(reverseIndex));
                reverseIndex--;
            }while(reverseIndex>=0);
            head=reversed.head;
        }
    }

    public SinglyLinkedList<E> slice(int startIndex, int endIndexExclusive){//returns a copy of the subList indicated,
                                                                            //or an empty list if arguments are invalid

        SinglyLinkedList<E> copyList = new SinglyLinkedList<>();

        if (isIndexOutOfBounds(startIndex) || isIndexOutOfBounds(endIndexExclusive-1) ||
            endIndexExclusive<=startIndex  || (endIndexExclusive-startIndex-1)>=size()){
            return copyList;
        }

        for (int i=startIndex; i<endIndexExclusive; i++) {
            if (get(i)==null){
                return copyList;
            }
            copyList.add(get(i));
        }

        return copyList;

    }

}
