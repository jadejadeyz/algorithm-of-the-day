package concept;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void selectionSort() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Sorting s = new Sorting();
        assertArrayEquals(expected, s.selectionSort(arr));
    }

    @Test
    void buildMinHeap() {
        int[] arr = {5,4,3,2,1};
        Sorting s = new Sorting();
        assertEquals(1, s.buildMinHeap(arr));
    }

    @Test
    void findKthSmallest() {
        int[] arr = {5,4,3,2,1};
        Sorting s = new Sorting();
        assertEquals(3, s.findKthSmallest(arr, 3));
    }

}