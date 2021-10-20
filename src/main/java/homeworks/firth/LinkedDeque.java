package homeworks.firth;

import homeworks.third.deque.Deque;

public class LinkedDeque<E> implements Deque {

    public final TwoSideLinkedListImpl<E> data;

    public LinkedDeque() {
        this.data = new TwoSideLinkedListImpl<>();
    }

    @Override
    public boolean insertLeft(Object value) {
        data.beforeLast = data.last;
        data.insertFirst((E) value);
        return true;
    }

    @Override
    public boolean insertRight(Object value) {
        data.beforeLast = data.last;
        data.insertLast((E) value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        data.last = data.beforeLast;
        return (E) data.last;
    }

    @Override
    public Object peekLeft() {
        return data.first;
    }

    @Override
    public Object peekRight() {
        return data.last;
    }

    @Override
    public boolean insert(Object value) {
        return false;
    }

    @Override
    public Object remove() {
        return false;
    }



    @Override
    public Object peekFront() {
        return data.first;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }
    public boolean contains(E value) {
        LinkedList.Node<E> current = data.first;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

}
