class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if not m or not n:
            return 0
        if m == 1 or n == 1:
            return 1

        paths = [[1 for _ in range(n)] for _ in range(m)]

        for i in range(1, m):
            for j in range(1, n):
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1]

        return paths[m - 1][n - 1]

test = input('case: ')
res = Solution()
while test != '.':
    test = [int(i) for i in test.split()]
    print(res.uniquePaths(test[0], test[1]))
    test = input('case: ')