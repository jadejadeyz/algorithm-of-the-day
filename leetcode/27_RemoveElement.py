class Solution:
    def removeElement(self, nums, val: int) -> int:
        if not nums: # empty list
            return 0

        if len(nums) == 1:
            return 1 if nums[0] != val else 0


        i = 0
        while i < len(nums):
            if nums[i] == val:
                nums.pop(i)
            else:
                i += 1

        return len(nums)

a = [1]
v = 1
s = Solution()
print(s.removeElement(a, v))
