package microsoft;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q1239Test {

    @Test
    void maxLength() {
        List<String> arr = new ArrayList<>();
        String[] words = {"a","b","c","d","e","f","g","h","i","j","k"};
        for (String str: words)
            arr.add(str);
        Q1239 q1239 = new Q1239();
        assertEquals(11, q1239.maxLength(arr));
    }

    @Test
    void getCandidates() {
        Q1239 q1239 = new Q1239();
        List<String> arr = new ArrayList<>();
        arr.add("n");
        arr.add("b");
        arr.add("y");
        assertEquals(7, q1239.getCandidates(arr, -1, 0));

    }

    @Test
    void getLength() {
        int a = 7;
        Q1239 s = new Q1239();
        assertEquals(3, s.getLength(a));
    }

    @Test
    void alphaManipulate() {
        Q1239 s = new Q1239();
        assertEquals(false, s.notRepeat("uu", 1));
    }

    @Test
    void isUnique() {
        Q1239 s = new Q1239();
        assertEquals(false, s.isUnique("uu"));
        assertEquals(true, s.isUnique("ajs"));
    }

    @Test
    void notRepeat() {
        Q1239 s = new Q1239();
        assertEquals(false, s.notRepeat("d", 15));
        assertEquals(true, s.notRepeat("zn", 15));
    }
}