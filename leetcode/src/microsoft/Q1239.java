package microsoft;

import java.util.ArrayList;
import java.util.List;

public class Q1239 {
    int max = -1;
    public int maxLength(List<String> arr) {
        backtrack(0, -1, arr);
        return max;
    }

    public void backtrack(int alpha, int id, List<String> candidates) {
        int available = getCandidates(candidates, id, alpha);

        if (available == 0) {
            max = Math.max(max, getLength(alpha));
            return;
        }
        else {
            for (int i = 0; i <= 16; i++){
                int bit = (available >> i) & 1;
                if (bit == 1)
                    backtrack(update(alpha, candidates.get(i)), i, candidates);
            }
        }
    }

    public int getLength(int alpha) {
        int length = alpha & 1;;
        while (alpha != 0) {
            alpha >>= 1;
            length += (alpha & 1);

        }
        return length;
    }

    public int update(int alpha, String str) {
        for (int i = 0; i < str.length(); i++) {
            int mask = 1 << (str.charAt(i) - 'a');
            alpha |= mask;
        }
        return alpha;
    }

    public int getCandidates(List<String> arr, int id, int alpha) {
        int available = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (i != id && isUnique(arr.get(i)) && notRepeat(arr.get(i), alpha))
                available |= (1 << i);
        }
        return available;
    }

    public boolean isUnique(String str) {
        if (str.length() == 1)
            return true;
        int bitmap = 0;
        for (int i = 0; i < str.length(); i++) {
            int outcome = bitmap ^ (1 << (str.charAt(i) - '0'));
            if (outcome == 0)
                return false;
            else
                bitmap |= outcome;
        }
        return true;
    }

    public boolean notRepeat(String str, int alpha) {
        for (int i = 0; i < str.length(); i++) {
            int mask = (1 << (str.charAt(i) - 'a')) & alpha;
            if (mask != 0)
                return false;
        }
        return true;
    }
}
