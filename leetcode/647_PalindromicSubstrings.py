class Solution:
    def insert_char(self, s):
        res = ['#']
        res.extend('#'.join(list(s)))
        res.extend('#')
        return ''.join(res)


    def countSubstrings(self, s: str) -> int:
        if len(s) < 2:
            return len(s)

        if len(s) == 2:
            return 3 if s[0] == s[1] else 2


        original_length = len(s)
        s = self.insert_char(s)
        p = [0 for _ in range(len(s))]
        center = 0
        right = 0

        for i in range(len(s)):
            if i < right:
                mirror = 2*center - i
                p[i] = min(right - i, p[mirror])


            a = i - (p[i] + 1)
            b = i + (p[i] + 1)
            while a >= 0 and b < len(s) and s[a] == s[b]:
                p[i] += 1
                a -= 1
                b += 1

            if i + p[i] > right:
                center = i
                right = i + p[i]


        res = original_length

        for v in p:
            if v > 1:
                res += v // 2

        print(p)
        return res


s = "aaa"
ans = Solution()
print(ans.countSubstrings(s))
