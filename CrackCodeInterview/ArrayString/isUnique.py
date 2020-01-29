class Solution:
    def isUnique(self, s):
        """ using sorting """
        if not s:
            return true

        if len(s) == 1:
            return true

        sorted_string = sorted(s)
        for i in range(1, len(sorted_string)):
            if sorted_string[i] == sorted_string[i-1]:
                return False

        return True


if __name__ == "__main__":
    solution = Solution()

    test = "abc"
    print(solution.isUnique(test))