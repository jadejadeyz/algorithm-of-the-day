class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid):
        if len(obstacleGrid) == 0 or len(obstacleGrid[0]) == 0:
            return 0

        if obstacleGrid[0][0] == 1:
            return 0

        row = len(obstacleGrid)
        col = len(obstacleGrid[0])
        paths = [[1 for _ in range(col)] for _ in range(row)]

        for i in range(1, col):
            paths[0][i] = 1 if obstacleGrid[0][i] == 0 and paths[0][i - 1] else 0

        for i in range(1, row):
            paths[i][0] = 1 if obstacleGrid[i][0] == 0 and paths[i - 1][0] else 0

        for i in range(1, row):
            for j in range(1, col):
                if obstacleGrid[i][j] == 0:
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
                else:
                    paths[i][j] = 0
        return paths[row - 1][col - 1]


test = [[0,0,0],[0,1,0],[0,0,0]]
res = Solution()
print(res.uniquePathsWithObstacles(test))