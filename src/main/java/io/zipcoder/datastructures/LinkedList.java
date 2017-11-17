package io.zipcoder.datastructures;

public class LinkedList<E extends Comparable> {

    private Node head = null;
    private Node tail = null;

    private class Node{
        E val;
        Node next;

        public Node(E val, Node next){
            this.val = val;
            this.next = next;
        }

//        @Override
//        public String toString(){
//            return "Node value: [ "+val+" ], Next node: [ "+next+" ] ";
//        }
    }

   /* @Override
    public String toString(){
        Integer index = 0;
        String output = "";
        temp = head;
        while(index < size()){
            output += temp+"\n";
            temp = temp.next;
            index++;
        }
        return output;
    }*/

    public Integer size (){
        Integer size = 0;
        Node temp = head;

        if(head != null){
            size = 1;
            while(temp.next != null){
              size++;
              temp = temp.next;
            }
        }

        return size;
    }

    public void add (E val){
        Node newNode = new Node(val, null);

        if(head == null){
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void remove (int index){
        if(head == null){
            System.out.println("Empty");
            return;
        }
        if(index >= this.size() || index < 0){
            throw new IndexOutOfBoundsException("Not a valid index");
        }
        if (index == 0){
            head = head.next;
        } else {
            Node temp = head.next;
            index = index - 1; //want to stop at one before the one getting cut out
            for (int i = 1; i <= index; i++) {
                if(i == index) {
                    Node swap = temp.next.next;
                    temp.next = swap;
                }
                temp = temp.next;
            }
        }
    }

    public Boolean contains(E val) {
        Boolean contains = false;

        if (val.equals(head.val)) {
            contains = true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (val.equals(temp.val)) {
                    contains = true;
                }
                temp = temp.next;
            }
        }
        return contains;
    }

    public Integer find (E val){
        Integer index = null;

        if (contains(val)) {
            if (val.equals(head.val)) {
                index = 0;
            } else {
                Node temp = head;
                int i = 0;
                while (temp.next != null) {
                    if (val.equals(temp.val)) {
                        index = i;
                        break;
                    }
                    temp = temp.next;
                    i++;
                }
            }

        } else {
            index = -1;
        }
        return index;
    }

    public E get(int index){
        E val = null;
        if(head == null){
            System.out.println("Empty");
        }
        if(index >= this.size() || index < 0){
            throw new IndexOutOfBoundsException("Not a valid index");
        }
        if (index == 0){
            val = head.val;
        } else {
            Node temp = head.next;
            for (int i = 1; i <= index; i++) {
                if(i == index) {
                    val = temp.val;
                    break;
                }
                temp = temp.next;
            }
        }
        return val;
    }

    public LinkedList<E> copy (){
        LinkedList copy = new LinkedList();

        if(this.head == null){
            copy = null;
        } else {
        for(int i = 0; i < this.size(); i++){
            copy.add(get(i));
            }
        }
        return copy;
    }

    public void sort () {
        if (head == null) {
            System.out.println("Empty");
        } else if (size() == 1) {
            System.out.println("Not going to sort one element");
        } else {
            Node temp_i = head;
            for (int i = 0; i < size() - 1; i++) {
                Node temp_j = temp_i.next;
                for (int j = i + 1; j < size(); j++) {
                    if ((temp_j.val).compareTo(temp_i.val) < 0) {
                        E swap_val = temp_i.val;
                        temp_i.val = temp_j.val;
                        temp_j.val = swap_val;
                    }
                    temp_j = temp_j.next;
                }
                temp_i = temp_i.next;
            }
        }
    }


    /*
    public void reverse(){}
    //*/

    public LinkedList<E> slice(int indexStart, int indexEnd) {
        LinkedList slice = new LinkedList();

        if (indexStart < 0 || indexEnd < 0) {
            throw new IndexOutOfBoundsException("Index cannot be below 0");
        }
        if (indexStart > indexEnd) {
            throw new IndexOutOfBoundsException("End index cannot be below start index");
        }
        if (indexStart >= this.size() || indexEnd >= this.size()) {
            throw new IndexOutOfBoundsException("Index cannot be more than size of list");
        }

        if(head == null){
            slice = null;
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (i >= indexStart && i <= indexEnd) {
                    slice.add(get(i));
                }
            }
        }
        return slice;
    }

}
