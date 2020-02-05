def fib(n):
    if n == 0 or n == 1:
        return n

    ppr = 0
    pr = 1
    for i in range(2, n):
        result = pr + ppr
        ppr, pr = pr, result

    return pr + ppr

for i in range(0, 10):
    print(fib(i), end=' ')