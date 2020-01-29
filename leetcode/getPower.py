class Solution:
    def power(self, a, b):
        product = 1
        for i in range(b):
            product *= a

        return product

s = Solution()
a, b = 3, 4
print(s.power(a, b))