package concept.backtrack;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> s = new ArrayList<>();
        backtrack(s, -1, target, candidates, res);
        List<List<Integer>> output = new ArrayList<>(res);
        return output;
    }

    public void backtrack(List<Integer> s, int prev, int target, int[] c, Set<List<Integer>> res) {
        if (target == 0) {
            // sort s and add to res
            Collections.sort(s);
            List<Integer> list = new ArrayList<>(s);
            res.add(list);
            s.remove(Integer.valueOf(prev));
        }
        else {
            List<Integer> candidates = generateCandidates(c, target);
            if (candidates.size() == 0) {
                s.remove(Integer.valueOf(prev));
                return;
            }
            for (int val: candidates) {
                s.add(val);
                backtrack(s, val, target - val, c, res);
            }
            s.remove(Integer.valueOf(prev));
        }
    }

    public List<Integer> generateCandidates(int[] c, int bound) {
        List<Integer> list = new ArrayList<>();
        for (int val: c) {
            if (val <= bound)
                list.add(val);
        }

        return list;
    }
}
