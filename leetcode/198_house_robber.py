class Solution:
    def rob(self, nums):
        if not nums:
            return 0

        if len(nums) < 3:
            return max(nums)

        robbery = [0 for _ in range(len(nums))]

        robbery[0] = nums[0]
        robbery[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            robbery[i] = max(robbery[i-2] + nums[i], robbery[i-1])

        return robbery[-1]

if __name__ == "__main__":
    test = input('case: ')
    result = Solution()
    while test:
        test = [int(i) for i in test.split()]
        print(result.rob(test))
        test = input('case: ')
