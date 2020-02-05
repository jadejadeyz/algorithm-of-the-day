def magicIndex(array):
    if not array:
        return None
    for i in range(len(array)-1, -1, -1):
        if array[i] == i:
            return i

    return None

def magicIndex2(array, low, high):
    if not array:
        return None
    if low > high:
        return None

    mid = (low + high) // 2
    if array[mid] == mid:
        return mid
    if array[mid] > mid:
        return magicIndex2(array, low, mid-1)
    else:
        return magicIndex2(array, mid+1, high)


def magicIndexDup(array, low, high):
    if low > high:
        return None

    midIndex = (low + high) // 2
    midValue = array[midIndex]

    if midIndex == midValue:
        return midIndex

    leftIndex = min(midIndex-1, midValue)
    leftValue = magicIndexDup(array, low, leftIndex)
    if leftValue is not None and leftValue > 0:
        return leftValue

    rightIndex = max(midIndex+1, midValue)
    rightValue = magicIndexDup(array, rightIndex, high)
    return rightValue

test = [-6, -3, -2, 2, 4, 4, 8, 10]
print(magicIndexDup(test, 0, len(test)-1))