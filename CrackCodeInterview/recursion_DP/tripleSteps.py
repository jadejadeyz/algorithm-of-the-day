def tripleSteps(n):
    if n < 0:
        return 0
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4
    return tripleSteps(n-1) + tripleSteps(n-2) + tripleSteps(n-3)

def countWays(n):
    if n < 0:
        return 0
    if n == 0:
        return 1
    return countWays(n-1) + countWays(n-2) + countWays(n-3)

def tripleStepsIter(n):
    if n == 1:
        return 1
    if n == 2:
        return 2
    if n == 3:
        return 4

    op1, op2, op3 = 1, 2, 4
    ways = 0
    for i in range(4, n):
        ways = op1 + op2 + op3
        op1, op2, op3 = op2, op3, ways

    return op1 + op2 + op3

def countWaysIter(n):
    if n < 0:
        return 0
    if n == 0:
        return 1
    op1, op2, op3 = 1, 0, 0
    for i in range(n):
        ways = op1 + op2 + op3
        op1, op2, op3 = op2, op3, ways

    return op1 + op2 + op3

n = 3
print(countWaysIter(n))