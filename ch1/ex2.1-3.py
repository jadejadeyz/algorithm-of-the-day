def linear_search(seq, x):
    res = None
    for i in range(len(seq)):
        if seq[i] == x:
            res = i
            break
    return res


def linear_search2(seq, x):
    """ while version"""
    i = 0
    while i < len(seq) and seq[i] != x:
        i += 1

    if i == len(seq):
        return None
    else:
        return i

test = [1, 2, 4, 5, 3]
output = linear_search2(test, 3)
print(output)
