def sortBinaryArray(arr):
    if not arr:
        return arr

    next_zero_idx = 0
    i = 0
    for i in range(len(arr)):
        if arr[i] == 0:
            arr[next_zero_idx] = 0
            next_zero_idx += 1

    for i in range(next_zero_idx, len(arr)):
        arr[i] = 1
    return arr

def arrangeEvenOdd(arr):
    if not arr:
        return arr

    left = 0
    right = len(arr) - 1

    while left <= right:
        if arr[left] % 2 == 0:
            left += 1

        if arr[right] % 2 == 1:
            right -= 1

        if left <= right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1

    return arr

test = [3, 2, 1, 4]

print(arrangeEvenOdd(test))