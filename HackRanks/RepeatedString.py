def repeatedString(s, n):
    countA = 0
    for c in s:
        if c == 'a':
            countA += 1

    extra = 0
    remaining = n % len(s)
    for c in s[:remaining]:
        if c == 'a':
            extra += 1

    return countA * (n // len(s)) + extra


s = 'a'
n = 10
print(repeatedString(s, n))