package hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardProblemsTest {

    @Test
    void minWindow() {
        String S = "abbb";
        String T = "ab";
        MinWindowSubseqSolver solver = new MinWindowSubseqSolver();
        assertEquals("ab", solver.minWindow(S, T));
    }
}