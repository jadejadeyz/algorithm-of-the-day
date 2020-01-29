class Solution:
    def URLify(self, string):
        if not string:
            return ""

        words = string.strip().split()
        return '\%20'.join(words)


if __name__ == "__main__":
    test = "hello world       !    "
    solution = Solution()
    print(solution.URLify(test))