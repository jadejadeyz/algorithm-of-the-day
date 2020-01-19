class Solution:
    def minPathSum(self, grid):
        if not grid or not len(grid[0]):
            return 0

        row = len(grid)
        col = len(grid[0])

        for i in range(1, row):
            grid[i][0] += grid[i-1][0]

        for i in range(1, col):
            grid[0][i] += grid[0][i-1]

        for i in range(1, row):
            for j in range(1, col):
                grid[i][j] = min(grid[i-1][j], grid[i][j-1]) + grid[i][j]


        return grid[row-1][col-1]


test = [[6,3,1],[2,5,1],[1,2,1]]
s = Solution()
print(s.minPathSum(test))

