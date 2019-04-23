def binary_sum(A, B):
    C = [0] * (len(A) + 1)
    overing = 0
    for i in range(len(A) - 1, -1, -1):
        C[i+1] = (A[i] + B[i] + overing) % 2
        overing = (A[i] + B[i] + overing) // 2
    C[0] = overing
    return C


A = [1, 1, 0, 1]
B = [1, 1, 1, 1]

