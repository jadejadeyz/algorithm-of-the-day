package ca.java.leetcode.hashtable;

import java.util.*;

public class Solution49 {

    // Brute Force
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) {
//            return new ArrayList<>();
//        }
//
//        Map<String, List> map = new HashMap<String, List>();
//
//        for (String s: strs) {
//            char[] chStr = s.toCharArray();
//            Arrays.sort(chStr);
//            String key = String.valueOf(chStr);
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList());
//            }
//            map.get(key).add(s);
//        }
//
//        return new ArrayList(map.values());
//    }

    // To improve BF
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList();
        }

        Map<String, List> map = new HashMap<String, List>();

        for (String s: strs) {
            String sig = getCountSigniture(s);

            if (!map.containsKey(sig)) {
                map.put(sig, new ArrayList());
            }
            map.get(sig).add(s);
        }

        return new ArrayList(map.values());


    }

    private String getCountSigniture(String s) {
        Integer[] signiture = new Integer[26];
        Arrays.fill(signiture, 0);

        for (int i = 0; i < s.length(); i ++) {
            signiture[s.charAt(i) - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i: signiture) {
            sb.append(i);
        }

        return sb.toString();
    }
}
