def insertBits(m, n, i, j):
    # clears bits through j to i in m
    for bit in range(i, j+1):
        mask = ~(1 << bit)
        m &= mask

    for bit in range(j - i + 1):
        value = 1 if n & (1 << bit) else 0
        if value == 1:
            m |= (value << i+bit)

    return m

print(insertBits(int('1000000000', 2), int('10011', 2), 2, 6))
print(int('10001001100', 2))