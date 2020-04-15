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

    @Test
    void testLFUCache() {
        LFUCache cache = new LFUCache(10);

        /*
        [13,2],[12]]
         */

        cache.put(7, 28);
        cache.put(7, 1);
        cache.put(8, 15);
        cache.get(6);
        cache.put(10, 27);
        cache.put(8, 10);
        cache.get(8);
        cache.put(6, 29);
        cache.put(1, 9);
        cache.get(6);
        cache.put(10, 7);
        cache.get(1);
        cache.get(2);
        cache.get(13);
        cache.put(8, 30);
        cache.put(1, 5);
    }
}