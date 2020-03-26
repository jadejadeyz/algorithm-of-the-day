package ca.algo.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LLMain {
    public static void main(String[] args) {
        JadeLinkedList<Integer> list = new JadeLinkedList<>(); // create an empty single linked list


        Integer[] nums = {1, 2, 3, 4, 5};

        for (int x : nums) {
            list.add(x);
        }

        list.remove(5);

        System.out.println(list);
    }
}
