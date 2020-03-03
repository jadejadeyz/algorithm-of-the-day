package ca.java.datastructure.stack;

public interface IStack<T> {
    public void push(T newItem);
    public T pop();
    public boolean contains(T item);
    public T access(T item);
    public Integer size();
}
