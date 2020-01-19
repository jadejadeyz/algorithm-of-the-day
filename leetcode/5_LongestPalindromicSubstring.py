class Solution:
    def insert_char(self, s):
        chars = ['#']
        chars.extend('#'.join(list(s)))
        chars.append('#')
        return ''.join(chars)


    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0:
            return ""

        if len(s) == 1:
            return s

        if len(s) == 2 and s[0] == s[1]:
            return s

        if len(s) == 2 and s[0] != s[1]:
            return ""

        s = self.insert_char(s)
        P = [0 for _ in range(len(s))]

        max_length = 0
        center = 0
        right = 0

        for i in range(len(s)):
            if i < right:
                mirror = 2*center - i
                P[i] = min(right - i, P[mirror])

            a = i - (1 + P[i])
            b = i + (1 + P[i])
            while a >= 0 and b < len(s) and s[a] == s[b]:
                P[i] += 1
                a -= 1
                b += 1


            if i + P[i] > right:
                center = i
                right = i + P[i]
                left = i - P[i]

                if P[i] > max_length:
                    max_length = P[i]
                    max_center = i


        res = ''.join(s[max_center-max_length:max_center+max_length+1].split('#')[1:-1])
        return res


s = "bbbab"
ans = Solution()
res = ans.longestPalindrome(s)
print(res)
# print(list(s))
# print(ans.insert_char(s))
