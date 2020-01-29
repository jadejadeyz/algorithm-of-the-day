class Solution:
    def isPrime(self, n):
        x = 2
        while x**2 <= n:
            if n % x == 0:
                return False
            x += 1
        return True

s = Solution()
test = [2, 3, 4, 5, 6]
for case in test:
    print(s.isPrime(case))