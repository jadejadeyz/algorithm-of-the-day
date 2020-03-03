package ca.java.datastructure.stack;

public class BasicStack<T> implements IStack<T>{
    private T[] data; // to hold the data in the stack
    private Integer stackPoint;

    public BasicStack() {
        data = (T[]) new Object[1000];
        stackPoint = 0;
    }

    public void push(T newItem) {
        data[stackPoint++] = newItem;
    }

    public T pop() {
        if (stackPoint == 0) {
            throw new IllegalStateException("No more item on the stack!");
        }
        return data[--stackPoint];
    }

    public boolean contains(T item) {
        boolean found = false;

        for (int i = 0; i < stackPoint; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }

        return found;
    }

    public T access(T item) {

        while (stackPoint > 0) {
            T tempItem = this.pop();
            if (tempItem.equals(item)) {
                return tempItem;
            }
        }
        return null;
    }

    public Integer size() {
        return stackPoint;
    }
}
