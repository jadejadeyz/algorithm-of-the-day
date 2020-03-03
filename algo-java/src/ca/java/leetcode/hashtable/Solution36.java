package ca.java.leetcode.hashtable;

import java.util.*;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        Set<String> cols = new HashSet<>();
        Set<String> rows = new HashSet<>();
        Set<String> grids = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (!cols.add("c" + j + " " + board[i][j])) {
                        return false;
                    }
                    if (!rows.add("r" + i + " " + board[i][j])) {
                        return false;
                    }
                    if (!grids.add("g" + i / 3 + " " + j / 3 + " " + board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
