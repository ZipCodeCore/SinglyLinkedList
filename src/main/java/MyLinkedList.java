/**
 * Created by prestonbattin on 2/24/17.
 */
public class MyLinkedList<L> {

   private Link head = null;
   private Link tail = null;
   private int count = 0;

    public Link getHead() {
        return head;
    }

    public Link getTail() {
        return tail;
    }

    public int size() {
        return count;
    }

    public void addFirst(Link<L> link){

        Link<L> temp = head;
        head = link;
        head.next = temp;

        if(count == 0){
            tail = head;
        }

        else{
            temp.previous = head;
        }
        count++;
    }

    public void addLast(Link<L> link){

        if(count == 0){
            head = link;
        }
        else{

            tail.next = link;
            link.previous = tail;
        }
        tail = link;
        count++;
    }

    public void removeLast(){

        if(count != 0){

            if(count == 1){
                head = null;
                tail = null;
            }
            else{
                tail.previous.next = null;
                tail = tail.previous;
                }

            count--;
        }
    }

    public void removeFirst(){

        if(count != 0){
            head = head.next;
            count--;
        }
        if(count == 0){
            tail = null;
        }
        else{
            head.previous = null;
        }
    }

    public void remove(int index) {


        Link<L> curr = head;

        if(curr!= null) {

            if (index < 1) {
                System.out.println("Out of bounds");
                return;
            }

            else if (index == count) {
                removeLast();
                return;
            }
            else if (index == 1){
                removeFirst();
                return;
            }


            else {
                for (int i = 1; i < index; i++) {
                    curr = curr.next;
                }


                curr.previous.next = curr.next;
            }

        }
        count--;


    }

    public boolean contains(Link<L> data){

        Link<L> temp = head;
        if(head == null)
            return false;

        for(int i = 1; i < count && temp.next != null; i++){

            if(temp.data.equals(data.data))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public int find(Link<L> data){

        Link<L> temp = head;
        int index = 1;
        if(head == null)
            return -1;

        for(int i = 1; i < count && temp.next != null; i++){

            if(temp.data.equals(data.data))
                return index;

            temp = temp.next;
            index++;

        }
        return -1;

    }

    public Link<L> get(int index){

        Link<L> temp = head;
        if(head == null)
            return null;

        for(int i = 1; i < index && temp.next != null; i++){

            temp = temp.next;
        }

        return temp;

    }

    public MyLinkedList<L> copy(){
        return this;
    }



}






