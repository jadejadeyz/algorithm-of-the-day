def insert_sort(seq):
    for i in range(1, len(seq)):
        pivot = seq[i]
        j = i - 1
        while (j >= 0 and seq[j] > pivot):
            seq[j + 1] = seq[j]
            j -= 1
        seq[j + 1] = pivot


def insert_sort2(seq):
    """ non-increasing version"""
    for i in range(1, len(seq)):
        pivot = seq[i]
        j = i - 1
        while (j >= 0 and seq[j] < pivot):
            seq[j + 1] = seq[j]
            j -= 1
        seq[j + 1] = pivot

test = [5, 2, 4, 6, 1, 3]
test2 = [31, 41, 59, 26, 41, 58]
insert_sort2(test)
print(test)