package ca.java.collections;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UseSet {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Integer i1 = 10;
        Integer i2 = 10;

        System.out.println(i1.hashCode() == i2.hashCode());

        set.add(1);
        set.add(3);
        set.add(2);

        set2.add(1);
        set2.add(3);
        set2.add(2);
        System.out.println(set.equals(set2));



    }
}
