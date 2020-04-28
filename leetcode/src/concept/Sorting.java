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

    public int[] mergeSort(int[] arr) {
        int[] result = arr.clone();
        mergesortHelper(result, arr, 0, arr.length-1);
        return result;
    }
    public void mergesortHelper(int[] result, int[] arr, int start, int end) {
        if (start == end)
            return;
        if (start + 1 == end) {
            int t1 = result[start];
            int t2 = result[end];
            result[start] = Math.min(t1, t2);
            result[end] = Math.max(t1, t2);
            return;
        }

        int mid = (start + end) / 2;
        mergesortHelper(arr, result, start, mid);
        mergesortHelper(arr, result, mid+1, end);

        merge(result, arr, start, end);
    }
    public void merge(int[] result, int[] arr, int start, int end) {
        int i = start;
        int left = start;
        int right = (start + end) / 2 + 1;
        while (right <= end && left <= (start + end) / 2) {
            if (arr[left] <= arr[right]) {
                result[i++] = arr[left];
                left++;
            }
            else {
                result[i++] = arr[right];
                right++;
            }
        }
        if (right > end) {
            while (left <= (start+end) / 2) {
                result[i++] = arr[left];
                left++;
            }
        }
        if (left > (start + end) / 2) {
            while (right <= end) {
                result[i++] = arr[right];
                right++;
            }
        }
    }
}
