package ca.java.datastructure.stack;

import java.util.ArrayList;

public class ListStack<T> implements IStack<T> {
    private ArrayList<T> data;
    private Integer stackPoint;

    public ListStack() {
        data = new ArrayList<>();
        stackPoint = 0;
    }

    public void push(T newItem) {
        data.add(newItem);
        stackPoint++;
    }

    public T pop() {
        if (data.size() == 0) {
            throw new IllegalStateException("Empty stack!");
        }
        return data.get(--stackPoint);
    }

    public boolean contains(T item) {
        return data.contains(item);
    }

    public T access(T item) {
        while (stackPoint > 0) {
            T tempItem = this.pop();
            if (tempItem.equals(item)) {
                return item;
            }
        }
        return null;
    }
    public Integer size() {
        return stackPoint;
    }

}
