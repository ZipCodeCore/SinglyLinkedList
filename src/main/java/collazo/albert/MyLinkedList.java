package collazo.albert;

public class MyLinkedList<T>{
    private Node head;
    private Node tail;
    private int listSize;

    public MyLinkedList(){
        this.head = head;
        this.tail = tail;
        this.listSize = 0;
    }

    public void add(T element){
        if (element == null){throw new NullPointerException("The first argument is null.");}
        if(listSize != 0){
            Node prev = tail;
            tail = new Node(element,null);
            prev.next= tail;
        }else{
            tail = new Node(element,null);
            head = tail;
        }
        listSize++;
    }

    public boolean remove(T item){
        if(listSize == 0){throw new IllegalStateException("Cannot remove from an empty list.");}
        boolean result = false;
        Node prev = head;
        Node current = head;
        while(current.next != null || current == tail){
            if(current.data.equals(item)){
                if (listSize == 1){head = null; tail = null;} //remove the tail
                else if(current.equals(head)){head = head.next;} //remove the head
                else if(current.equals(tail)){tail = prev; tail.next = null;} //remove current
                else{prev.next = current.next;}
                listSize--;
                result = true;
                break;
            }
            prev = current;
            current = prev.next;
        }
        return result;
    }

    public boolean contains(T item){
        Node current = head;
        while(current != null){
            if(current.data.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int find(T item){
        if(listSize == 0){throw new IllegalStateException("Cannot find item in an empty list");}
        int index = 0;
      Node current = head;
      while(current != null){
          if(current.data.equals(item)){
              return index;
          }
          index++;
          current = current.next;
      }
        return -1;
    }

    public int size(){
        return listSize;
    }

    public T get(int index){
        Node current = head;
        while(index > 0){
            index--;
            current = current.next;
            if(current == null){
                return null;
            }
        }
        return current.data;
    }

    private class Node{
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

}
