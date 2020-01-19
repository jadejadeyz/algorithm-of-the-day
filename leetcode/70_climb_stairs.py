"""
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
"""
class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 2

        res = [0 for _ in range(n)]
        res[0] = 1
        res[1] = 2
        for i in range(2, n):
            res[i] = res[i-1] + res[i-2]

        return res[n-1]

if __name__ == "__main__":
    test = input('step: ')
    solution = Solution()
    while test:
        test = int(test)
        print(solution.climbStairs(test))
        test = input('step:')
