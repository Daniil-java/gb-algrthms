package homeworks.third.deque;

import homeworks.third.deque.Deque;

public class DequeImpl<E> implements Deque<E> {

    protected final E[] data;
    protected int size = 0;
    protected int left = 0;
    protected int right = size - 1;



    public DequeImpl(int maxSize) {
        this.data = (E[])new Object[maxSize];
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }

        for (int i = size; i > left; i--) {
            data[i] = data[i-1];
        }
        data[left] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull()) {
            return false;
        }

        data[size] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }

        E value = data[0];
        for (int i = left; i < size; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;

        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }

        E value = data[size-1];
        data[size-1] = null;
        size--;

        return value;
    }

    @Override
    public E peekLeft() {
        return data[left];
    }

    @Override
    public E peekRight() {
        return data[right];
    }

    @Override
    public boolean insert(E value) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peekFront() {
        return data[right];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= size-1; i++) {
            sb.append(data[i]);
            if (i != size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
