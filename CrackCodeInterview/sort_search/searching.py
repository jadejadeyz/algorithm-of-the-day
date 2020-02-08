def binarySearch(arr, x):
    return binaryHelper(arr, x, 0, len(arr)-1)

def binaryHelper(arr, x, left, right):
    if left < right:
        mid = (left + right) // 2
        if arr[mid] == x:
            return arr[mid]
        elif arr[mid] < x:
            binaryHelper(arr, x, mid+1, right)
        else:
            binaryHelper(arr, x, left, mid-1)
    else:
        return None

def binarySearchIterative(arr, x):
    left = 0
    right = len(arr)-1

    while left <= right:
        mid = (left + right) // 2
        if arr[mid] < x:
            left = mid + 1
        elif arr[mid] > x:
            right = mid - 1
        else:
            return arr[mid]

    return None



a = [i for i in range(12)]
print(binarySearchIterative(a, 9))