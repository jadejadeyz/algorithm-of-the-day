import numpy as np

def bubbleSort(arr):
    if not arr or len(arr) == 1:
        return arr

    length = len(arr)
    for i in range(length-1):
        for j in range(length-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

    return arr


def selectionSort(arr):
    for i in range(len(arr)):
        minimal = 0xffffffffffff
        min_idx = i
        for j in range(i, len(arr)):
            if arr[j] < minimal:
                minimal = arr[j]
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

    return arr


def mergeSort(arr):
    helper = [0 for _ in range(len(arr))]
    mergesort(arr, helper, 0, len(arr)-1)
    return arr


def mergesort(arr, helper, start, end):
    if start < end:
        mid = (start + end) // 2
        mergesort(arr, helper, start, mid)
        mergesort(arr, helper, mid+1, end)
        merge(arr, helper, start, mid, end)


def merge(arr, helper, start, mid, end):
    for i in range(start, end+1):
        helper[i] = arr[i]


    helperLeft = start
    helperRight = mid + 1
    current = start

    while helperLeft <= mid and helperRight <= end:
        if helper[helperLeft] < helper[helperRight]:
            arr[current] = helper[helperLeft]
            helperLeft += 1
        else:
            arr[current] = helper[helperRight]
            helperRight += 1

        current += 1

    remain = mid - helperLeft
    for i in range(remain+1):
        arr[current + i] = helper[helperLeft + i]


def quicksort(arr):
    return qsHelper(arr, 0, len(arr)-1)


def qsHelper(arr, left, right):
    split = partition(arr, left, right)
    if left < split - 1:
        qsHelper(arr, left, split-1)
    if right > split:
        qsHelper(arr, split, right)


def partition(arr, left, right):
    pivot = arr[(left+right) // 2]
    while left <= right:
        while arr[left] < pivot:
            left += 1
        while arr[right] > pivot:
            right -= 1

        if left <= right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1
    return left

a1 = np.random.randint(1, 100, 10)
# print(bubbleSort(a1))
# print(mergeSort(a1))
quicksort(a1)
print(a1)