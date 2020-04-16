package concept.backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackTest {

    @Test
    void combinationSum() {
        CombinationSum solution = new CombinationSum();
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        solution.combinationSum(arr, target);
    }
}