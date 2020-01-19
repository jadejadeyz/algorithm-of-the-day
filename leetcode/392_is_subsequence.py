"""
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t.
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string
by deleting some (can be none) of the characters without disturbing
the relative positions of the remaining characters.
(ie, "ace" is a subsequence of "abcde" while "aec" is not).
"""

class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s or not t:
            return False
        if len(s) > len(t):
            return False

        i = 0
        j = 0
        while j < len(s) and i < len(t):
            if s[j] == t[i]:
                j += 1
                i += 1
            else:
                i += 1

        if j == len(s) and i <= len(t):
            return True
        else:
            return False


if __name__ == "__main__":
    s = input('s: ')
    t = input('t: ')
    result = Solution()
    while s != '.':
        print(result.isSubsequence(s, t))
        s = input('s: ')
        t = input('t: ')