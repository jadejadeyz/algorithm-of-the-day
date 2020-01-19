"""
Assume you are an awesome parent and want to give your children some cookies.
But, you should give each child at most one cookie.
Each child i has a greed factor gi,
which is the minimum size of a cookie that the child will be content with;
and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i,
and the child i will be content.
Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive.
You cannot assign more than one cookie to one child.
"""

# this is similiar to the memory allocation
# smallest first suit
class Solution:
    def findContentChildren(self, g, s) -> int:
        g.sort()
        s.sort()
        i = 0
        j = 0
        count = 0

        while j < len(s) and i < len(g):
            if s[j] >= g[i]:
                i += 1
            j += 1

        return i


if __name__ == "__main__":
    s = input('cookies: ')
    g = input('children: ')
    res = Solution()
    while s != '.':
        s = [int(i) for i in s.split()]
        g = [int(i) for i in g.split()]

        print(res.findContentChildren(g, s))

        s = input('cookies: ')
        g = input('children: ')

