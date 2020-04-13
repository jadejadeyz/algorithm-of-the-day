package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolverTests {

    @Test
    void calLastStoneWeight() {
        int[] stones = {3};
        LastStoneWeightSolver solver = new LastStoneWeightSolver();
        assertEquals(3, solver.lastStoneWeight(stones));
    }

    @Test
    void getMinPaintHouseCostTest() {
        int[][] costs = {{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}};
//        int[][] costs = {{10, 20, 10}};
        PaintHouseSolver solver = new PaintHouseSolver();
        assertEquals(43, solver.minCost(costs));
    }
}