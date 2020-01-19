class Solution:
    def partition(self, arr, low, high):
        pivot = arr[high]
        i = low - 1
        for j in range(low, high):
            if arr[j] <= pivot:
                i += 1
                arr[i], arr[j] = arr[j], arr[i]

        arr[i+1], arr[high] = arr[high], arr[i+1]
        return i+1


    def quicksort(self, arr, low, high):
        if low < high:
            pivot = self.partition(arr, low, high)

            self.quicksort(arr, low, pivot-1)
            self.quicksort(arr, pivot+1, high)

test = [4, 1, 7, 8, 2, 5, 6]
s = Solution()
s.quicksort(test, 0, len(test)-1)
print(test)