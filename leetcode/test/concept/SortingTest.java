package concept;

import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest {

    @Test
    void lambdaDemo() {
        Comparator<String> compString = (String s1, String s2) -> {
            return Integer.compare(s1.length(), s2.length()); };
        String[] strings = {};
        List<String> list = Arrays.asList("c", "avdsa", "abc", "ba");
        Collections.sort(list, compString);
        for (String s: list)
            System.out.println(s);
    }

    @Test
    void mergesort() {
        Sorting ms = new Sorting();
        int[] arr = {5, 1, 4, 2, 3};
        int[] result = ms.mergeSort(arr);
        int[] expected = {1, 2, 3, 4, 5};
        assertArrayEquals(expected, result);
    }

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