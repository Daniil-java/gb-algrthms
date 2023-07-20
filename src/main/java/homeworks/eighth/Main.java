package homeworks.eighth;

public class Main {
    public static void main(String[] args) {
        ChainingHashMap map = new ChainingHashMap(4);
        map.insert(new Item(1));
        map.insert(new Item(2));
        map.insert(new Item(2));
        map.insert(new Item(3));
        map.insert(new Item(1));
        map.insert(new Item(1));


        map.display();

        map.delete(2);
        map.delete(2);
        map.delete(1);

        map.display();
    }
}
