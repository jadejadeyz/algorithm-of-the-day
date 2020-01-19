class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1):
            return False

        s1map = [0 for _ in range(26)]
        for c in s1:
            s1map[ord(c) - ord('a')] += 1


        for i in range(0, len(s2)-len(s1)+1):
            s2map = [0 for _ in range(26)]
            for j in range(0, len(s1)):
                s2map[ord(s2[i+j]) - ord('a')] += 1
            if s1map == s2map:
                return True

        return False

s1 = "ab"
s2 = "eidbaooo"
ans = Solution()
print(ans.checkInclusion(s1, s2))
