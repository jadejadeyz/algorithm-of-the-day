package concept;

import java.util.Comparator;

public class Sorting {
    public int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minId = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minId])
                    minId = j;
            }
            int tmp = arr[i];
            arr[i] = arr[minId];
            arr[minId] = tmp;
        }
        return arr;
    }

    public int[] minHeapify(int[] arr, int heapsize, int parent) {
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int minId = parent;
        if (left < heapsize && arr[left] < arr[minId])
            minId = left;
        if (right < heapsize && arr[right] < arr[minId])
            minId = right;
        if (minId != parent) {
            // swap arr[minId] with arr[parent]
            int tmp = arr[minId];
            arr[minId] = arr[parent];
            arr[parent] = tmp;
            // subtree rooted at minId may break the min-heap property
            minHeapify(arr, heapsize, minId);
        }
        return arr;
    }

    public int buildMinHeap(int[] arr) {
        int heapsize = arr.length;
        for (int i = heapsize/2; i >= 0; i--)
            minHeapify(arr, heapsize, i);

        return arr[0];
    }

    public int findKthSmallest(int[] arr, int k)  {
        if (k > arr.length)
            return -1;
        buildMinHeap(arr);
        int heapsize = arr.length;
        for (int i = 0; i < k; i++) {
            heapsize--;
            int temp = arr[heapsize];
            arr[heapsize] = arr[0];
            arr[0] = temp;
            minHeapify(arr, heapsize, 0);
        }
        return arr[heapsize];
    }
}
