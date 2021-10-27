package homeworks.firth;

public class TestMain4 {

    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
//        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        LinkedDeque<Integer> linkedDeque = new LinkedDeque<>();
        linkedDeque.insertLeft(1);
        linkedDeque.insertLeft(2);
        linkedDeque.insertLeft(3);
        linkedDeque.insertLeft(4);
        linkedDeque.insertLeft(5);
        linkedDeque.insertLeft(6);
        linkedDeque.insertLeft(7);
        linkedDeque.insertLeft(8);
        linkedDeque.insertRight(9);
        linkedDeque.insertRight(10);
        linkedDeque.insertRight(11);

        linkedDeque.display();

        System.out.println("Find 1: " + linkedDeque.contains(1));
        System.out.println("Find 4: " + linkedDeque.contains(4));
        System.out.println("Find 4444: " + linkedDeque.contains(4444));


        linkedDeque.removeLeft();
        linkedDeque.removeLeft();

        linkedDeque.display();
        linkedDeque.removeRight();
        linkedDeque.removeRight();

        linkedDeque.display();



    }

}
