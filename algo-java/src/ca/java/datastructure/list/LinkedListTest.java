package ca.java.datastructure.list;

public class LinkedListTest {
    public static void main(String[] args) {
        BasicLinkedList<Integer> list = new BasicLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.insert(5, 2);
        list.removeAt(1);
        System.out.println(list.size());
        System.out.println(list.toString());
    }
}
