package homeworks.third;

import homeworks.third.deque.Deque;
import homeworks.third.deque.DequeImpl;

public class TestDeque {
    public static void main(String[] args) {
        testDeque();
    }

    private static void testDeque() {
        Deque<Integer> deque = new DequeImpl<>(5);
        System.out.println("add element: " + deque.insertLeft(34));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(12));
        deque.display();
        System.out.println("add element: " + deque.insertRight(20));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(16));
        deque.display();
        System.out.println("add element: " + deque.insertRight(14));
        deque.display();
        System.out.println("add element: " + deque.insertLeft(17));

        deque.display();
        System.out.println("remove: " + deque.removeRight());
        System.out.println("remove: " + deque.removeLeft());
        deque.display();

    }
}
