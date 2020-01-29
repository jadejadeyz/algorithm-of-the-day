class Solution:
    def checkPermutation(self, s, t):
        """ decide if s is a permutation of t """
        if not s and not t:
            return True

        if len(s) != len(t):
            return False

        mapping = {}
        for c_s, c_t in zip(s, t):
            mapping[c_s] = mapping.get(c_s, 0) + 1
            mapping[c_t] = mapping.get(c_t, 0) - 1

        for key in mapping:
            if mapping[key] != 0:
                return False

        return True


if __name__ == "__main__":
    test_s = "abc"
    test_t = "bcy"

    solution = Solution()
    print(solution.checkPermutation(test_s, test_t))

