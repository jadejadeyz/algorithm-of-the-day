package concept;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTypesTest {

    @Test
    void swap() {
        int[] arr = {1, 2, 3};
        int[] expected = {3, 2, 1};
        DataTypes.swap(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void generate() {
        int[] arr = DataTypes.generate(10);
        System.out.print("The returned arr addr: " + arr.toString());
    }
}