#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'dynamicArray' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY queries
#

def dynamicArray(n, queries):
    # Write your code here
    seqList = [[] for _ in range(n)]
    last_answer = 0
    result = []
    for q in queries:
        if q[0] == 1:
            doQuery1(seqList, q, last_answer)
        if q[0] == 2:
            last_answer = doQuery2(seqList, q, last_answer)
            result.append(last_answer)

    return result


def doQuery1(seqList, query, last_answer):
    seq_idx = (query[1] ^ last_answer) % len(seqList)
    seqList[seq_idx].append(query[2])


def doQuery2(seqList, query, last_answer):
    seq_idx = (query[1] ^ last_answer) % len(seqList)
    value_idx = query[2] % len(seqList[seq_idx])
    return seqList[seq_idx][value_idx]


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')
    #
    # first_multiple_input = input().rstrip().split()
    #
    # n = int(first_multiple_input[0])
    #
    # q = int(first_multiple_input[1])

    queries = [[1, 0, 5],
               [1, 1, 7],
               [1, 0, 3],
               [2, 1, 0],
               [2, 1, 1]]

    # for _ in range(q):
    #     queries.append(list(map(int, input().rstrip().split())))

    result = dynamicArray(2, queries)
    print(result)

    # fptr.write('\n'.join(map(str, result)))
    # fptr.write('\n')
    #
    # fptr.close()
