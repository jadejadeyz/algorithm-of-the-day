from collections import defaultdict
class Solution:
    def findShortestSubArray(self, nums) -> int:
        if not nums:
            return -1

        if len(nums) == 1:
            return 1

        freq_table = defaultdict(list)

        for id, num in enumerate(nums):
            freq_table[num].append(id)

        len_dict = {}

        for key in freq_table:
            if len(freq_table[key]) in len_dict:
                len_dict[len(freq_table[key])] = min(len_dict[len(freq_table[key])], freq_table[key][-1] - freq_table[key][0] + 1)
            else:
                len_dict[len(freq_table[key])] = freq_table[key][-1] - freq_table[key][0] + 1
        return len_dict[max(len_dict.keys())]



test = [1,2,2,3,1,4,2]
s = Solution()
print(s.findShortestSubArray(test))
