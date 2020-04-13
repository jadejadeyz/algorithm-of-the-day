package google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithAtMost2DistCharSolver {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.isEmpty())
            return 0;

        int maximum = -1;
        int curLen = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (set.size() < 2) {
                curLen++;
                set.add(s.charAt(i));
            }
            else if (set.size() == 2 && set.contains(s.charAt(i))) {
                curLen++;
            }
            else {
                curLen = 1;
                int j = i - 1;
                while (j >= 0 && s.charAt(j) == s.charAt(i-1)) {
                    curLen++;
                    j--;
                }
                set.remove(s.charAt(j));
                set.add(s.charAt(i));
            }

            if (curLen > maximum)
                maximum = curLen;
        }

        return maximum;
    }

    public static void main(String[] args) {
        LongestSubStringWithAtMost2DistCharSolver s = new LongestSubStringWithAtMost2DistCharSolver();
        int res = s.lengthOfLongestSubstringTwoDistinct("eceba");
        System.out.print(res);
    }
}
