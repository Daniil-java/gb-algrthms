package homeworks.eighth;

import java.util.LinkedList;

public class ChainingHashMap {
    private LinkedList<Item>[] chList;
    private int size;
    private final Item NON_ITEM = new Item(-1);

    public ChainingHashMap(int size) {
        this.size = size;
        chList = new LinkedList[this.size];
        for (int i = 0; i < chList.length; i++) {
            chList[i] = new LinkedList<>();
        }
    }

    public int hashFunc(int key){
        return key % size;
    }

    public Item find(int key) {
        int hashVal = hashFunc(key);
        for (Item item: chList[hashVal]) {
            if (item.getKey() == key) {
                return item;
            }
        }
        return NON_ITEM;
    }

    public boolean insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        chList[hashVal].add(item);
        return true;
    }

    public boolean delete(int key) {
        int hashVal = hashFunc(key);
        for (Item item: chList[hashVal]) {
            if (item.getKey() == key) {
                chList[hashVal].remove(item);
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (LinkedList list : chList) {
            for (Object o : list) {
                System.out.print(o.toString() + " ");
            }
            System.out.println();
        }
    }
}

