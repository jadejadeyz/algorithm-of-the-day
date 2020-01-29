class Solution:
    def isPalindromePermutation(self, string):
        if not string:
            return True

        words = string.strip().split()
        string = ''.join(words)
        mapping = [0 for _ in range(26)]

        for c in string:
            mapping[ord(c) - ord('a')] += 1

        count_odd = 0
        for i in range(26):
            if mapping[i] != 0 and mapping[i] % 2 == 1:
                count_odd += 1

        if len(string) % 2 == count_odd:
            return True
        else:
            return False

if __name__ == "__main__":
    test = 'taco cai'
    solution = Solution()
    print(solution.isPalindromePermutation(test))

