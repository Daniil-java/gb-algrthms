package homeworks.fifth;

import java.util.LinkedHashSet;
import java.util.Set;

public class Backpack {

    public static final int BACKPACK_W = 5;
    static Set<Thing> set = new LinkedHashSet<>();

    public static Thing[] things = {
            new Thing("girya", 5, 50),
            new Thing("pen", 1, 100),
            new Thing("pen1", 2, 300),
            new Thing("pen2", 1, 200),
            new Thing("pen3", 3, 100),
            new Thing("pen4", 5, 100),
            new Thing("pen5", 4, 100),
            new Thing("pen6", 1, 100),
            new Thing("watch", 3, 100),
            new Thing("notebook", 3, 150)
    };

    public static void main(String[] args) {

        int cost = findBestCost(things.length-1, BACKPACK_W);

        System.out.println("Лучшая стоимость: " + cost);
        System.out.println("Лучший набор вещей: " + findBestThings(cost).toString());

    }

    public static int findBestCost(int size, int weight) {
        if (size < 0) {
            return 0;
        }
        if (things[size].getWeight() > weight) {
            return findBestCost(size-1, weight);
        }
        else {
            int a = findBestCost(size-1, weight);
            int b = findBestCost(size-1, weight - things[size].getWeight()) + things[size].getPrice();
            if (a >= b) {
                return a;
            } else {
                set.add(things[size]);
                return b;
            }
        }
    }
    
    public static StringBuilder findBestThings(int cost) {  //Возвращает строку с наилучшей комбинацией вещей
        Thing[] things_temp = new Thing[set.size()];
        things_temp = set.toArray(things_temp);
        int result = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder("[");
        while (result < cost) {
            sb.append(things_temp[things_temp.length - 1 - i]);
            result += things_temp[things_temp.length - 1 - i].getPrice();
            i++;
            if (result < cost) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb;
        
    }
}


