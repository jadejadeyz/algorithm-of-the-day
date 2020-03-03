package ca.java.leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] test = {"eat","tea","tan","ate","nat","bat"};
//        Scanner scanner = new Scanner(System.in);
        Solution49 s = new Solution49();

        System.out.println(s.groupAnagrams(test));
    }
}
