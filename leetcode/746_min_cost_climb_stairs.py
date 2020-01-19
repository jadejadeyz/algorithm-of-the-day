class Solution:
    def minCostClimbingStairs(self, cost):
        if not cost:
            return 0
        if len(cost) == 1:
            return cost[0]
        if len(cost) == 2:
            return min(cost)

        # if start at index
        total = [0 for _ in range(len(cost))]
        total[0] = cost[0]
        total[1] = min(cost[0], cost[1])
        for i in range(2, len(cost)):
            total[i] = min(total[i-1], total[i-2])

        return min(total[-1], total1[-1])

test = input('case: ')
res = Solution()
while test != '.':
    test = [int(i) for i in test.split()]
    print(res.minCostClimbingStairs(test))
    test = input('case: ')