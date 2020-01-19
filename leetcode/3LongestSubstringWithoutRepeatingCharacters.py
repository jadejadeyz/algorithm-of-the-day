class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0

        if len(s) == 1:
            return 1

        if len(s) == 2:
            return 2 if s[0] != s[1] else 1


        visited = {}
        left = 0
        max_length = 0

        for i in range(len(s)):
            if s[i] in visited and left <= visited[s[i]]:
                left = visited[s[i]] + 1
            else:
                max_length = max(max_length, i-left+1)

            visited[s[i]] = i

        return max_length

s = "dvdf"
ans = Solution()
print(ans.lengthOfLongestSubstring(s))
