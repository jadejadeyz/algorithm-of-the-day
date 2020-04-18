package hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriticalConnSolverTest {

    @Test
    void criticalConnections() {
        List<List<Integer>> connections = new ArrayList<>();
        int[][] edges = {{0,1}, {1,2}, {2,0}, {1,3}, {3, 4}, {4, 5}, {3, 5}};
        for (int[] e: edges) {
            List<Integer> pair = new ArrayList<>();
            pair.add(e[0]);
            pair.add(e[1]);
            connections.add(pair);
        }

        CriticalConnSolver solver = new CriticalConnSolver();
        solver.criticalConnections(6, connections);
    }
}