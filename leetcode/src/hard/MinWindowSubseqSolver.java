package hard;

public class MinWindowSubseqSolver {
    public String minWindow(String S, String T) {
        if (S.length() < T.length())
            return "";

        int globalMin = S.length();
        int leftMost = S.length();
        int nextRightMost = S.length();
        int currentRight = S.length() - 1;
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (nextRightMost + 1 >= T.length()) {
            nextRightMost = -1;
            while (i >= 0 && j >= 0) {
                if (S.charAt(i) == T.charAt(T.length() - 1) && j != T.length() - 1)
                        nextRightMost = i > nextRightMost? i: nextRightMost;
                if (S.charAt(i) == T.charAt(j)) {
                    if (j == T.length() - 1)
                        currentRight = i;
                    j--;
                }
                i--;
            }
            if (j == -1)
            {
                int curLength = currentRight - i;
                if (curLength < globalMin) {
                    globalMin = curLength;
                    leftMost = i+1;
                }
                if (curLength == globalMin)
                    leftMost = i+1 < leftMost? i+1 : leftMost;
            }
            while (i >= 0 && nextRightMost == -1) {
                if (S.charAt(i) == T.charAt(T.length() - 1)) {
                    nextRightMost = i;
                    break;
                }
                i--;
            }

            j = T.length() - 1;
            i = nextRightMost;
        }

        if (leftMost != S.length())
            return S.substring(leftMost, leftMost + globalMin);
        else
            return "";
    }
}
