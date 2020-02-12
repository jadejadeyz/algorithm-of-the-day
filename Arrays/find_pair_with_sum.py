def findPair(arr, n):
    if not arr:
        return None

    mapping = {}

    for i in arr:
        if n - i in mapping:
            return i, n-i
        mapping[i] = 1

    return None

def findAllPairs(arr, n):
    if not arr:
        return []

    mapping = {}
    result = {}

    for i in arr:
        if n - i in mapping:
            result[min(i, n-i)] = max(i, n-i)
        mapping[i] = 1

    return list(result.items())
    # return [(key, value) for key, value in result.items()]

arr = [8, 7, 2, 5, 3, 1, 8, 2, 5]
print(findAllPairs(arr, 10))