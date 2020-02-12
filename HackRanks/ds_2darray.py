#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the hourglassSum function below.
def hourglassSum(arr):
    max_value = -9 * 10
    for i in range(1, 5):
        for j in range(1, 5):
            total = 0
            total += getSum(arr, i, j)
            if max_value < total:
                max_value = total
    return max_value


def getSum(arr, i, j):
    result = arr[i][j]
    result += (arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1])
    result += (arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1])
    return result


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')
    #
    # arr = []
    #
    # for _ in range(6):
    #     arr.append(list(map(int, input().rstrip().split())))

    arr = [[1, 1, 1, 0, 0, 0],
           [0, 1, 0, 0, 0, 0],
           [1, 1, 1, 0, 0, 0],
           [0, 0, 2, 4, 4, 0],
           [0, 0, 0, 2, 0, 0],
           [0, 0, 1, 2, 4, 0]]

    result = hourglassSum(arr)
    print(result)

    # fptr.write(str(result) + '\n')
    #
    # fptr.close()
