package ca.java.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UseList {

    public static void main(String[] args) {
        List<Character> letters = new LinkedList<>();
        char[] chs = {'a', 'b', 'c', 'd', 'e'};
        for (char c : chs) {
            letters.add(c);
        }
        letters.add(0, 'w');
        System.out.println(letters);
    }
}
