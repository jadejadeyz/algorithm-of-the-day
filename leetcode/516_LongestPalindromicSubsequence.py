class Solution:
    def LCS(self, x):
        length = len(x)
        table = [[0 for _ in range(length+1)] for _ in range(length+1)]
        for i in range(1, length+1):
            for j in range(length, 0, -1):
                if x[i-1] == x[j-1]:
                    table[i][length+1-j] = table[i-1][length+1-j-1] + 1
                else:
                    table[i][length+1-j] = max(table[i][length+1-j-1], table[i-1][length+1-j])

        return table[i][length+1-j]


    def longestPalindromeSubseq(self, s: str) -> int:
        if len(s) < 2:
            return len(s)

        if len(s) == 2:
            return 1 if s[0] != s[1] else len(s)

        return self.LCS(s)

s = "f"
ans = Solution()
# print(ans.LCS('abcbdab', 'bdcaba'))
print(ans.longestPalindromeSubseq(s))
