/**
 * Created by prestonbattin on 2/24/17.
 */
public class Link<L> {

    public L data;
    public Link<L> next;
    public Link<L> previous;

    public Link(L data){
        this.data = data;



    }


    @Override
    public String toString(){
        return data.toString();
    }

}
