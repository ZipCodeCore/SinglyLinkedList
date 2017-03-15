package mattern.william;

import java.util.Collection;

/**
 * Created by williammattern on 2/24/17.
 */
public class PirateBar {
    Pirate[] pirateArray;
    PirateFactory pirateFactory = new PirateFactory();
    Pirate start;
    int size;

    private class Pirate{
        private int barStoolIndex;
        private int pointerInteger;
        private Pirate next;

        Pirate(int barStoolIndex,int pointerInteger){
            this.barStoolIndex = barStoolIndex;
            this.pointerInteger = pointerInteger;
        }

        public int getBarStoolIndex() {
            return barStoolIndex;
        }

        public void setBarStoolIndex(int barStoolIndex) {
            this.barStoolIndex = barStoolIndex;
        }

        public Pirate getNext() {
            return next;
        }

        public void setNext(Pirate next) {
            this.next = next;
        }

        public int byPointerInteger(){
            return pointerInteger;
        }
    }

    private class PirateFactory{
        public Pirate createPirate(int spot, int pointer){
            return new Pirate(spot,pointer);
        }

        public Pirate[] generatePirates(int[] inputArray){
            Pirate[] pirates = new Pirate[inputArray.length];
            for (int i =0; i < inputArray.length; i++){
                pirates[i] = createPirate(i,inputArray[i]);
            }
            return pirates;
        }
    }

    public int getLengthOfCycle(int[] pirateIntArray){
        return -1;
    }

    public Pirate find(int spot){
        for (Pirate pirate: pirateArray){
            if(pirate.barStoolIndex == spot){
                return pirate;
            }
        }
        throw new IndexOutOfBoundsException("Pirate not found");
    }

    public void linkAllPirates(int[] pirateInputArray){
        pirateArray = pirateFactory.generatePirates(pirateInputArray);
        for(Pirate pirate: pirateArray){
            pirate.setNext(find(pirate.byPointerInteger()));
        }
    }

    boolean detectCycle(){
        return false;
    }
}