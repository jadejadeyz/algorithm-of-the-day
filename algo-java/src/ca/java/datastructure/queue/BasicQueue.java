package ca.java.datastructure.queue;

import java.util.Objects;

public class BasicQueue<T> {
    private T[] data;
    private int front, end;

    public BasicQueue() {
        this(1000);
    }

    public BasicQueue(int size) {
        data = (T[]) new Object[size];
        this.front = -1;
        this.end = -1;
    }


    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        }
        return end - front + 1;
    }

    public void enQue(T newItem) {
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("Queue is full!");
        }
        else if (size() == 0) {
            front++;
            end++;
            data[end] = newItem;
        }
        else {
            end++;
            data[end] = newItem;
        }
    }

    public T deQue() {
        T tempItem = null;
        if (this.size() == 0) {
            throw new IllegalStateException("Queue is empty!");
        }

        if (front == end) {
            tempItem = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        }
        else {
            tempItem = data[front];
            data[front] = null;
            front++;
        }
        return tempItem;
    }

    public boolean contains(T item) {
        if (front == -1 && end == -1) {
            return false;
        }

        for (int i = front; i <= end; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }

        return false;
    }

    public T access(T item) {
        T temp = null;
        if (front == end) {
            throw new IllegalStateException("No item in the queue!");
        }

        while (size() > 0) {
            temp = deQue();
            if (temp.equals(item)) {
                return temp;
            }
        }

        return null;
    }
}
