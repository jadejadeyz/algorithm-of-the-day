def isDupOnce(arr):
    """

    :param arr: non-negative
    :return: the value that duplicates once
    """

    res = arr[0]
    for i in range(1, len(arr)):
        res ^= arr[i]

    return res == 1


def findRepeatOnceHash(arr):
    hashmap = set()
    for i in arr:
        if i in hashmap:
            return i
        hashmap.add(i)
    return None


test = [1, 2, 2]
print(isDupOnce(test))