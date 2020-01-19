class Solution:
    def removeDuplicates(self, nums) -> int:
        if len(nums) < 2:
            return len(nums)

        i = 1
        while i < len(nums):
            if nums[i] == nums[i-1]:
                nums.pop(i)
            else:
                i += 1


        return len(nums)


nums = [1, 1, 2]
s = Solution()
print(s.removeDuplicates(nums))
