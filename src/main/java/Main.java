
public class Main {
    public static void main(String[] args) {
        MyDataStructures<String> stringData = new MyDataStructures<>();
        stringData.add("Wes");
        stringData.add("Zach");
        stringData.add("Bob");
        stringData.add("Jim");
        stringData.add("Albert");

        System.out.println(stringData);

        stringData.sort();

        System.out.println(stringData);

    }

}
