package ca.java.leetcode.hashtable;

import java.util.*;

public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> result = new HashSet<>();
        if (s != null && len > 10) {
            StringBuilder sb = new StringBuilder(s);
            Set<String> processedSet = new HashSet<>();

            for (int i = 0; i + 9 < len; i++) {
                String tmp = sb.substring(i, i + 10);

                if (processedSet.contains(tmp)) {
                    result.add(tmp);
                } else {
                    processedSet.add(tmp);
                }
            }
        }

        return new ArrayList<String>(result);
    }
}
