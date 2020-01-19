class Solution:
    def isValid(self, s: str) -> bool:
        if not s or len(s) % 2 :
            return False

        # use stack
        stack = []
        stack.append(s[0])

        for i in range(1, len(s)):
            if len(stack) == 0:
                stack.append(s[i])
                continue

            if stack[-1] == '(' and s[i] == ')':
                stack.pop()
            elif stack[-1] == '{' and s[i] == '}':
                stack.pop()
            elif stack[-1] == '[' and s[i] == ']':
                stack.pop()
            else:
                stack.append(s[i])

        if len(stack) == 0:
            return True
        else:
            return False

s = "{}()[]"
ans = Solution()
print(ans.isValid(s))
