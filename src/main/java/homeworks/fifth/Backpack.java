package homeworks.fifth;

import homeworks.firth.LinkedList;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class Backpack {

    public static final int BACKPACK_W = 5;
//    static CachedLinkedHashSet<Thing> set = new CachedLinkedHashSet<>();
    static Set<Thing> set = new LinkedHashSet<>();
    static Thing summ = new Thing("", 0, 0);

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

        System.out.println(toname(things.length-1, BACKPACK_W));
    }

    public static int toname(int size, int weight) {
        if (size < 0) {
            return 0;
        }
        if (things[size].getWeight() > weight) {
            return toname(size-1, weight);
        }
        else {
            int a = toname(size-1, weight);
            int b = toname(size-1, weight - things[size].getWeight()) + things[size].getPrice();
            if (a >= b) {
                return a;
            } else {
                set.add(things[size]);
                return b;
            }
        }
    }
}


