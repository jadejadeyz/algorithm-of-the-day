class Solution:
    def maxSubArray(self, nums) -> int:
        if not nums:
            return 0

        return self.findMaxSubArray(nums, 0, len(nums)-1)


    def linearMaxSubArray(self, nums):
        if not nums:
            return -1

        cursum = nums[0]
        maxsum = nums[0]
        for n in nums:
            cursum += n
            if cursum < n:
                cursum = n
            if cursum > maxsum:
                maxsum = cursum

        return maxsum


    def findMaxSubArray(self, nums, low, high):
        if low == high: # only one item
            return nums[low]
        else:
            mid = (low+high) // 2
            left_sum = self.findMaxSubArray(nums, low, mid)
            right_sum = self.findMaxSubArray(nums, mid+1, high)
            cross_sum = self.crossMaxSubArray(nums, low, mid, high)

            return max(max(left_sum, right_sum), cross_sum)


    def crossMaxSubArray(self, nums, low, mid, high):
        left_max = -0xffffffffffffffff
        cursum = 0
        for i in range(mid, low-1, -1):
            cursum += nums[i]
            if cursum > left_max:
                left_max = cursum

        right_max = -0xffffffffffffffff
        cursum = 0
        for i in range(mid+1, high+1):
            cursum += nums[i]
            if cursum > right_max:
                right_max = cursum


        return left_max + right_max

n = [-2,1,-3,4,-1,2,1,-5,4]
s = Solution()
print(s.linearMaxSubArray(n))
