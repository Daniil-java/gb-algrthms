package homeworks.second;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Notebook {
    private int price;
    private int memory;
    private String name;

    //Lenuvo > Asos > MacNote > Eser > Xamiou

    private static Map<String, Integer> names = new HashMap<String, Integer>() {{
        put("Lenuvo", 5);
        put("Asos", 4);
        put("MacNote", 3);
        put("Eser", 2);
        put("Xamiou", 1);
    }};

    public Notebook(int price, int memory, String name) {
        this.price = price;
        this.memory = memory;
        this.name = name;
    }

    public Notebook(int price, int memory) {
        this.price = price;
        this.memory = memory;
    }

    public int getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public String getName() {
        return name;
    }

    public boolean compareTo(Notebook second) {
        if (this.getPrice() > second.getPrice()) {
            return true;
        } else if(this.getPrice() < second.getPrice()) {
            return false;
        } else if(this.getMemory() > second.getMemory()) {
            return true;
        } else if (this.getMemory() < second.getMemory()) {
            return false;
        } else if (names.get(this.getName()) > names.get(second.getName())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "price=" + price +
                ", memory=" + memory +
                ", name='" + name + '\'' +
                '}';
    }
}
